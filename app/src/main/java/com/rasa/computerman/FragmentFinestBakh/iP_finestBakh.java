package com.rasa.computerman.FragmentFinestBakh;

import android.content.Context;

import com.rasa.computerman.FragmentFinestBakh.Adapter.AdapterRecyclerView_FinestBakh;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.Extra_finestBakh;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.ResponseFinestBakh;

public interface iP_finestBakh {

    Context getContext();

    void onSuccessGetFinestBakh(ResponseFinestBakh finestBakh);
    void onFailedGetFinestBakh(int errorId,String ErrorMessage);

    void sendRequestForGetFinestBakh();

    void onBindViewHolderFinestBakh(AdapterRecyclerView_FinestBakh.ViewsFinestBakh holder, int position);

    int getArrCount_extraFinestBakh();

    Extra_finestBakh getChild_extraFinestBakh(int position);

}
