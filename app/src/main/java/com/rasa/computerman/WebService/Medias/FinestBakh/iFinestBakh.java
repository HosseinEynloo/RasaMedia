package com.rasa.computerman.WebService.Medias.FinestBakh;

import com.rasa.computerman.WebService.Medias.FinestBakh.Model.ResponseFinestBakh;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iFinestBakh {


    void doGetFinestBakh(int page,int size);

    interface iResult {
        void onSuccessGetFinestBakh(ResponseFinestBakh finestBakh);
        void onFailedGetFinestBakh(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Medias/Bakh")
        Call<ResponseFinestBakh> getFinestBakh(@Query("page")int page, @Query("size")int size);
    }
}
