/*
 * File Name: MyApplication.java 
 * History:
 * Created by Administrator on 2017年5月8日
 */
package com.example.dbtest;

import android.app.Application;

import com.example.db.PersonalDB;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //---------初始化MY_DB.db数据库实例-----------
        PersonalDB db = new PersonalDB(this.getApplicationContext());
        db.open(); //打开MY_DB.db数据库，程序退出不用关闭
        //----------------初始化完成------------------
    }
}
