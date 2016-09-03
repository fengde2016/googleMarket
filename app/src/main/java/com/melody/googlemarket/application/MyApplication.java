package com.melody.googlemarket.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * Created by fengd on 2016/9/3.
 */
public class MyApplication extends Application {
    private static Context context;
    private static Handler handler;
    private static int mainThreadId;

    //获取上下文对象
    public static Context getContext() {
        return context;
    }

    //获取handler
    public static Handler getHandler() {
        return handler;
    }

    //获取主线程id
    public static int getMainThreadId() {
        return mainThreadId;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = Process.myTid();
    }
}
