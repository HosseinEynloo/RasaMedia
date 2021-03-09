package com.rasa.computerman.WebService.Medias.New;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.New.Model.ResponseNew;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class New implements iNew {

    private iNew.iResult iResult;

    public New() {
    }

    public New(iNew.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetNew(int page, int size) {
        Call<ResponseNew> call = new ApiClient().getClient().create(iNew.apiRequest.class).getNew(page, size);
        call.enqueue(new Callback<ResponseNew>() {
            @Override
            public void onResponse(Call<ResponseNew> call, Response<ResponseNew> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetNew(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetNew(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetNew(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetNew(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseNew> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetNew(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
