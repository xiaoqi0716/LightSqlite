/*
 * File Name: MyDBHelper.java 
 * History:
 * Created by Administrator on 2017年5月2日
 */
package com.example.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.db.easydao.AbstractDBHelper;
import com.db.easydao.AbstractTable;

public class PersonalDB extends AbstractDBHelper {

    // 数据库名
    private final String DB_NAME = "MY_DB.db";

    // 数据库版本
    // [VR = 1 数据库初版]
    // [VR = 2 版本号说明]
    // [VR = 3 版本号说明]
    // [...]
    private final int DB_VERSION = 1;

    
    public PersonalDB(Context context) {
        super(context);
    }

    @Override
    public String getDataBaseName() {
        return DB_NAME;
    }

    @Override
    public int getDataBaseVersion() {
        return DB_VERSION;
    }

    //返回MY_DB.db数据库所有的表,后续增加表直接在这里添加
    @Override
    public List<AbstractTable<?>> getTables() {
        List<AbstractTable<?>> list = new ArrayList<AbstractTable<?>>();
        list.add(StudentTable.getsInstance()); //学生表
        list.add(TeacherTable.getsInstance()); //老师表
        //后续有新表继续添加
        //.........
        return list;
    }
}
