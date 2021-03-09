package com.rasa.computerman.ActivityMarker;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.rasa.computerman.FragmentMarked.FragmentMarked;
import com.rasa.computerman.R;

public class ActivityMarker extends AppCompatActivity implements FragmentMarked.OnFragmentInteractionListener{

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);
        frameLayout=findViewById(R.id.frameLayoutMarker);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayoutMarker,new FragmentMarked()).commit();

    }
}
