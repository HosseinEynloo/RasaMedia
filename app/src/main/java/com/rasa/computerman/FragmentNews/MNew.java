package com.rasa.computerman.FragmentNews;

import android.content.Context;

import com.rasa.computerman.WebService.Medias.New.Model.Extra_new;
import com.rasa.computerman.WebService.Medias.New.Model.ResponseNew;
import com.rasa.computerman.WebService.Medias.New.New;
import com.rasa.computerman.WebService.Medias.New.iNew;


public class MNew implements iM_new {

    ResponseNew responseNew;
    private com.rasa.computerman.FragmentNews.iP_new iP_new;

    public MNew(iP_new iP_new) {
        this.iP_new = iP_new;
    }


    @Override
    public void sendRequestForGetNew() {
        new New(new iNew.iResult() {


            @Override
            public void onSuccessGetNew(ResponseNew news) {
                responseNew = news;
                iP_new.onSuccessGetNew(news);


            }

            @Override
            public void onFailedGetNew(int errorId, String ErrorMessage) {

                iP_new.onFailedGetNew(errorId, ErrorMessage);
            }
        }).doGetNew(0, 1000);
    }

    @Override
    public Context getContext() {
        return iP_new.getContext();

    }

    @Override
    public int getArrCount_NewItem() {

        if (responseNew==null){
            return 0;
        }else {
            return responseNew.getExtra().size();
        }
    }

    @Override
    public Extra_new getChildGetNew(int position) {
        return responseNew.getExtra().get(position);
    }
}
