package com.rasa.computerman.ActivityContactUs;

import android.content.Context;

import com.rasa.computerman.WebService.ContactUs.Model.ResponseContactUs;

public interface iVCantactUs {

    Context getContext();

    void onSuccess(ResponseContactUs responseContactUs);

    void onFailed(int errorId, String ErrorMessage);
}
