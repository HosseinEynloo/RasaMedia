package com.rasa.computerman.WebService.Medias.FinestBakh;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.ResponseFinestBakh;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinestBakh implements iFinestBakh{


    private iFinestBakh.iResult iResult;

    public FinestBakh() {
    }

    public FinestBakh(iFinestBakh.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetFinestBakh(int page, int size) {
        Call<ResponseFinestBakh> call = new ApiClient().getClient().create(iFinestBakh.apiRequest.class).getFinestBakh(page, size);
        call.enqueue(new Callback<ResponseFinestBakh>() {
            @Override
            public void onResponse(Call<ResponseFinestBakh> call, Response<ResponseFinestBakh> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetFinestBakh(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetFinestBakh(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetFinestBakh(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetFinestBakh(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseFinestBakh> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetFinestBakh(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
