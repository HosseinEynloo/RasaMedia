package com.rasa.computerman.WebService.Groups.GetBanner;

import com.rasa.computerman.WebService.Groups.GetBanner.Model.ResponseGetBanner;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iGetBanner {

    void doGetBanner(int groupId);

    interface iResult {
        void onSuccessGetBanner(ResponseGetBanner bannersGroup);
        void onFailedGetBanner(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Groups/GetBanner")
        Call<ResponseGetBanner> getBannerGroup(@Query("groupId") int groupId);
    }
}
