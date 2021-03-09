package com.rasa.computerman.ActivityContactUs;

import android.content.Context;

public interface iMContactUs {

    Context getContext();

    void sendComment(String mobileNumber,String description);
}
