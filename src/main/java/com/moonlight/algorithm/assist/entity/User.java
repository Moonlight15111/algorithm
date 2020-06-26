package com.moonlight.algorithm.assist.entity;

import com.moonlight.algorithm.assist.helper.CastColumn;

/**
 * @ClassName User
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/6/26 14:04
 * @Version V1.0
 **/
public class User {
    @CastColumn(name = "id", setMethodName = "setId")
    private int id;
    @CastColumn(name = "name", setMethodName = "setName")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
