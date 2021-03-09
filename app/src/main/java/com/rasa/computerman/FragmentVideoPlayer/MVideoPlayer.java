package com.rasa.computerman.FragmentVideoPlayer;

import android.content.Context;
import android.util.Log;

import com.rasa.computerman.WebService.Medias.GetMedia.GetMedia;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Extra_getMedia;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Group;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.ResponseGetMedia;
import com.rasa.computerman.WebService.Medias.GetMedia.iGetMedia;
import com.rasa.computerman.WebService.Medias.Like.Like;
import com.rasa.computerman.WebService.Medias.Like.Model.Params;
import com.rasa.computerman.WebService.Medias.Like.Model.ResponseLike;
import com.rasa.computerman.WebService.Medias.Like.iLike;
import com.rasa.computerman.WebService.Medias.Mark.Mark;
import com.rasa.computerman.WebService.Medias.Mark.Model.ResponseMark;
import com.rasa.computerman.WebService.Medias.Mark.iMark;
import com.rasa.computerman.WebService.Medias.Visite.Model.ResponseVisite;
import com.rasa.computerman.WebService.Medias.Visite.Visite;
import com.rasa.computerman.WebService.Medias.Visite.iVisite;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MVideoPlayer implements iM_VideoPlayer{

    private iP_VideoPlayer iPVideoPlayer;

    List<Extra_getMedia> getMediaList;
    List<Group> groups;

    public MVideoPlayer(iP_VideoPlayer iPVideoPlayer) {
        this.iPVideoPlayer = iPVideoPlayer;
        getMediaList=new ArrayList<>();
        groups=new ArrayList<>();

    }

    @Override
    public Context getContext() {
        return iPVideoPlayer.getContext();
    }

    @Override
    public void sendRequest(final int mediaId, String deviceId) {

        new GetMedia(new iGetMedia.iResult() {
            @Override
            public void onSuccessGetMedia(ResponseGetMedia getMedia) {

                Log.i("bannerResponse ::", "onSuccessGetBanner: "+new Gson().toJson(getMedia));
                getMediaList =getMedia.getExtra();
                groups=getMediaList.get(0).getGroups();
                iPVideoPlayer.onSuccessGetInfo(getMedia);
            }

            @Override
            public void onFailedGetMedia(int errorId, String ErrorMessage) {

                iPVideoPlayer.onFailedGetInfo(errorId,ErrorMessage);

            }
        }).doGetGetMedia(mediaId,deviceId);



    }

    @Override
    public int getArrCount_getMedia() {
        return getMediaList.size();
    }

    @Override
    public Extra_getMedia getChildAt_getMedia(int position) {
        return getMediaList.get(position);
    }

    @Override
    public Group getChildAt_getGroup(int position) {
        return groups.get(position);
    }

    @Override
    public int getArrCount_group() {
        return groups.size();
    }

    @Override
    public void requestLikeState(final int position, final int mediaId, String deviceId, Boolean isLike) {
        Params params=new Params();
        params.setDeviceId(deviceId);
        params.setIsLike(isLike);
        params.setMediaId(mediaId);
        new Like(new iLike.iResult() {
            @Override
            public void onSuccessGetResponseLike(ResponseLike responseLike) {

                iPVideoPlayer.onSuccessGetResponseLike(responseLike,position,mediaId);
                Log.d("errorsuc", "onSuccessGetResponseLike: "+responseLike);
            }

            @Override
            public void onFailedGetResponseLike(int errorId, String ErrorMessage) {

                iPVideoPlayer.onFailedGetResponseLike(errorId, ErrorMessage);
                Log.d("errorsuc", "onFaildGetResponseLike: "+ErrorMessage);

            }
        }).doGetResponseLike(params);
    }

    @Override
    public void requestMarkState(final int position, final int mediaId, String deviceId, Boolean isMarked) {

        new Mark(new iMark.iResult() {
            @Override
            public void onSuccessGetResponseMark(ResponseMark responseMark) {

                iPVideoPlayer.onSuccessGetResponseMark(responseMark,position,mediaId);
            }

            @Override
            public void onFailedGetResponseMark(int errorId, String ErrorMessage) {

                iPVideoPlayer.onFailedGetResponseMark(errorId, ErrorMessage);
            }
        }).doGetResponseMark(mediaId,deviceId,isMarked);

    }

    @Override
    public void requestVisite(int mediaId) {

        new Visite(new iVisite.iResult() {
            @Override
            public void onSuccessGetVisite(ResponseVisite responseVisite) {


            }

            @Override
            public void onFailedGetVisite(int errorId, String ErrorMessage) {


            }
        }).doGetVisite(mediaId);
    }


}
