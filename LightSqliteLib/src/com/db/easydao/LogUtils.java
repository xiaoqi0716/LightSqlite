package com.db.easydao;

import android.util.Log;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

class LogUtils {

    private static final String TAG = "LightSQLite";

    protected static void v(String msg) {
        Log.v(TAG, msg);
    }

    protected static void d(String msg) {
        Log.d(TAG, msg);
    }

    protected static void i(String msg) {
        Log.i(TAG, msg);
    }

    protected static void w(String msg) {
        Log.w(TAG, msg);
    }

    protected static void e(String msg) {
        Log.e(TAG, msg);
    }
    
    protected static void e(String msg, Throwable e) {
        Log.e(TAG, msg, e);
    }
}
