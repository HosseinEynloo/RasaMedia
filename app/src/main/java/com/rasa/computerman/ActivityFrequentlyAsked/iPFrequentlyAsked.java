package com.rasa.computerman.ActivityFrequentlyAsked;


import android.content.Context;

import com.rasa.computerman.WebService.FrequentlyAsked.Model.Extra;
import com.rasa.computerman.WebService.FrequentlyAsked.Model.ResponseFrequentlyAsked;

public interface iPFrequentlyAsked {

    void sendRequestForGetFrequentlyAsked(int page,int size);
    void onSuccessGetFrequentlyAsked(ResponseFrequentlyAsked frequentlyAsked);
    void onFailedGetFrequentlyAsked(int errorId, String ErrorMessage);

    Extra getChildAtResponseFrequentlyAsked(int position);
    int getArrCount();
    Context getContext();

    void onBindViewHolderFrequentlyAsked(AdapterFrequentlyAsked.viewsFrequentlyAsked holder, int position);
}
