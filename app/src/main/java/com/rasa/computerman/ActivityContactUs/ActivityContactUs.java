package com.rasa.computerman.ActivityContactUs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;


import com.rasa.customfontviews.CustomFontButton;
import com.rasa.customfontviews.CustomFontEditText;
import com.rasa.computerman.R;
import com.rasa.computerman.WebService.ContactUs.Model.ResponseContactUs;

public class ActivityContactUs extends AppCompatActivity implements iVCantactUs {

    PContactUs pContactUs;
    CustomFontEditText EditTextMobileNumber;
    CustomFontEditText editTextDescription;
    CustomFontButton sendComment;

    String mobileNumber;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        init();

        sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextDescription.getText().toString().equals("")){
                    Toast.makeText(ActivityContactUs.this, "لطفا فیلد های خالی را تکمیل نمایید", Toast.LENGTH_SHORT).show();
                }else if (EditTextMobileNumber.getText().toString().equals("")){
                    Toast.makeText(ActivityContactUs.this, "لطفا فیلد های خالی را تکمیل نمایید", Toast.LENGTH_SHORT).show();
                }else {


                    mobileNumber = EditTextMobileNumber.getText().toString();
                    description = editTextDescription.getText().toString();
                    pContactUs.sendParametr(mobileNumber, description);

                    if (checkNetworkStatus()){
                        onBackPressed();
                    }

                }

            }
        });
    }

    private void init() {
        pContactUs=new PContactUs(this);
        editTextDescription=findViewById(R.id.editTextComment);
        EditTextMobileNumber=findViewById(R.id.editTextMobileNumber);
        sendComment=findViewById(R.id.btnSendComment);

    }

    @Override
    public Context getContext() {
        return ActivityContactUs.this;
    }

    @Override
    public void onSuccess(ResponseContactUs responseContactUs) {

        Toast.makeText(this, ""+responseContactUs.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(int errorId, String ErrorMessage) {

        Toast.makeText(this, ""+ErrorMessage, Toast.LENGTH_SHORT).show();
    }

    private boolean checkNetworkStatus() {

        //require permission Internet wifiState networkState

        final ConnectivityManager connMgr = (ConnectivityManager)ActivityContactUs.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        final android.net.NetworkInfo wifi =
                connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        final android.net.NetworkInfo mobile =
                connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (wifi.isConnected()) {
            return true;
        } else if (mobile.isConnected()) {
            return true;

        } else {
            return false;

        }

    }
}
