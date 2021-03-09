package com.rasa.computerman.WebService.Medias.SuggestBakh;

import com.rasa.computerman.Utils.ErrorMessage;
import com.rasa.computerman.WebService.ApiClient;
import com.rasa.computerman.WebService.Medias.SuggestBakh.Model.ResponseSuggestBakh;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestBakh implements iSuggestBakh {


    private iResult iResult;

    public SuggestBakh() {
    }

    public SuggestBakh(iSuggestBakh.iResult iResult) {
        this.iResult = iResult;
    }



    @Override
    public void doGetSuggestBakh(int page, int size) {
        Call<ResponseSuggestBakh> call = new ApiClient().getClient().create(apiRequest.class).getSuggestBakh(page, size);
        call.enqueue(new Callback<ResponseSuggestBakh>() {
            @Override
            public void onResponse(Call<ResponseSuggestBakh> call, Response<ResponseSuggestBakh> response) {
                if (response.code() == 200) {

                    if (response.body().getResult()) {
                        if (iResult != null) {
                            iResult.onSuccessGetSuggestBakh(response.body());
                        }
                    } else {
                        if(response.body().getMessage()==null || "".equals(response.body().getMessage())) {
                            iResult.onFailedGetSuggestBakh(0, response.body().getMessage());
                        }else{
                            iResult.onFailedGetSuggestBakh(0, ErrorMessage.ERROR_NETWORK_SERVER_SIDE.getErrorMessage());
                        }
                    }
                } else {
                    if (iResult != null) {
                        iResult.onFailedGetSuggestBakh(response.code(),ErrorMessage.getErrorByCode(response.code()));

                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseSuggestBakh> call, Throwable t) {
                if (iResult != null && !call.isCanceled()) {
                    iResult.onFailedGetSuggestBakh(0, ErrorMessage.ERROR_NETWORK_UNAVALABLE.getErrorMessage());
                }
            }
        });
    }
}
