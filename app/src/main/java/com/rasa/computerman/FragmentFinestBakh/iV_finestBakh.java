package com.rasa.computerman.FragmentFinestBakh;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.FinestBakh.Model.ResponseFinestBakh;

public interface iV_finestBakh {

    Context getContext();

    void onSuccessGetFinestBakh(ResponseFinestBakh finestBakh);
    void onFailedGetFinestBakh(int errorId,String ErrorMessage);
}
