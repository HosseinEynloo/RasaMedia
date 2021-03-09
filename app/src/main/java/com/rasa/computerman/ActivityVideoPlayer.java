package com.rasa.computerman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rasa.computerman.FragmentVideoPlayer.Fragment_videoPlayer;

import cn.jzvd.JZVideoPlayerStandard;

public class ActivityVideoPlayer extends AppCompatActivity implements Fragment_videoPlayer.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        int id=getIntent().getIntExtra("id",0);
        Log.d("idid", "onCreate: "+id);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_videoViewActivity,new Fragment_videoPlayer().newInstance(id),"fragmentVideoView")
                .commit();





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        JZVideoPlayerStandard.releaseAllVideos();
    }
}
