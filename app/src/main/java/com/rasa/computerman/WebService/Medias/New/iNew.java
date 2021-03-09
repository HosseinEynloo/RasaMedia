package com.rasa.computerman.WebService.Medias.New;

import com.rasa.computerman.WebService.Medias.New.Model.ResponseNew;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iNew {

    void doGetNew(int page,int size);

    interface iResult {
        void onSuccessGetNew(ResponseNew news);
        void onFailedGetNew(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Medias/New")
        Call<ResponseNew> getNew(@Query("page")int page, @Query("size")int size);
    }
}
