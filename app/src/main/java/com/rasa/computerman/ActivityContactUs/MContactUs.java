package com.rasa.computerman.ActivityContactUs;

import android.content.Context;

import com.rasa.computerman.WebService.ContactUs.ContactUs;
import com.rasa.computerman.WebService.ContactUs.Model.Params;
import com.rasa.computerman.WebService.ContactUs.Model.ResponseContactUs;
import com.rasa.computerman.WebService.ContactUs.iContactUs;

public class MContactUs implements iMContactUs {

    private com.rasa.computerman.ActivityContactUs.iPContactUs iPContactUs;
    Params params;

    public MContactUs(iPContactUs iPContactUs) {

        this.iPContactUs = iPContactUs;
    }

    @Override
    public Context getContext() {
        return iPContactUs.getContext();
    }

    @Override
    public void sendComment(String mobileNumber, String description) {
        params=new Params();
        params.setMobileNumber(mobileNumber);
        params.setDescription(description);
        new ContactUs(new iContactUs.iResult() {
            @Override
            public void onSuccessGetResponseContactUs(ResponseContactUs responseContactUs) {
                iPContactUs.onSuccess(responseContactUs);
            }

            @Override
            public void onFailedGetResponseContactUs(int errorId, String ErrorMessage) {
                iPContactUs.onFailed(errorId, ErrorMessage);
            }
        }).doGetResponseContactUs(params);
    }



}
