package com.rasa.computerman.WebService.Medias.Like;

import com.rasa.computerman.WebService.Medias.Like.Model.Params;
import com.rasa.computerman.WebService.Medias.Like.Model.ResponseLike;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface iLike {
    void doGetResponseLike(Params params);

    interface iResult {
        void onSuccessGetResponseLike(ResponseLike responseLike);
        void onFailedGetResponseLike(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @POST("Medias/Like")
        Call<ResponseLike> getResponseLike(@Body()Params params);
    }

}
