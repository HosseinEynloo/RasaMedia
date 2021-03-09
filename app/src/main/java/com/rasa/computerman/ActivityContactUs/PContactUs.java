package com.rasa.computerman.ActivityContactUs;

import android.content.Context;


import com.rasa.computerman.WebService.ContactUs.Model.ResponseContactUs;

public class PContactUs implements iPContactUs{

    MContactUs mContactUs;
    private com.rasa.computerman.ActivityContactUs.iVCantactUs iVCantactUs;

    public PContactUs(iVCantactUs iVCantactUs) {
        this.iVCantactUs = iVCantactUs;
        mContactUs=new MContactUs(this);
    }

    @Override
    public void sendParametr(String mobileNumber,String description) {

        mContactUs.sendComment(mobileNumber, description);
    }

    @Override
    public Context getContext() {
        return iVCantactUs.getContext();
    }

    @Override
    public void onSuccess(ResponseContactUs responseContactUs) {
        iVCantactUs.onSuccess(responseContactUs);
    }

    @Override
    public void onFailed(int errorId, String ErrorMessage) {
        iVCantactUs.onFailed(errorId, ErrorMessage);
    }

}
