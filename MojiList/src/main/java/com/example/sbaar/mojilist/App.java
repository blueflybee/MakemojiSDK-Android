package com.example.sbaar.mojilist;

import android.app.Application;
import android.content.Context;

import com.example.mojilib.Moji;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Scott Baar on 12/14/2015.
 */
public class App extends Application {
    public static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context=this;
        Moji.initialize(this);
        //LeakCanary.install(this);
    }
}
