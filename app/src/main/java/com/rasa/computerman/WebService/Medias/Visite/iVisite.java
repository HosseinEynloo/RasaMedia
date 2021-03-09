package com.rasa.computerman.WebService.Medias.Visite;


import com.rasa.computerman.WebService.Medias.Visite.Model.ResponseVisite;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface iVisite {


    void doGetVisite(int mediaId);

    interface iResult {
        void onSuccessGetVisite(ResponseVisite responseVisite);
        void onFailedGetVisite(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @POST("Medias/Visit")
        Call<ResponseVisite> getVisite(@Query("MediaId")int mediaId);
    }

}
