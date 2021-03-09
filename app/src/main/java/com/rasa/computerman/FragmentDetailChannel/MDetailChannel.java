package com.rasa.computerman.FragmentDetailChannel;

import android.content.Context;
import android.util.Log;

import com.rasa.computerman.Utils.Model.BannerAndDefaultItem;
import com.rasa.computerman.WebService.Groups.GetBanner.GetBanner;
import com.rasa.computerman.WebService.Groups.GetBanner.Model.Extra_getBannerGroups;
import com.rasa.computerman.WebService.Groups.GetBanner.Model.ResponseGetBanner;
import com.rasa.computerman.WebService.Groups.GetBanner.iGetBanner;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.GetMediaSubGroup;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.Extra_getMediaSubGroup;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.ResponseGetMediaSubGroup;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.iGetMediaSubGroup;

import java.util.ArrayList;
import java.util.List;

public class MDetailChannel implements iM_detailChannel {


    List<Extra_getBannerGroups> extra_getBannerGroups;
    List<Extra_getMediaSubGroup> extra_getMediaSubGroups;
    List<BannerAndDefaultItem> bannerAndDefaultItems;





    private com.rasa.computerman.FragmentDetailChannel.iP_detailChannel iP_detailChannel;

    public MDetailChannel(iP_detailChannel iP_detailChannel) {
        this.iP_detailChannel = iP_detailChannel;
        extra_getBannerGroups = new ArrayList<>();

        extra_getMediaSubGroups = new ArrayList<>();

        bannerAndDefaultItems = new ArrayList<>();

    }


    @Override
    public Context getContext() {
        return iP_detailChannel.getContext();
    }

    @Override
    public void sendRequest_getBannerGroup(final int id) {


        new GetBanner(new iGetBanner.iResult() {
            @Override
            public void onSuccessGetBanner(ResponseGetBanner GetBanner) {
                extra_getBannerGroups = GetBanner.getExtra();

                Log.d("sizeis", "onSuccessGetBanner: "+extra_getBannerGroups.size());



                getMediaSubGroup(id);


            }

            @Override
            public void onFailedGetBanner(int errorId, String ErrorMessage) {

                iP_detailChannel.onFailedGetList(errorId, ErrorMessage);
            }
        }).doGetBanner(id);


    }

    public void getMediaSubGroup(final int id) {


        new GetMediaSubGroup(new iGetMediaSubGroup.iResult() {

            @Override
            public void onSuccessGetMediaSubGroup(ResponseGetMediaSubGroup getMediaSubGroup) {
                extra_getMediaSubGroups = getMediaSubGroup.getExtra();


                buildResultList(extra_getBannerGroups.size(),extra_getMediaSubGroups.size());



                iP_detailChannel.onSuccessGetList();

//                int a = 0;
//                int b = 0;
//
//                int size=responseGetBanner.getExtra().size() + responseGetMediaSubGroup.getExtra().size();
//
//                for (int i = 0; i < size; i++) {
//
//                   // Log.i("hadi", "onSuccessGetMediaSubGroup: "+(responseGetBanner.getExtra().size() + responseGetMediaSubGroup.getExtra().size()));
//
//                    if (listBanner.get(b) != null) {
//                        bannerAndDefaultItems.add(listBanner.get(b));
//                        b++;
//                    }
//                    if (itemDefaults.get(a) != null) {
//                        bannerAndDefaultItems.add(itemDefaults.get(a));
//                        a++;
//                    }
//                }

            }

            @Override
            public void onFailedGetMediaSubGroup(int errorId, String ErrorMessage) {
                iP_detailChannel.onFailedGetList(errorId, ErrorMessage);

            }
        }).doGetMediaSubGroup(0, 1000, id);


    }


    @Override
    public int getArrCount_extraGetMediaSubGroup() {

        return extra_getMediaSubGroups.size();
      //  return responseGetMediaSubGroup.getExtra().size();
        // or    return itemDefaults.size();
    }

    @Override
    public Extra_getMediaSubGroup getChildAt_extras(int position) {


        return bannerAndDefaultItems.get(position).getMediaList();

        // return itemDefaults.get(position).getMediaList();
        // return responseGetMediaSubGroup.getExtra().get(position);

    }

    @Override
    public int getArrCount_detailItemDefault(int position) {


        return bannerAndDefaultItems.get(position).getMediaList().getMedias().size();

        //return itemDefaults.get(position).getMediaList().getMedias().size();
        // return responseGetMediaSubGroup.getExtra().get(position).getMedias().size();
    }


    @Override
    public int getItemType(int position) {
        //  Log.d("TAG", "getItemType: "+position);
        // Log.d("TAG", "getItemType: "+(listBanner.get(position).getBanners()==null));
        // Log.d("TAG", "getItemType: "+new Gson().toJson(listBanner.get(position).getBanners()));


//        if (position % 2 == 0 && listBanner.get(number).getBanners() != null) {
//                number++;
//                return 0;
//        } else {
//                return 1;
//        }

        return bannerAndDefaultItems.get(position).getBanners() == null ? 1 : 0;


    }


    @Override
    public int getArrCount_extraBanner() {

        return extra_getBannerGroups.size();
       // return responseGetBanner.getExtra().size();


    }


    @Override
    public int getArrCount_banner_child(int position) {


        return bannerAndDefaultItems.get(position).getBanners().getBanners().size();
       // return extra_getBannerGroups.get(position).getBanners().size();
       //return bannerAndDefaultItems.get(position).getBanners().getBanners().size();

        //return listBanner.get(position).getBanners().getBanners().size();
        //  return responseGetBanner.getExtra().get(position).getBanners().size();

    }

    @Override
    public Extra_getBannerGroups getChildAt_detailBanners(int position) {


        return bannerAndDefaultItems.get(position).getBanners();
        //return listBanner.get(position).getBanners();

    }




    @Override
    public int getArrCount_MainList() {


        return bannerAndDefaultItems.size();
//        return listBanner.size()+itemDefaults.size();

    }


    public void buildResultList(int sizeBannerList, int sizeItemDefaultList) {

        int sizeLastList=sizeBannerList+sizeItemDefaultList;
        int bannerCounter=0;
        int itemDefaultCounter=0;
        int listType = 2;


        for (int i = 0; i <sizeLastList ; i++) {

            if (listType == 2 && bannerCounter<sizeBannerList){
                bannerCounter++;
                listType=1;
                BannerAndDefaultItem bannerAndDefaultItem = new BannerAndDefaultItem();
                bannerAndDefaultItem.setBanners(extra_getBannerGroups.get(0));
                bannerAndDefaultItem.setMediaList(null);
                bannerAndDefaultItems.add(bannerAndDefaultItem);
                extra_getBannerGroups.remove(0);
            } else if (listType == 1 && itemDefaultCounter<sizeItemDefaultList){
                itemDefaultCounter++;
                listType=2;
                BannerAndDefaultItem bannerAndDefaultItem = new BannerAndDefaultItem();
                bannerAndDefaultItem.setBanners(null);
                bannerAndDefaultItem.setMediaList(extra_getMediaSubGroups.get(0));
                bannerAndDefaultItems.add(bannerAndDefaultItem);
                extra_getMediaSubGroups.remove(0);
            }
            else if (listType == 2 && itemDefaultCounter>=sizeItemDefaultList){

                    BannerAndDefaultItem bannerAndDefaultItem = new BannerAndDefaultItem();
                    bannerAndDefaultItem.setBanners(extra_getBannerGroups.get(0));
                    bannerAndDefaultItem.setMediaList(null);
                    bannerAndDefaultItems.add(bannerAndDefaultItem);
                    extra_getBannerGroups.remove(0);

            } else if (listType == 1 && bannerCounter>=sizeBannerList){

                    BannerAndDefaultItem bannerAndDefaultItem = new BannerAndDefaultItem();
                    bannerAndDefaultItem.setBanners(null);
                    bannerAndDefaultItem.setMediaList(extra_getMediaSubGroups.get(0));
                    bannerAndDefaultItems.add(bannerAndDefaultItem);
                    extra_getMediaSubGroups.remove(0);


            }else {
                try {
                    BannerAndDefaultItem bannerAndDefaultItem = new BannerAndDefaultItem();
                    bannerAndDefaultItem.setMediaList(extra_getMediaSubGroups.get(0));
                    bannerAndDefaultItems.add(bannerAndDefaultItem);
                } catch (Exception e) {
                //    Toast.makeText(getContext(), "no add mediaGetGroup", Toast.LENGTH_SHORT).show();
                }

                try {
                    BannerAndDefaultItem bannerAndDefaultItem = new BannerAndDefaultItem();
                    bannerAndDefaultItem.setBanners(extra_getBannerGroups.get(0));
                    bannerAndDefaultItems.add(bannerAndDefaultItem);
                } catch (Exception e) {

                //   Toast.makeText(getContext(), "no add banner", Toast.LENGTH_SHORT).show();
                }
            }





//            else if (listType == 1 && bannerCounter>=sizeBannerList){
//                itemDefaultCounter++;
//                listType=2;
//                bannerAndDefaultItem.setBanners(null);
//                bannerAndDefaultItem.setMediaList(itemDefaults.get(0).getMediaList());
//                bannerAndDefaultItems.add(bannerAndDefaultItem);
//                itemDefaults.remove(0);
//            } else if (listType == 2 && itemDefaultCounter>=sizeItemDefaultList){
//                bannerCounter++;
//                listType=1;
//                bannerAndDefaultItem.setBanners(listBanner.get(0).getBanners());
//                bannerAndDefaultItem.setMediaList(null);
//                bannerAndDefaultItems.add(bannerAndDefaultItem);
//                listBanner.remove(0);
//            }
        }


        for (int i = 0; i < bannerAndDefaultItems.size(); i++) {
            Log.d("tagis", "getBanners: "+(bannerAndDefaultItems.get(i).getBanners() == null));
            Log.d("tagis", "getMediaList: "+(bannerAndDefaultItems.get(i).getMediaList() == null));
        }

    }


}
