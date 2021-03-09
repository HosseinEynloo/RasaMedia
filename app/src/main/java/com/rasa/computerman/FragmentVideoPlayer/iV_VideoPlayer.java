package com.rasa.computerman.FragmentVideoPlayer;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.GetMedia.Model.ResponseGetMedia;
import com.rasa.computerman.WebService.Medias.Like.Model.ResponseLike;
import com.rasa.computerman.WebService.Medias.Mark.Model.ResponseMark;

public interface iV_VideoPlayer {

    Context getContext();

    void onSuccessGetInfo(ResponseGetMedia getMedia);


    void onFailedGetInfo(int errorId, String ErrorMessage);

   void onRowSelected(int position);

    void onSuccessGetResponseLike(ResponseLike responseLike,int position,int mediaId);
    void onFailedGetResponseLike(int errorId, String ErrorMessage);

    void onSuccessGetResponseMark(ResponseMark responseMark, int position, int mediaId);
    void onFailedGetResponseMark(int errorId, String ErrorMessage);




}
