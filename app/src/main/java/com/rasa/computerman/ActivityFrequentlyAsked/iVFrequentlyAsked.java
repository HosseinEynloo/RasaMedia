package com.rasa.computerman.ActivityFrequentlyAsked;

import android.content.Context;

import com.rasa.computerman.WebService.FrequentlyAsked.Model.ResponseFrequentlyAsked;

public interface iVFrequentlyAsked {

    void onSuccessGetFrequentlyAsked(ResponseFrequentlyAsked frequentlyAsked);
    void onFailedGetFrequentlyAsked(int errorId, String ErrorMessage);
    Context getContext();

}
