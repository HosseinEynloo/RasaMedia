package com.rasa.computerman.Home;

import android.content.Context;

import com.rasa.computerman.WebService.Groups.Model.ResponseGroups;

public interface iVHomePage {

    void onSuccessGetGroup(ResponseGroups groups);

    void onFailedGetGroup(int errorId, String ErrorMessage);

    Context getContext();

    void onSelectId(int id);



}
