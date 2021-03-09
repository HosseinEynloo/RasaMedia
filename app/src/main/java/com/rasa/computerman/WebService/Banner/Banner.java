package com.rasa.computerman.WebService.Banner;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Banner.Model.ResponseBanner;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Banner implements iBanner {


    private iResult iResult;

    public Banner() {
    }

    public Banner(iBanner.iResult iResult) {
        this.iResult = iResult;
    }


    //Response<ResponseBanner>


    @Override
    public void doGetBanner(int page, int size, boolean firstType) {
        Call<ResponseBanner> call = new ApiClient().getClient().create(apiRequest.class).getBanner(page, size, firstType);
        call.enqueue(new Callback<ResponseBanner>() {
            @Override
            public void onResponse(Call<ResponseBanner> call, Response<ResponseBanner> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetBanner(response.body());
                        }
                    } else {
                        if(response.body().getMessage()==null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetBanner(0, response.body().getMessage());
                        }else{
                            iResult.onFailedGetBanner(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetBanner(response.code(),ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBanner> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetBanner(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
