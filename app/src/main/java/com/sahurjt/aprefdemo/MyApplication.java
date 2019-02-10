package com.sahurjt.aprefdemo;


import com.sahurjt.apref.APref;
import android.app.Application;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        APref.init(getApplicationContext());
    }
}
