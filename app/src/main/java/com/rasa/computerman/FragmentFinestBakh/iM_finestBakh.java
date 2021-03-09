package com.rasa.computerman.FragmentFinestBakh;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.FinestBakh.Model.Extra_finestBakh;

public interface iM_finestBakh {


    Context getContext();

    void sendRequestForGetFinestBakh();

    int getArrCount_extraFinestBakh();

    Extra_finestBakh getChild_extraFinestBakh(int position);

}
