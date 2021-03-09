package com.rasa.computerman.ActivityFrequentlyAsked;

import com.rasa.computerman.WebService.FrequentlyAsked.FrequentlyAsked;
import com.rasa.computerman.WebService.FrequentlyAsked.Model.Extra;
import com.rasa.computerman.WebService.FrequentlyAsked.Model.ResponseFrequentlyAsked;
import com.rasa.computerman.WebService.FrequentlyAsked.iFrequentlyAsked;

public class MFrequentlyAsked implements iMFrequentlyAsked{


    private com.rasa.computerman.ActivityFrequentlyAsked.iPFrequentlyAsked iPFrequentlyAsked;

    ResponseFrequentlyAsked responseFrequentlyAsked;

    public MFrequentlyAsked(iPFrequentlyAsked iPFrequentlyAsked){
        this.iPFrequentlyAsked = iPFrequentlyAsked;
    }


    @Override
    public void sendRequestForGetFrequentlyAsked(int page, int size) {
        new FrequentlyAsked(new iFrequentlyAsked.iResult() {
            @Override
            public void onSuccessGetFrequentlyAsked(ResponseFrequentlyAsked frequentlyAsked) {
                responseFrequentlyAsked=frequentlyAsked;
                iPFrequentlyAsked.onSuccessGetFrequentlyAsked(frequentlyAsked);
            }

            @Override
            public void onFailedGetFrequentlyAsked(int errorId, String ErrorMessage) {

                iPFrequentlyAsked.onFailedGetFrequentlyAsked(errorId, ErrorMessage);
            }
        }).doGetFrequentlyAsked(page,size);
    }

    @Override
    public Extra getChildAtResponseFrequentlyAsked(int position) {
        return responseFrequentlyAsked.getExtra().get(position);
    }

    @Override
    public int getArrCount() {
        return responseFrequentlyAsked.getExtra().size();
    }

}
