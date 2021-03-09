package com.rasa.computerman.WebService.Medias.SuggestBakh;

import com.rasa.computerman.WebService.Medias.SuggestBakh.Model.ResponseSuggestBakh;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iSuggestBakh {

    void doGetSuggestBakh(int page,int size);

    interface iResult {
        void onSuccessGetSuggestBakh(ResponseSuggestBakh suggestBakh);
        void onFailedGetSuggestBakh(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Medias/SuggestBakh")
        Call<ResponseSuggestBakh> getSuggestBakh(@Query("page")int page, @Query("size")int size);
    }
}
