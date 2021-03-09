package com.rasa.computerman.FragmentDetailChannel;

import android.content.Context;

public interface iV_detailChannel {

    Context getContext();


    void onSuccessGetList();
    void onFailedGetList(int errorId,String ErrorMessage);



}
