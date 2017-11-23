package com.example.ryan.moviedbapi;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ryan on 23/11/2017.
 */

public class MoviesApplication extends Application {

    public static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}