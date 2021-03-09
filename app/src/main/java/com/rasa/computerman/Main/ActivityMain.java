package com.rasa.computerman.Main;


import android.content.Intent;
import android.graphics.Typeface;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.rasa.customfontviews.CustomFontTextView;
import com.rasa.computerman.ActivityContactUs.ActivityContactUs;
import com.rasa.computerman.ActivityMarker.ActivityMarker;
import com.rasa.computerman.FragmentDetailChannel.FragmentDetailChannel;
import com.rasa.computerman.FragmentFinestBakh.FragmentFinestBakh;
import com.rasa.computerman.FragmentMarked.FragmentMarked;
import com.rasa.computerman.FragmentNews.FragmentNews;
import com.rasa.computerman.Home.fragment_homePage;
import com.rasa.computerman.R;


import cn.jzvd.JZVideoPlayerStandard;

import static com.rasa.computerman.App.getContext;

public class ActivityMain extends AppCompatActivity implements iVMainActivity, fragment_homePage.OnFragmentInteractionListener, FragmentMarked.OnFragmentInteractionListener, FragmentFinestBakh.OnFragmentInteractionListener, FragmentNews.OnFragmentInteractionListener, FragmentDetailChannel.OnFragmentInteractionListener, TabLayout.OnTabSelectedListener {

    PMainActivity pMainActivity;




    private int time_interval = 2000;
    private long oldCurrentTimeMillis;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbarMainActivity;
    Typeface typeface;
    Typeface typeface_iranSans;
    Typeface typeface_iranSansBold;
    ViewPager viewPager;
    TabLayout tabLayout;
    String deviceId;
    CustomFontTextView textViewUser;
    String textUser;
    ImageView imageViewUp;

    RelativeLayout relativeLayoutHome;
    RelativeLayout relativeLayoutEnter;
    RelativeLayout relativeLayoutSubjects;
    RelativeLayout relativeLayoutMarked;
    RelativeLayout relativeLayoutAboutUs;
    RelativeLayout relativeLayoutContactUs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pMainActivity = new PMainActivity(this);
        init();

        setupViewPager(viewPager);
        setuptoolbarMainActivity();


        viewPager.setCurrentItem(3);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
        changeTabsFont();
    }

    private void setupViewPager(ViewPager viewPager) {

        AdapterViewPager adapter = new AdapterViewPager(getSupportFragmentManager());

        adapter.addFragment(new FragmentMarked(), "علاقه مندی");
        adapter.addFragment(new FragmentFinestBakh(), "برترین ها");
        adapter.addFragment(new FragmentNews(), "تازه ها");
        adapter.addFragment(new fragment_homePage(), "خانه");
        viewPager.setAdapter(adapter);

    }

    private void setuptoolbarMainActivity() {


        setSupportActionBar(toolbarMainActivity);
        toolbarMainActivity.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbarMainActivity, 0, 0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        for (int i = 0; i < toolbarMainActivity.getChildCount(); i++) {
            if (toolbarMainActivity.getChildAt(i) instanceof TextView) {
                ((TextView) toolbarMainActivity.getChildAt(i)).setTypeface(typeface_iranSans);
                ((TextView) toolbarMainActivity.getChildAt(i)).setTextSize(18);
            }

        }

        relativeLayoutHome = navigationView.findViewById(R.id.relativeLayoutBasicPage);
        relativeLayoutEnter = navigationView.findViewById(R.id.relativeLayoutEnter);
        relativeLayoutSubjects = navigationView.findViewById(R.id.relativeLayoutSubjects);
        relativeLayoutMarked = navigationView.findViewById(R.id.relativeLayoutMarked);
        relativeLayoutAboutUs = navigationView.findViewById(R.id.relativeLayoutAboutUs);
        relativeLayoutContactUs = navigationView.findViewById(R.id.relativeLayoutContactUs);

        relativeLayoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.isDrawerOpen(GravityCompat.START);
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        relativeLayoutEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        relativeLayoutSubjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ActivityMain.this, "موضوعات", Toast.LENGTH_SHORT).show();

            }
        });

        relativeLayoutMarked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityMain.this, ActivityMarker.class);
                startActivity(intent);

            }
        });

        relativeLayoutAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        relativeLayoutContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentContactUs = new Intent(ActivityMain.this, ActivityContactUs.class);
                startActivity(intentContactUs);

            }
        });



    }


    private void init() {
        viewPager = findViewById(R.id.viewPager_ActivityMain);
        tabLayout = findViewById(R.id.tabLayoutMainActivity);
        textViewUser = findViewById(R.id.textViewUser);
        imageViewUp = findViewById(R.id.imageViewUserImage_up);


        drawerLayout = findViewById(R.id.drawerLayoutMainActivity);
        navigationView = findViewById(R.id.navigationViewMainActivity);
        toolbarMainActivity = findViewById(R.id.toolbarMainActivity);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/aa.ttf");
        typeface_iranSans = Typeface.createFromAsset(getAssets(), "fonts/iran_sans.ttf");
        typeface_iranSansBold = Typeface.createFromAsset(getAssets(), "fonts/iran_sans_bold.ttf");
        deviceId = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            if (oldCurrentTimeMillis + time_interval > System.currentTimeMillis()) {
                super.onBackPressed();
                return;
            } else {
                onFirstBackPressed();

            }
            oldCurrentTimeMillis = System.currentTimeMillis();


        }
    }

    public void onFirstBackPressed() {
        Toast.makeText(getBaseContext(), "برای خروج دوباره روی بازگشت بزنید", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayerStandard.releaseAllVideos();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        textUser = tab.getText().toString();
        textViewUser.setText(textUser);

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    private void changeTabsFont() {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(typeface_iranSans);
                }
            }
        }
    }

}
