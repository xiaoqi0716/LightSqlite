/*
 * File Name: TeacherItem.java 
 * History:
 * Created by Administrator on 2017年5月2日
 */
package com.example.item;

import com.db.easydao.Column;

public class TeacherItem {

    @Column(name="t_id", unique = true, index = true, notNull = true)
    private int id;
    
    @Column(name="name",notNull=true)
    private String name;
    
    @Column(name="title")
    private String title;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
