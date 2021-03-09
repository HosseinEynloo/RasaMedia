package com.rasa.computerman.FragmentMarked;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.Marked.Marked;
import com.rasa.computerman.WebService.Medias.Marked.Model.ExtraMarker;
import com.rasa.computerman.WebService.Medias.Marked.Model.ResponseMarked;
import com.rasa.computerman.WebService.Medias.Marked.iMarked;

import java.util.ArrayList;
import java.util.List;

public class MMarked implements iM_marked {

    private com.rasa.computerman.FragmentMarked.ip_marked ip_marked;

    List<ExtraMarker> extraMarkerList;

    public MMarked(ip_marked ip_marked) {
        this.ip_marked = ip_marked;
        extraMarkerList=new ArrayList<>();
    }

    @Override
    public Context getContext() {
        return ip_marked.getContext();
    }

    @Override
    public void sendRequest(String deviceId) {

        new Marked(new iMarked.iResult() {
            @Override
            public void onSuccessGetMarked(ResponseMarked responseMarked) {
                extraMarkerList=responseMarked.getExtra();
                ip_marked.onSuccessGetMarked(responseMarked);
            }

            @Override
            public void onFailedGetMarked(int errorId, String ErrorMessage) {

                ip_marked.onFailedGetMarked(errorId, ErrorMessage);
            }
        }).doGetMarked(1000,0,deviceId);

    }

    @Override
    public int getArrCountGetMarked() {
        return extraMarkerList.size();
    }

    @Override
    public ExtraMarker getChildAtMarked(int position) {
        return extraMarkerList.get(position);
    }
}
