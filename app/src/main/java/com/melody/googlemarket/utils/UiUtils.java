package com.melody.googlemarket.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.melody.googlemarket.application.MyApplication;

/**
 * Created by fengd on 2016/9/4 1:26.
 */
public class UiUtils {
    //    获取上下文
    public static Context getContext() {
        return MyApplication.getContext();
    }

    //    获取handler
    public static Handler getHandler() {
        return MyApplication.getHandler();
    }

    //    获取主线程id
    public static int getMainThreadId() {
        return MyApplication.getMainThreadId();
    }

    /**
     * 加载资源相关
     */
    //    字符串
    public static String getString(int id) {
        return getContext().getString(id);
    }

    //    字符串数组
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    //    图片
    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    //    颜色
    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }

    //    尺寸
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }

    /**
     * dip和px转换
     */
    //    dip到px
    public static int dip2px(float dip) {
        return (int) (dip * getContext().getResources().getDisplayMetrics().density + 0.5f);
    }

    //    px到dip
    public static float px2dip(int px) {
        return px / getContext().getResources().getDisplayMetrics().density;
    }

    /**
     * 加载布局文件
     */
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    /**
     * 主线程相关
     */
    //    判断是否运行在主线程
    public static boolean isOnMainThread() {
        if (android.os.Process.myTid() == getMainThreadId()) {
            return true;
        }
        return false;
    }

    //    在主线程运行
    public static void runInMainThread(Runnable r) {
        if (isOnMainThread()) {
            r.run();
        } else {
            getHandler().post(r);
        }
    }
}
