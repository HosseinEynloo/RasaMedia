package com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.ResponseGetMediaSubGroup;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMediaSubGroup implements iGetMediaSubGroup {

    private iGetMediaSubGroup.iResult iResult;

    public GetMediaSubGroup() {
    }

    public GetMediaSubGroup(iGetMediaSubGroup.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetMediaSubGroup(int page, int size,int groupId) {
        Call<ResponseGetMediaSubGroup> call = new ApiClient().getClient().create(iGetMediaSubGroup.apiRequest.class).getMediaSubGroup(page, size,groupId);
        call.enqueue(new Callback<ResponseGetMediaSubGroup>() {
            @Override
            public void onResponse(Call<ResponseGetMediaSubGroup> call, Response<ResponseGetMediaSubGroup> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetMediaSubGroup(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetMediaSubGroup(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetMediaSubGroup(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetMediaSubGroup(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseGetMediaSubGroup> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetMediaSubGroup(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }



}
