package com.rasa.computerman.WebService.Medias.Mark;


import com.rasa.computerman.WebService.Medias.Mark.Model.ResponseMark;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface iMark {

    void doGetResponseMark(int mediaId,String deviceId,boolean isMarked);

    interface iResult {
        void onSuccessGetResponseMark(ResponseMark responseMark);
        void onFailedGetResponseMark(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @POST("Medias/Mark")
        Call<ResponseMark> getResponseMark(@Query("MediaId") int mediaId, @Query("DeviceId") String deviceId, @Query("isMarked") boolean isMarked);
    }



}
