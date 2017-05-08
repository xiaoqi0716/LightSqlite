/*
 * File Name: TeacherTable.java 
 * History:
 * Created by Administrator on 2017年5月2日
 */
package com.example.db;

import android.database.sqlite.SQLiteDatabase;

import com.db.easydao.AbstractTable;
import com.example.item.TeacherItem;

/**
 * (这是老师表处理类，同StudentTable)
 * 
 * @author Administrator
 * @version
 */
public class TeacherTable extends AbstractTable<TeacherItem> {

    private final String TABLE_NAME = "teacher";

    private static TeacherTable sInstance;

    private TeacherTable(){}

    public synchronized static TeacherTable getsInstance() {
        if (sInstance == null) {
            sInstance = new TeacherTable();
        }
        return sInstance;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

  
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
