package com.rasa.computerman.FragmentVideoPlayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Extra_getMedia;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Group;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.ResponseGetMedia;
import com.rasa.computerman.WebService.Medias.Like.Model.ResponseLike;
import com.rasa.computerman.WebService.Medias.Mark.Model.ResponseMark;

public interface iP_VideoPlayer {

    Context getContext();

    void onSuccessGetInfo(ResponseGetMedia getMedia);

    void onFailedGetInfo(int errorId, String ErrorMessage);

    void sendRequest(int mediaId, String deviceId);

    int getArrCount_getMedia();

    Extra_getMedia getChildAt_getMedia(int position);


    void onBindViewHolder_getMedia_itemDefault(RecyclerView.ViewHolder holder, int position);

    Group getChildAt_getGroup(int position);

    int getArrCount_group();

    void requestLikeState(int position,int mediaId,String deviceId,Boolean isLike);
    void requestMarkState(int position,int mediaId,String deviceId,Boolean isMarked);

    void onSuccessGetResponseLike(ResponseLike responseLike,int position,int mediaId);
    void onFailedGetResponseLike(int errorId, String ErrorMessage);


    void onSuccessGetResponseMark(ResponseMark responseMark, int position, int mediaId);
    void onFailedGetResponseMark(int errorId, String ErrorMessage);

    void requestVisite(int mediaId);


}
