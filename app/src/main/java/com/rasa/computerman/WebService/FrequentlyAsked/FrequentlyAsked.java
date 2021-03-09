package com.rasa.computerman.WebService.FrequentlyAsked;


import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;

import com.rasa.computerman.WebService.FrequentlyAsked.Model.ResponseFrequentlyAsked;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FrequentlyAsked implements iFrequentlyAsked{



    private iFrequentlyAsked.iResult iResult;

    public FrequentlyAsked() {
    }

    public FrequentlyAsked(iFrequentlyAsked.iResult iResult) {
        this.iResult = iResult;
    }





    @Override
    public void doGetFrequentlyAsked(int page, int size) {
        Call<ResponseFrequentlyAsked> call = new ApiClient().getClient().create(iFrequentlyAsked.apiRequest.class).getFrequentlyAsked(page, size);
        call.enqueue(new Callback<ResponseFrequentlyAsked>() {
            @Override
            public void onResponse(Call<ResponseFrequentlyAsked> call, Response<ResponseFrequentlyAsked> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetFrequentlyAsked(response.body());
                        }
                    } else {
                        if(response.body().getMessage()==null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetFrequentlyAsked(0, response.body().getMessage());
                        }else{
                            iResult.onFailedGetFrequentlyAsked(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetFrequentlyAsked(response.code(),ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseFrequentlyAsked> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetFrequentlyAsked(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
