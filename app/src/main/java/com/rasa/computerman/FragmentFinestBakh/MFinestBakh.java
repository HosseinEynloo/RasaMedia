package com.rasa.computerman.FragmentFinestBakh;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.FinestBakh.FinestBakh;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.Extra_finestBakh;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.ResponseFinestBakh;
import com.rasa.computerman.WebService.Medias.FinestBakh.iFinestBakh;

public class MFinestBakh implements iM_finestBakh {

    private com.rasa.computerman.FragmentFinestBakh.iP_finestBakh iP_finestBakh;

    ResponseFinestBakh responseFinestBakh;


    public MFinestBakh(iP_finestBakh iP_finestBakh) {
        this.iP_finestBakh = iP_finestBakh;
    }

    @Override
    public Context getContext() {
        return iP_finestBakh.getContext();
    }

    @Override
    public void sendRequestForGetFinestBakh() {

        new FinestBakh(new iFinestBakh.iResult() {
            @Override
            public void onSuccessGetFinestBakh(ResponseFinestBakh finestBakh) {

                 responseFinestBakh=finestBakh;
                iP_finestBakh.onSuccessGetFinestBakh(finestBakh);

            }

            @Override
            public void onFailedGetFinestBakh(int errorId, String ErrorMessage) {


                iP_finestBakh.onFailedGetFinestBakh(errorId, ErrorMessage);

            }
        }).doGetFinestBakh(0,1000);
    }

    @Override
    public int getArrCount_extraFinestBakh() {

        if (responseFinestBakh==null){
            return 0;
        }else {
            return responseFinestBakh.getExtra().size();
        }
    }

    @Override
    public Extra_finestBakh getChild_extraFinestBakh(int position) {
        return responseFinestBakh.getExtra().get(position);
    }
}
