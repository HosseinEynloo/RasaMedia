package com.rasa.computerman.WebService.Medias.Mark;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.Mark.Model.ResponseMark;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mark implements iMark{
    private iMark.iResult iResult;

    public Mark() {
    }

    public Mark(iMark.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetResponseMark(int mediaId,String deviceId,boolean isMarked) {
        Call<ResponseMark> call = new ApiClient().getClient().create(iMark.apiRequest.class).getResponseMark(mediaId, deviceId, isMarked);
        call.enqueue(new Callback<ResponseMark>() {
            @Override
            public void onResponse(Call<ResponseMark> call, Response<ResponseMark> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetResponseMark(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetResponseMark(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetResponseMark(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetResponseMark(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseMark> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetResponseMark(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }

}
