package com.aggregate;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int score;
    private String totalPlayTime;

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                "score=" + score +
                "totalPlayTime" + totalPlayTime +
                "}" ;
    }

}
