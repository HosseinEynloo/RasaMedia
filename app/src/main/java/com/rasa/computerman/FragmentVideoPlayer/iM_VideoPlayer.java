package com.rasa.computerman.FragmentVideoPlayer;

import android.content.Context;


import com.rasa.computerman.WebService.Medias.GetMedia.Model.Extra_getMedia;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Group;

public interface iM_VideoPlayer {

    Context getContext();

    void sendRequest(int mediaId,String deviceId);

    int getArrCount_getMedia();

    Extra_getMedia getChildAt_getMedia(int position);

    Group getChildAt_getGroup(int position);

    int getArrCount_group();

    void requestLikeState(int position,int mediaId,String deviceId,Boolean isLike);
    void requestMarkState(int position,int mediaId,String deviceId,Boolean isMarked);

    void requestVisite(int mediaId);





}
