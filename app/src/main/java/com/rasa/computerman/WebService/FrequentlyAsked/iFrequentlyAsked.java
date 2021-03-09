package com.rasa.computerman.WebService.FrequentlyAsked;

import com.rasa.computerman.WebService.FrequentlyAsked.Model.ResponseFrequentlyAsked;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iFrequentlyAsked {

    void doGetFrequentlyAsked(int page,int size);

    interface iResult {
        void onSuccessGetFrequentlyAsked(ResponseFrequentlyAsked frequentlyAsked);
        void onFailedGetFrequentlyAsked(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Faq")
        Call<ResponseFrequentlyAsked> getFrequentlyAsked(@Query("page")int page, @Query("size")int size);
    }
}
