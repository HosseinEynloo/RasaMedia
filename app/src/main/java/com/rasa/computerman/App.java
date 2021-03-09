package com.rasa.computerman;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class App extends Application {
    protected static Context context = null;

    public static final String TAG = "KidPainting";

    @Override
    public void onCreate() {
//        Fabric.with(this, new Crashlytics());
        super.onCreate();
        context = getApplicationContext();


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        ACRA.init(this);
        MultiDex.install(this);
    }

    public static Context getContext() {
        return context;
    }
}