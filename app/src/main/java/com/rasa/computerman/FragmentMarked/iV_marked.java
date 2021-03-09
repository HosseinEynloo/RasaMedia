package com.rasa.computerman.FragmentMarked;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.Marked.Model.ResponseMarked;

public interface iV_marked {

    Context getContext();
    void onSuccessGetMarked(ResponseMarked responseMarked);
    void onFailedGetMarked(int errorId,String errorMessage);
}
