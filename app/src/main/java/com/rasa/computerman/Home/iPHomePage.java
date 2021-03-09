package com.rasa.computerman.Home;

import android.content.Context;

import com.rasa.computerman.Home.Adapter.AdapterRecyclerViewGroupChannels;
import com.rasa.computerman.WebService.Groups.Model.Extra_groups;
import com.rasa.computerman.WebService.Groups.Model.ResponseGroups;


public interface iPHomePage {

    void onSuccessGetGroup(ResponseGroups groups);

    void onFailedGetGroup(int errorId, String ErrorMessage);

    Context getContext();

    void sendRequest_getGroup();


    int getArrCount_GroupChannel();

    Extra_groups getChaildAt_GroupChannel(int position);

    void onBindViewHolder_GroupChannel(AdapterRecyclerViewGroupChannels.ViewsChannel holder, int position);

}
