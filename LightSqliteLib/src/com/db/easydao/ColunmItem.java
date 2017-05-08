/*
 * File Name: ColunmItem.java 
 * History:
 * Created by Administrator on 2017年5月6日
 */
package com.db.easydao;

class ColunmItem {

    private String fieldName;
    private String fieldType;
    private boolean isPK;
    private boolean isAutoIncrement;
    private boolean isUnique;
    private boolean isNotNull;
    private String defVal;

    public String getName() {
        return fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public boolean isPK() {
        return isPK;
    }

    public boolean isAutoIncrement() {
        return isAutoIncrement;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public boolean isNotNull() {
        return isNotNull;
    }

    public String getDefVal() {
        return defVal;
    }

    public void setFieldName(String name) {
        this.fieldName = name;
    }

    public void setFieldType(String type) {
        this.fieldType = type;
    }

    public void setPK(boolean isPK) {
        this.isPK = isPK;
    }

    public void setAutoIncrement(boolean isAutoIncrement) {
        this.isAutoIncrement = isAutoIncrement;
    }

    public void setUnique(boolean isUnique) {
        this.isUnique = isUnique;
    }

    public void setNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
    }

    public void setDefVal(String defVal) {
        this.defVal = defVal;
    }

}
