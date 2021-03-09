package com.rasa.computerman.WebService.Medias.Marked;

import com.rasa.computerman.WebService.Medias.Marked.Model.ResponseMarked;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iMarked {
    void doGetMarked(int size,int page,String deviceId);

    interface iResult {
        void onSuccessGetMarked(ResponseMarked responseMarked);
        void onFailedGetMarked(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Medias/GetMediaMark")
        Call<ResponseMarked> getMarked(@Query("size")int size,@Query("page")int page,@Query("deviceId")String deviceId);
    }

}
