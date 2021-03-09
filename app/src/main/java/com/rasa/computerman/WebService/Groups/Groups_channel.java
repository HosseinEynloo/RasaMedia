package com.rasa.computerman.WebService.Groups;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Groups.Model.ResponseGroups;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Groups_channel implements iGroups {
    private iGroups.iResult iResult;

    public Groups_channel() {
    }

    public Groups_channel(iGroups.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetGroups() {
        Call<ResponseGroups> call =ApiClient.getClient().create(iGroups.apiRequest.class).getGroups();
        call.enqueue(new Callback<ResponseGroups>() {
            @Override
            public void onResponse(Call<ResponseGroups> call, Response<ResponseGroups> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetGroup(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetGroup(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetGroup(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetGroup(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseGroups> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetGroup(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
