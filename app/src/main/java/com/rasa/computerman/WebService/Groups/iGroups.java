package com.rasa.computerman.WebService.Groups;

import com.rasa.computerman.WebService.Groups.Model.ResponseGroups;

import retrofit2.Call;
import retrofit2.http.GET;


public interface iGroups {

    void doGetGroups();

    interface iResult {
        void onSuccessGetGroup(ResponseGroups groups);
        void onFailedGetGroup(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Groups")
        Call<ResponseGroups> getGroups();
    }
}
