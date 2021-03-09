package com.rasa.computerman.FragmentVideoPlayer;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;


import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Extra_getMedia;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Group;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.ResponseGetMedia;
import com.rasa.computerman.WebService.Medias.Like.Model.ResponseLike;
import com.rasa.computerman.WebService.Medias.Mark.Model.ResponseMark;
import com.squareup.picasso.Picasso;

public class PVideoPlayer implements iP_VideoPlayer{

    private iV_VideoPlayer iV_videoPlayer;


    MVideoPlayer mVideoPlayer;

    public PVideoPlayer(iV_VideoPlayer iV_videoPlayer) {
        this.iV_videoPlayer = iV_videoPlayer;

        mVideoPlayer=new MVideoPlayer(this);
    }

    @Override
    public Context getContext() {
        return iV_videoPlayer.getContext();
    }

    @Override
    public void onSuccessGetInfo(ResponseGetMedia getMedia) {

        iV_videoPlayer.onSuccessGetInfo(getMedia);
    }

    @Override
    public void onFailedGetInfo(int errorId, String ErrorMessage) {

        iV_videoPlayer.onFailedGetInfo(errorId, ErrorMessage);
    }


    @Override
    public void sendRequest(int mediaId,String deviceId) {

      Log.d("hello", "sendRequest: "+mediaId+":::::"+deviceId);

        mVideoPlayer.sendRequest(mediaId,deviceId);
    }

    @Override
    public void requestLikeState(int position,int mediaId,String deviceId,Boolean isLike) {
        mVideoPlayer.requestLikeState(position,mediaId,deviceId,isLike);
    }

    @Override
    public void requestMarkState(int position, int mediaId, String deviceId, Boolean isMarked) {
        mVideoPlayer.requestMarkState(position, mediaId, deviceId, isMarked);
    }

    @Override
    public int getArrCount_getMedia() {
        return mVideoPlayer.getArrCount_getMedia();
    }

    @Override
    public Extra_getMedia getChildAt_getMedia(int position) {
        return mVideoPlayer.getChildAt_getMedia(position);
    }



    @Override
    public void onBindViewHolder_getMedia_itemDefault(RecyclerView.ViewHolder holder, final int position) {

        final AdapterRecyclerview_videoPlayer.itemDefaultVideo itemDefaultVideo= (AdapterRecyclerview_videoPlayer.itemDefaultVideo) holder;
        itemDefaultVideo.textview_title_list.setText(getChildAt_getGroup(position).getTitle());
        Picasso.with(getContext()).load(getChildAt_getGroup(position).getImageUrl()).into(itemDefaultVideo.imageView_list);
        itemDefaultVideo.textview_description_list.setText(getChildAt_getGroup(position).getDescription());
        itemDefaultVideo.textview_visite_count.setText(String.valueOf(getChildAt_getGroup(position).getDefaultVisit()));

        itemDefaultVideo.imageview_more_videoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu=new PopupMenu(getContext(),v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){

                            case R.id.shareApp:

                                Intent intent=new Intent(Intent.ACTION_SEND);
                                intent.putExtra(Intent.EXTRA_TEXT,"http://2rsa.ir/bakh.html");
                                intent.setType("text/plain");
                                getContext().startActivity(Intent.createChooser(intent,"send with :"));
                                break;


                        }

                        return false;

                    }
                });

                popupMenu.inflate(R.menu.menu_share_app);
                popupMenu.show();

            }
        });

        itemDefaultVideo.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iV_videoPlayer.onRowSelected(position);

            }
        });



    }

    @Override
    public Group getChildAt_getGroup(int position) {
        return mVideoPlayer.getChildAt_getGroup(position);
    }

    @Override
    public int getArrCount_group() {
        return mVideoPlayer.getArrCount_group();
    }



    @Override
    public void onSuccessGetResponseLike(ResponseLike responseLike,int position,int mediaId) {
        iV_videoPlayer.onSuccessGetResponseLike(responseLike,position,mediaId);
    }

    @Override
    public void onFailedGetResponseLike(int errorId, String ErrorMessage) {

        iV_videoPlayer.onFailedGetResponseLike(errorId, ErrorMessage);
    }

    @Override
    public void onSuccessGetResponseMark(ResponseMark responseMark, int position, int mediaId) {
        iV_videoPlayer.onSuccessGetResponseMark(responseMark, position, mediaId);
    }

    @Override
    public void onFailedGetResponseMark(int errorId, String ErrorMessage) {

        iV_videoPlayer.onFailedGetResponseMark(errorId, ErrorMessage);
    }

    @Override
    public void requestVisite(int mediaId) {
        mVideoPlayer.requestVisite(mediaId);
    }



}
