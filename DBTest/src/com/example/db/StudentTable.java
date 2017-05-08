/*
 * File Name: StudentTable.java 
 * History:
 * Created by Administrator on 2017年5月2日
 */
package com.example.db;

import android.database.sqlite.SQLiteDatabase;

import com.db.easydao.AbstractTable;
import com.example.item.StudentItem;

/**
 * (这是学生表，各个方法配置完成后就不用作其它操作了)
 * 
 * @author wangxiaoqi
 * @version
 */
public class StudentTable extends AbstractTable<StudentItem> {

    private final static String TABLE_NAME = "student"; // 学生表

    private static StudentTable sInstance;

    private StudentTable() {

    }

    public static StudentTable getsInstance() {
        if (sInstance == null) {
            sInstance = new StudentTable();
        }
        return sInstance;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    // 当数据库版本号更新时，该方法被执行
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
