package com.rasa.computerman.WebService.Medias.GetMedia;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.ResponseGetMedia;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMedia implements iGetMedia {

    private iGetMedia.iResult iResult;

    public GetMedia() {
    }

    public GetMedia(iGetMedia.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetGetMedia(int mediaId, String deviceId) {

        Call<ResponseGetMedia> call = new ApiClient().getClient().create(iGetMedia.apiRequest.class).GetMedia(mediaId,deviceId);
        call.enqueue(new Callback<ResponseGetMedia>() {
            @Override
            public void onResponse(Call<ResponseGetMedia> call, Response<ResponseGetMedia> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetMedia(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetMedia(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetMedia(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetMedia(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseGetMedia> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetMedia(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });

    }
}
