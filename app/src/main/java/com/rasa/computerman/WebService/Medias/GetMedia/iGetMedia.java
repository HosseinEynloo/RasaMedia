package com.rasa.computerman.WebService.Medias.GetMedia;

import com.rasa.computerman.WebService.Medias.GetMedia.Model.ResponseGetMedia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iGetMedia {

    void doGetGetMedia(int mediaId,String deviceId);

    interface iResult {
        void onSuccessGetMedia(ResponseGetMedia getMedia);
        void onFailedGetMedia(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Medias/GetMedia")
        Call<ResponseGetMedia> GetMedia(@Query("mediaId")int mediaId, @Query("deviceId")String deviceId);
    }
}
