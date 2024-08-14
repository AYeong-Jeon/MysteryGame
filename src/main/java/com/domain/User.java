package com.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

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
