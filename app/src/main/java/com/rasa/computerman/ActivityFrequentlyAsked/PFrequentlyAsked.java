package com.rasa.computerman.ActivityFrequentlyAsked;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.rasa.computerman.WebService.FrequentlyAsked.Model.Extra;
import com.rasa.computerman.WebService.FrequentlyAsked.Model.ResponseFrequentlyAsked;

public class PFrequentlyAsked implements iPFrequentlyAsked {

    MFrequentlyAsked mFrequentlyAsked;

    private com.rasa.computerman.ActivityFrequentlyAsked.iVFrequentlyAsked iVFrequentlyAsked;

    public PFrequentlyAsked(iVFrequentlyAsked iVFrequentlyAsked){

        this.iVFrequentlyAsked = iVFrequentlyAsked;
        mFrequentlyAsked=new MFrequentlyAsked(this);
    }
    @Override
    public void sendRequestForGetFrequentlyAsked(int page, int size) {
        mFrequentlyAsked.sendRequestForGetFrequentlyAsked(page, size);
    }

    @Override
    public void onSuccessGetFrequentlyAsked(ResponseFrequentlyAsked frequentlyAsked) {
        iVFrequentlyAsked.onSuccessGetFrequentlyAsked(frequentlyAsked);
    }

    @Override
    public void onFailedGetFrequentlyAsked(int errorId, String ErrorMessage) {
        iVFrequentlyAsked.onFailedGetFrequentlyAsked(errorId, ErrorMessage);
    }

    @Override
    public Extra getChildAtResponseFrequentlyAsked(int position) {
        return mFrequentlyAsked.getChildAtResponseFrequentlyAsked(position);
    }

    @Override
    public int getArrCount() {
        return mFrequentlyAsked.getArrCount();
    }

    @Override
    public Context getContext() {
        return iVFrequentlyAsked.getContext();
    }

    @Override
    public void onBindViewHolderFrequentlyAsked(final AdapterFrequentlyAsked.viewsFrequentlyAsked holder, int position) {

        holder.textviewTitleAsk.setText(getChildAtResponseFrequentlyAsked(position).getTitle());
        holder.textviewAnswer.setText(" پاسخ:  "+getChildAtResponseFrequentlyAsked(position).getAnswer());
        int color=Color.parseColor(getChildAtResponseFrequentlyAsked(position).getColor());
        holder.relativeLayout.setBackgroundColor(color);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.textviewAnswer.getVisibility()==View.GONE){
                    holder.textviewAnswer.setVisibility(View.VISIBLE);
                }else {
                    holder.textviewAnswer.setVisibility(View.GONE);
                }
            }
        });
    }
}
