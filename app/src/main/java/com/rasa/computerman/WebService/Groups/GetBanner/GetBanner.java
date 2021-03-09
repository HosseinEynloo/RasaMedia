package com.rasa.computerman.WebService.Groups.GetBanner;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Groups.GetBanner.Model.ResponseGetBanner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetBanner implements iGetBanner{

    private iGetBanner.iResult iResult;

    public GetBanner() {
    }

    public GetBanner(iGetBanner.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetBanner(int groupId) {
        Call<ResponseGetBanner> call = new ApiClient().getClient().create(iGetBanner.apiRequest.class).getBannerGroup(groupId);
        call.enqueue(new Callback<ResponseGetBanner>() {
            @Override
            public void onResponse(Call<ResponseGetBanner> call, Response<ResponseGetBanner> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetBanner(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetBanner(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetBanner(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetBanner(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseGetBanner> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetBanner(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
