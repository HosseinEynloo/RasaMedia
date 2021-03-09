package com.rasa.computerman.WebService.ContactUs;



import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.ContactUs.Model.Params;
import com.rasa.computerman.WebService.ContactUs.Model.ResponseContactUs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactUs implements iContactUs{

    private iContactUs.iResult iResult;

    public ContactUs() {
    }

    public ContactUs(iContactUs.iResult iResult) {
        this.iResult = iResult;
    }


    @Override
    public void doGetResponseContactUs(Params params) {
        Call<ResponseContactUs> call = new ApiClient().getClient().create(iContactUs.apiRequest.class).getResponseContactUs(params);
        call.enqueue(new Callback<ResponseContactUs>() {
            @Override
            public void onResponse(Call<ResponseContactUs> call, Response<ResponseContactUs> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetResponseContactUs(response.body());
                        }
                    } else {
                        if (response.body().getMessage() == null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetResponseContactUs(0, response.body().getMessage());
                        } else {
                            iResult.onFailedGetResponseContactUs(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetResponseContactUs(response.code(), ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseContactUs> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetResponseContactUs(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
