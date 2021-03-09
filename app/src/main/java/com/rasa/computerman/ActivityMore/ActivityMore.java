package com.rasa.computerman.ActivityMore;


import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.Media;

import java.util.List;

public class ActivityMore extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Media> mediaList;
    TextView textViewActionBar;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        init();
        mediaList= (List<Media>) getIntent().getSerializableExtra("medias");
        title=getIntent().getStringExtra("title");
        textViewActionBar.setText(title);
        showValuAnimation();
        AdapterRecyclerViewMore adapterRecyclerViewMore=new AdapterRecyclerViewMore(this,mediaList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapterRecyclerViewMore);




    }

    private void init() {
        recyclerView=findViewById(R.id.recyclerView_more);
        textViewActionBar=findViewById(R.id.textViewActionBar);

    }

    private void showValuAnimation() {


        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.belu1),
                ContextCompat.getColor(this, R.color.yelow));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                textViewActionBar.setTextColor(((int) valueAnimator.getAnimatedValue()));
            }
        });
        valueAnimator.setDuration(1950);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }
}
