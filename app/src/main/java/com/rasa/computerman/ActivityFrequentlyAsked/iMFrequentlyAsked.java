package com.rasa.computerman.ActivityFrequentlyAsked;

import com.rasa.computerman.WebService.FrequentlyAsked.Model.Extra;

public interface iMFrequentlyAsked {

    void sendRequestForGetFrequentlyAsked(int page,int size);

    Extra getChildAtResponseFrequentlyAsked(int position);
    int getArrCount();
}
