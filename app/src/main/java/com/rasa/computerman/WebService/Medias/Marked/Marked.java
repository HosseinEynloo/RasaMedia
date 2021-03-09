package com.rasa.computerman.WebService.Medias.Marked;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.Marked.Model.ResponseMarked;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Marked implements iMarked{


    private iMarked.iResult iResult;

    public Marked() {
    }

    public Marked(iMarked.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetMarked(int size,int page,String deviceId) {
        Call<ResponseMarked> call = new ApiClient().getClient().create(iMarked.apiRequest.class).getMarked(size, page,deviceId);
        call.enqueue(new Callback<ResponseMarked>() {
            @Override
            public void onResponse(Call<ResponseMarked> call, Response<ResponseMarked> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetMarked(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetMarked(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetMarked(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetMarked(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseMarked> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetMarked(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }

}
