package com.rasa.computerman.FragmentNews;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.New.Model.Extra_new;
import com.rasa.computerman.WebService.Medias.New.Model.ResponseNew;

public interface iP_new {

    void sendRequestForGetNew();
    void onSuccessGetNew(ResponseNew responseNew);

    void onFailedGetNew(int errorId, String ErrorMessage);

    Context getContext();

    void onBindViewHolder_new(AdapterRecyclerView_New.viewsNewItem holder, int position);


    int getArrCount_NewItem();

    Extra_new getChildGetNew(int position);
}
