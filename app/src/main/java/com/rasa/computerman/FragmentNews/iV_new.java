package com.rasa.computerman.FragmentNews;

import android.content.Context;


import com.rasa.computerman.WebService.Medias.New.Model.ResponseNew;

public interface iV_new {

    void onSuccessGetNew(ResponseNew responseNew);

    void onFailedGetNew(int errorId, String ErrorMessage);

    Context getContext();
}
