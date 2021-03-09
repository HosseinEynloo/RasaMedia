package com.rasa.computerman.FragmentDetailChannel;


import android.content.Context;


import com.rasa.computerman.FragmentDetailChannel.Adapter.AdapterRecyclerViewBannerDetailChannel;
import com.rasa.computerman.FragmentDetailChannel.Adapter.AdapterRecyclerViewDetailChannels;
import com.rasa.computerman.FragmentDetailChannel.Adapter.AdapterRecyclerViewDetailItemDefault;
import com.rasa.computerman.WebService.Groups.GetBanner.Model.Extra_getBannerGroups;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.Extra_getMediaSubGroup;

public interface iP_detailChannel {

    Context getContext();

    void sendRequest_getBannerGroup(int id);

    void onSuccessGetList();
    void onFailedGetList(int errorId,String ErrorMessage);

    int getArrCount_banner_child(int position);


    Extra_getBannerGroups getChildAt_detailBanners(int position);



    void onBindViewHolder_banner(AdapterRecyclerViewDetailChannels.viewsHolderBanner viewsHolderBanner,int position);

    void onBindViewHolder_banner_include_imageview(AdapterRecyclerViewBannerDetailChannel.viewsHolderImageView holder, int parentPosition,int position);



    void onBindViewHolder_itemDefault(AdapterRecyclerViewDetailChannels.viewsHolderItem viewsHolderItem,int position);
    void onBindViewHolder_viewItemDefault(AdapterRecyclerViewDetailItemDefault.viewsItemDefault holder, int parentPosition,int position);

    int getItemType(int position);








    //تعداد زیر گروه های  بنر  کانال x مثلا پزشکی و طب سنتی و...برای مشخص کردن تعداد recyclerview های صفحه اصلی
    int getArrCount_extraBanner();





    //تعداد زیر گروه های کانال x مثلا پزشکی و طب سنتی و...برای مشخص کردن تعداد recyclerview های صفحه اصلی
    int getArrCount_extraGetMediaSubGroup();


    //گرفتن فرزندان extra که شامل پزشکی و media ها یا زیر گروه های پزشکی میشود
    Extra_getMediaSubGroup getChildAt_extras(int position);



    int getArrCount_detailItemDefault(int position);





    int getArrCount_MainList();





}
