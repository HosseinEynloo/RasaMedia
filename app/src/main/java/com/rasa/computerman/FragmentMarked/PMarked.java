package com.rasa.computerman.FragmentMarked;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.rasa.computerman.ActivityVideoPlayer;
import com.rasa.computerman.FragmentMarked.Adapter.AdapterRecyclerViewMarked;
import com.rasa.computerman.WebService.Medias.Marked.Model.ExtraMarker;
import com.rasa.computerman.WebService.Medias.Marked.Model.ResponseMarked;
import com.squareup.picasso.Picasso;

public class PMarked implements ip_marked{

    private com.rasa.computerman.FragmentMarked.iV_marked iV_marked;
    MMarked mMarked;


    public PMarked(iV_marked iV_marked) {
        this.iV_marked = iV_marked;
        mMarked=new MMarked(this);
    }


    @Override
    public Context getContext() {
        return iV_marked.getContext();
    }

    @Override
    public void sendRequest(String deviceId) {

        mMarked.sendRequest(deviceId);
    }

    @Override
    public void onSuccessGetMarked(ResponseMarked responseMarked) {


        iV_marked.onSuccessGetMarked(responseMarked);
    }

    @Override
    public void onFailedGetMarked(int errorId, String errorMessage) {

        iV_marked.onFailedGetMarked(errorId, errorMessage);
    }

    @Override
    public int getArrCountGetMarked() {
        return mMarked.getArrCountGetMarked();
    }

    @Override
    public void onBindViewHolderMarked(final AdapterRecyclerViewMarked.viewsMarked holder, final int position) {
        Picasso.with(getContext()).load(getChildAtMarked(position).getImageUrl()).into(holder.imageView_marked);
        holder.textView_title_marked.setText(getChildAtMarked(position).getTitle());
        holder.textView_titleGroup_marked.setText(getChildAtMarked(position).getGroups().get(0).getTitle());
        holder.textView_registerDate_marked.setText(getChildAtMarked(position).getRegisterDate());

        Log.d("allii", "onBindViewHolderMarked: "+getChildAtMarked(position).getUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(), ActivityVideoPlayer.class);
                intent.putExtra("id",getChildAtMarked(position).getId());
                Log.d("alio", "onClick: "+getChildAtMarked(position).getId());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public ExtraMarker getChildAtMarked(int position) {
        return mMarked.getChildAtMarked(position);
    }
}
