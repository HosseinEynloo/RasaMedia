package com.rasa.computerman.WebService.Medias.Like;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.Like.Model.Params;
import com.rasa.computerman.WebService.Medias.Like.Model.ResponseLike;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Like implements iLike {

    private iLike.iResult iResult;

    public Like() {
    }

    public Like(iLike.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetResponseLike(Params params) {
        Call<ResponseLike> call = new ApiClient().getClient().create(iLike.apiRequest.class).getResponseLike(params);
        call.enqueue(new Callback<ResponseLike>() {
            @Override
            public void onResponse(Call<ResponseLike> call, Response<ResponseLike> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetResponseLike(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetResponseLike(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetResponseLike(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetResponseLike(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseLike> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetResponseLike(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
