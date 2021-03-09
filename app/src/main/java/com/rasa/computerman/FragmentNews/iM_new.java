package com.rasa.computerman.FragmentNews;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.New.Model.Extra_new;


public interface iM_new {

    void sendRequestForGetNew();

    Context getContext();

    int getArrCount_NewItem();

    Extra_new getChildGetNew(int position);
}
