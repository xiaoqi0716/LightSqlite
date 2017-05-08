/*
 * File Name: ColumnAno.java 
 * History:
 * Created by Administrator on 2017年5月5日
 */
package com.db.easydao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String name();
    String type() default "UNKNOW";
    boolean primaryKey() default false;
    boolean autoIncrement() default false;
    boolean unique() default false;
    boolean index() default false;
    boolean notNull() default false;
    String defaultVal() default "";

}
