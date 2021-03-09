package com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId;

import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.ResponseGetMediaSubGroup;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iGetMediaSubGroup {

    void doGetMediaSubGroup(int page,int size,int groupId);

    interface iResult {
        void onSuccessGetMediaSubGroup(ResponseGetMediaSubGroup getMediaSubGroup);
        void onFailedGetMediaSubGroup(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @GET("Medias/GetMediaSubGroupByMainGroupId")
        Call<ResponseGetMediaSubGroup> getMediaSubGroup(@Query("page")int page, @Query("size")int size, @Query("groupId")int groupId);
    }
}
