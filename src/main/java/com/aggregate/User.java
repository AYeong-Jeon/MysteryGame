package com.aggregate;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String id;
    private String pwd;
    private String totalPlayTime;

    public User(String name, String id, String pwd, String totalPlayTime) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.totalPlayTime = totalPlayTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(String totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", totalPlayTime='" + totalPlayTime + '\'' +
                '}';
    }
}

