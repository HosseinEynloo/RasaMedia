package com.rasa.computerman.WebService.Banner;


import com.rasa.computerman.WebService.Banner.Model.ResponseBanner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iBanner {

     void doGetBanner(int page,int size,boolean firstType);

    interface iResult {
        void onSuccessGetBanner(ResponseBanner banner);
        void onFailedGetBanner(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Banner")
        Call<ResponseBanner> getBanner(@Query("page")int page, @Query("size")int size, @Query("firstType")boolean firstType);
    }
}
