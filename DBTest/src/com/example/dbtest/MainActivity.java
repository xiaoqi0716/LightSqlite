package com.example.dbtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.db.PersonalDB;
import com.example.db.StudentTable;
import com.example.item.StudentItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        //---------初始化数据库实例，在Application中加入下面两行代码-----------
//        PersonalDB db = new PersonalDB(this.getApplicationContext());
//        db.open(); //打开MY_DB.db数据库


        //----------表的操作有 find()方法系列、add()方法系列、set()方法系列---------
        List<StudentItem> list = new ArrayList<StudentItem>();
        StudentItem item_1 = new StudentItem();
        item_1.setId(123);
        item_1.setName("学生1");
        item_1.setAge(15);
        item_1.setInClass("二年级");
        list.add(item_1);
        StudentItem item_2 = new StudentItem();
        item_2.setId(234);
        item_2.setName("学生2");
        item_2.setAge(16);
        item_2.setInClass("三年级");
        list.add(item_2);
        StudentTable.getsInstance().add(list); // 将一个List数据集插入表
        // studentTable.add(list, true);//是否启用事务操作，当一次插入数据量大的时候开启，会加快插入操作

        StudentItem item = new StudentItem();
        item.setId(100);
        item.setName("学生n");
        item.setAge(15);
        item.setInClass("四年级");
        StudentTable.getsInstance().add(item); // 将一个学生实例插入表

        // 无条件查询所有记录
        List<StudentItem> studentItems = StudentTable.getsInstance().findAll();

        // 查询符合条件的第一条记录
        StudentItem studentItem = StudentTable.getsInstance().findOne(StudentItem.FIELD_S_ID + "=" + 123);

        // 查询符合条件的第一条记录，筛选固定的字段
        studentItem = StudentTable.getsInstance().findOne(new String[]{StudentItem.FIELD_S_ID, StudentItem.FIELD_S_NAME},
                StudentItem.FIELD_S_ID + " = 100");
        if (studentItem != null) {
            Log.i("xiaoqi", "id=" + studentItem.getId() + ", name=" + studentItem.getName());
        }


        // 根据多条件来查询符合条件的所有记录，并分组
        studentItems = StudentTable.getsInstance().find(StudentItem.FIELD_S_NAME + " like '%张'", StudentItem.FIELD_S_CLASS, null,
                StudentItem.FIELD_S_AGE + " desc");
        if (studentItem != null) {
            Log.i("xiaoqi", "id=" + studentItem.getId() + ", name=" + studentItem.getName());
        }

        // 根据多条件来查询符合条件的前10条记录
        studentItems = StudentTable.getsInstance().find(StudentItem.FIELD_S_NAME + " like '%张'", null, null,
                StudentItem.FIELD_S_AGE + " desc", 10);

        //对学号ID为100的学生进行年级的修改，改为三年级
        StudentTable.getsInstance().set(StudentItem.FIELD_S_CLASS, "三年级", StudentItem.FIELD_S_ID + "= 100");

    }
}
