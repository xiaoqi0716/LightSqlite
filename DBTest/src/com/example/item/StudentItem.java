/*
 * File Name: StudentItem.java 
 * History:
 * Created by Administrator on 2017年5月2日
 */
package com.example.item;

import com.db.easydao.Column;

public class StudentItem {

    public static final String FIELD_S_ID = "_id";
    public static final String FIELD_S_NAME = "s_name";
    public static final String FIELD_S_AGE = "age";
    public static final String FIELD_S_CLASS = "in_class";


    //说明：@Column(name = 字段名(必选), type = 字段类型(可选，默认用变量类型), primaryKey = 是否是主键(可选), autoIncrement = 是否自增字段(可选), unique = 是否可重复(可选), index = 是否索引字段(可选), notNull = 是否可为空(可选), defaultVal = 默认值(可选))

    //------------------------DB ver = 1 的字段列表----------------

    //学生ID
    @Column(name = FIELD_S_ID, primaryKey = true, autoIncrement = true)
    private int id;

    //学生姓名
    @Column(name = FIELD_S_NAME, type = "varchar(10)", notNull = true)
    private String name;

    //学生年龄
    @Column(name = FIELD_S_AGE, notNull = true)
    private int age;

    //班级
    @Column(name = FIELD_S_CLASS)
    private String inClass;

    //-------------------------END----------------------------

    //-----------------------DB VER = 2 新增的字段列表---------------------------
    // 当数据库版本号增加时，类新定义的字段会自动增加，无需在StudentTable的onUpgrade()去做，但如果修改、删除旧版本的字段需要在StudentTable的onUpgrade()方法中去做
    //--------------------------END-------------------------------


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getInClass() {
        return inClass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setInClass(String inClass) {
        this.inClass = inClass;
    }

}
