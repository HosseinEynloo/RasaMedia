package com.rasa.computerman.Home;

import android.content.Context;
import android.util.Log;

import com.rasa.computerman.WebService.Groups.Groups_channel;
import com.rasa.computerman.WebService.Groups.Model.Extra_groups;
import com.rasa.computerman.WebService.Groups.Model.ResponseGroups;
import com.rasa.computerman.WebService.Groups.iGroups;


import java.util.ArrayList;
import java.util.List;

public class MHomePage implements iMHomePage{


    public List<Extra_groups> groupList;
    private iPHomePage iPHomePage;


    public MHomePage(iPHomePage iPHomePage) {
        this.iPHomePage = iPHomePage;
        groupList = new ArrayList<>();

    }

    @Override
    public Context getContext() {
        return iPHomePage.getContext();
    }

    @Override
    public void sendRequest_getGroup() {

        new Groups_channel(new iGroups.iResult() {
            @Override
            public void onSuccessGetGroup(ResponseGroups groups) {

                iPHomePage.onSuccessGetGroup(groups);
                Log.i("hosein", "onSuccessGetGroup: "+groups);

                groupList=groups.getExtra();

            }

            @Override
            public void onFailedGetGroup(int errorId, String ErrorMessage) {

                iPHomePage.onFailedGetGroup(errorId, ErrorMessage);

            }
        }).doGetGroups();
    }

    @Override
    public int getArrCount_GroupChannel() {
        return groupList.size();
    }

    @Override
    public Extra_groups getChaildAt_GroupChannel(int position) {
        return groupList.get(position);
    }


}
