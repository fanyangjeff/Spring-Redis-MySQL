package com.redisdemo.entity;

import java.io.Serializable;

/*
 * @author Jeff
 * @date 9/10/21 2:26 PM
 */
public class Student implements Serializable {
    private String uid;

    private String name;
    public Student(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }
    public Student() {}


    public String getUid() {
        return uid;
    }
    public String getName() {
        return name;
    }


}
