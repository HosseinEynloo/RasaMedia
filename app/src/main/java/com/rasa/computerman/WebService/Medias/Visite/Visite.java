package com.rasa.computerman.WebService.Medias.Visite;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;

import com.rasa.computerman.WebService.Medias.Visite.Model.ResponseVisite;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Visite implements iVisite {

    private iVisite.iResult iResult;

    public Visite() {
    }

    public Visite(iVisite.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetVisite(int mediaId) {
        Call<ResponseVisite> call = new ApiClient().getClient().create(iVisite.apiRequest.class).getVisite(mediaId);
        call.enqueue(new Callback<ResponseVisite>() {
            @Override
            public void onResponse(Call<ResponseVisite> call, Response<ResponseVisite> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetVisite(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetVisite(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetVisite(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetVisite(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseVisite> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetVisite(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }

}
