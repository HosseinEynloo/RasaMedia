package com.rasa.computerman.FragmentDetailChannel.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rasa.computerman.FragmentDetailChannel.PDetailChannel;
import com.rasa.computerman.R;

public class AdapterRecyclerViewBannerDetailChannel extends RecyclerView.Adapter<AdapterRecyclerViewBannerDetailChannel.viewsHolderImageView> {


    private PDetailChannel pDetailChannel;
    private int parentposition;

    public AdapterRecyclerViewBannerDetailChannel(PDetailChannel pDetailChannel, int position) {
        this.pDetailChannel = pDetailChannel;
        this.parentposition = position;
    }

    @NonNull
    @Override
    public viewsHolderImageView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(pDetailChannel.getContext()).inflate(R.layout.banner_imageviews,parent,false);
        return new viewsHolderImageView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewsHolderImageView holder, int position) {

        pDetailChannel.onBindViewHolder_banner_include_imageview(holder,parentposition,position);
    }

    @Override
    public int getItemCount() {
        return pDetailChannel.getArrCount_banner_child(parentposition);

    }

    public class viewsHolderImageView extends RecyclerView.ViewHolder{

        public ImageView imageView;

        public viewsHolderImageView(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview_bannerChannels);
        }
    }
}
