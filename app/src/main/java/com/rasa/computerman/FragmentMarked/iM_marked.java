package com.rasa.computerman.FragmentMarked;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.Marked.Model.ExtraMarker;

public interface iM_marked {

    Context getContext();
    void sendRequest(String deviceId);

    int getArrCountGetMarked();
    ExtraMarker getChildAtMarked(int position);

}
