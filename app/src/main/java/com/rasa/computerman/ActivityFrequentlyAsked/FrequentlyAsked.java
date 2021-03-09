package com.rasa.computerman.ActivityFrequentlyAsked;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.rasa.customfontviews.CustomFontTextView;
import com.rasa.computerman.R;
import com.rasa.computerman.WebService.FrequentlyAsked.Model.ResponseFrequentlyAsked;

public class FrequentlyAsked extends AppCompatActivity implements iVFrequentlyAsked{

    RecyclerView recyclerviewFrequentlyAsked;
    PFrequentlyAsked pFrequentlyAsked;
    RelativeLayout relativeLayout_progressBar_frequentlyAsked;
    Snackbar snackbar;
    CoordinatorLayout coordinatorLayout;
    ProgressBar progressBar;
    CustomFontTextView textView_plaseWait;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequently_asked);
        init();
        pFrequentlyAsked=new PFrequentlyAsked(this);
        pFrequentlyAsked.sendRequestForGetFrequentlyAsked(0,1000);

    }

    private void init() {
        recyclerviewFrequentlyAsked=findViewById(R.id.recyclerviewFrequentlyAsked);
        relativeLayout_progressBar_frequentlyAsked=findViewById(R.id.relativeLayout_progressBar_frequentlyAsked);
        coordinatorLayout=findViewById(R.id.coordinatorLayoutFrequentlyAsked);
        progressBar=findViewById(R.id.progressBar_frequentlyAsked);
        textView_plaseWait=findViewById(R.id.textViewPlaseWait);
        textView_plaseWait.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        relativeLayout_progressBar_frequentlyAsked.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccessGetFrequentlyAsked(ResponseFrequentlyAsked frequentlyAsked) {


        relativeLayout_progressBar_frequentlyAsked.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        textView_plaseWait.setVisibility(View.GONE);

        AdapterFrequentlyAsked adapterFrequentlyAsked=new AdapterFrequentlyAsked(pFrequentlyAsked);
        recyclerviewFrequentlyAsked.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerviewFrequentlyAsked.setAdapter(adapterFrequentlyAsked);
    }

    @Override
    public void onFailedGetFrequentlyAsked(int errorId, String ErrorMessage) {

        relativeLayout_progressBar_frequentlyAsked.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        textView_plaseWait.setVisibility(View.GONE);
        snackbar= Snackbar.make(coordinatorLayout,""+ErrorMessage,Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("retry", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pFrequentlyAsked.sendRequestForGetFrequentlyAsked(0,1000);
                relativeLayout_progressBar_frequentlyAsked.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                textView_plaseWait.setVisibility(View.VISIBLE);

            }
        }).show();
    }

    @Override
    public Context getContext() {
        return FrequentlyAsked.this;
    }
}
