package com.rasa.computerman.FragmentMarked;

import android.content.Context;

import com.rasa.computerman.FragmentMarked.Adapter.AdapterRecyclerViewMarked;
import com.rasa.computerman.WebService.Medias.Marked.Model.ExtraMarker;
import com.rasa.computerman.WebService.Medias.Marked.Model.ResponseMarked;

public interface ip_marked {

    Context getContext();
    void sendRequest(String deviceId);
    void onSuccessGetMarked(ResponseMarked responseMarked);
    void onFailedGetMarked(int errorId,String errorMessage);

    int getArrCountGetMarked();

    void onBindViewHolderMarked(AdapterRecyclerViewMarked.viewsMarked holder, int position);
    ExtraMarker getChildAtMarked(int position);
}
