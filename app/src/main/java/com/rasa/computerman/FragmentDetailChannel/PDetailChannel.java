package com.rasa.computerman.FragmentDetailChannel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.rasa.computerman.ActivityMore.ActivityMore;
import com.rasa.computerman.FragmentDetailChannel.Adapter.AdapterRecyclerViewBannerDetailChannel;
import com.rasa.computerman.FragmentDetailChannel.Adapter.AdapterRecyclerViewDetailChannels;
import com.rasa.computerman.FragmentDetailChannel.Adapter.AdapterRecyclerViewDetailItemDefault;
import com.rasa.computerman.ActivityVideoPlayer;
import com.rasa.computerman.WebService.Groups.GetBanner.Model.Extra_getBannerGroups;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.Extra_getMediaSubGroup;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.Media;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PDetailChannel implements iP_detailChannel {

    MDetailChannel mDetailChannel;
    List<Media> medias;
    private com.rasa.computerman.FragmentDetailChannel.iV_detailChannel iV_detailChannel;

    public PDetailChannel(iV_detailChannel iV_detailChannel) {
        this.iV_detailChannel = iV_detailChannel;
        mDetailChannel = new MDetailChannel(this);
    }

    @Override
    public Context getContext() {
        return iV_detailChannel.getContext();
    }

    @Override
    public void sendRequest_getBannerGroup(int id) {
        mDetailChannel.sendRequest_getBannerGroup(id);

    }

    @Override
    public void onSuccessGetList() {
        iV_detailChannel.onSuccessGetList();
    }

    @Override
    public void onFailedGetList(int errorId, String ErrorMessage) {

        iV_detailChannel.onFailedGetList(errorId, ErrorMessage);
    }

    @Override
    public int getArrCount_banner_child(int position) {
        return mDetailChannel.getArrCount_banner_child(position);
    }


    @Override
    public Extra_getBannerGroups getChildAt_detailBanners(int position) {
        return mDetailChannel.getChildAt_detailBanners(position);
    }

    @Override
    public void onBindViewHolder_banner(AdapterRecyclerViewDetailChannels.viewsHolderBanner viewsHolderBanner, int position) {

        Log.d("hasan", "onBindViewHolder_banner: " + (viewsHolderBanner.recyclerView_banner == null) + " pos" + position);
        AdapterRecyclerViewBannerDetailChannel adapterRecyclerViewBannerDetailChannel = new AdapterRecyclerViewBannerDetailChannel(this, position);
        viewsHolderBanner.recyclerView_banner.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        viewsHolderBanner.recyclerView_banner.setAdapter(adapterRecyclerViewBannerDetailChannel);

    }

    @Override
    public void onBindViewHolder_banner_include_imageview(AdapterRecyclerViewBannerDetailChannel.viewsHolderImageView holder, int parentPosition, int position) {

        Picasso.with(getContext()).load(getChildAt_detailBanners(parentPosition).getBanners().get(position).getImageUrl()).into(holder.imageView);



    }

    @Override
    public void onBindViewHolder_itemDefault(AdapterRecyclerViewDetailChannels.viewsHolderItem viewsHolderItem, final int position) {

        viewsHolderItem.MainTitle.setText(getChildAt_extras(position).getTitle());
        AdapterRecyclerViewDetailItemDefault adapterRecyclerViewDetailItemDefault = new AdapterRecyclerViewDetailItemDefault(this, position);
        viewsHolderItem.recyclerView_defaultItem.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        viewsHolderItem.recyclerView_defaultItem.setAdapter(adapterRecyclerViewDetailItemDefault);
        medias=new ArrayList<>();
        viewsHolderItem.textViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medias=getChildAt_extras(position).getMedias();
                Intent intent=new Intent(getContext(), ActivityMore.class);
                intent.putExtra("medias", (Serializable) medias);
                intent.putExtra("title", getChildAt_extras(position).getTitle());
                getContext().startActivity(intent);
            }
        });

        viewsHolderItem.imageViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                medias=getChildAt_extras(position).getMedias();
                Intent intent=new Intent(getContext(), ActivityMore.class);
                intent.putExtra("medias", (Serializable) medias);
                intent.putExtra("title", getChildAt_extras(position).getTitle());
                getContext().startActivity(intent);


            }
        });
    }

    @Override
    public void onBindViewHolder_viewItemDefault(final AdapterRecyclerViewDetailItemDefault.viewsItemDefault holder, final int parentPosition, final int position) {


        Log.d("Ali", "onBindViewHolder_viewItemDefault: " + getChildAt_extras(parentPosition).getMedias());
        holder.title_textView.setText(getChildAt_extras(parentPosition).getMedias().get(position).getTitle());
        Picasso.with(getContext()).load(getChildAt_extras(parentPosition).getMedias().get(position).getImageUrl()).into(holder.imageView);
        holder.description_textView.setText(getChildAt_extras(parentPosition).getMedias().get(position).getDescription());
        holder.defaultVisite.setText(getChildAt_extras(parentPosition).getMedias().get(position).getDefaultVisit() + "");



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(), ActivityVideoPlayer.class);
                intent.putExtra("id",getChildAt_extras(parentPosition).getMedias().get(position).getId());
                getContext().startActivity(intent);

                Log.d("kl", "onClick: "+holder.itemView.getId());


            }
        });


    }

    @Override
    public int getItemType(int position) {
        return mDetailChannel.getItemType(position);
    }

    @Override
    public int getArrCount_extraBanner() {
        return mDetailChannel.getArrCount_extraBanner();
    }

    @Override
    public int getArrCount_extraGetMediaSubGroup() {
        return mDetailChannel.getArrCount_extraGetMediaSubGroup();
    }

    @Override
    public Extra_getMediaSubGroup getChildAt_extras(int position) {
        return mDetailChannel.getChildAt_extras(position);
    }

    @Override
    public int getArrCount_detailItemDefault(int position) {
        return mDetailChannel.getArrCount_detailItemDefault(position);
    }


    @Override
    public int getArrCount_MainList() {
        return mDetailChannel.getArrCount_MainList();
    }
}
