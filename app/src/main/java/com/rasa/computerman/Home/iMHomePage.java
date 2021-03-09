package com.rasa.computerman.Home;

import android.content.Context;

import com.rasa.computerman.WebService.Groups.Model.Extra_groups;

public interface iMHomePage {

    Context getContext();

    void sendRequest_getGroup();

    int getArrCount_GroupChannel();

    Extra_groups getChaildAt_GroupChannel(int position);




}
