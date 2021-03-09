package com.rasa.computerman.WebService.ContactUs;



import com.rasa.computerman.WebService.ContactUs.Model.Params;
import com.rasa.computerman.WebService.ContactUs.Model.ResponseContactUs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface iContactUs {

    void doGetResponseContactUs(Params params);

    interface iResult {
        void onSuccessGetResponseContactUs(ResponseContactUs responseContactUs);
        void onFailedGetResponseContactUs(int errorId, String ErrorMessage);
    }

    interface apiRequest {
        @POST("ContactUs")
        Call<ResponseContactUs> getResponseContactUs(@Body()Params params);
    }

}
