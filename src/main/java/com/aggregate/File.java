package com.aggregate;

import java.io.Serializable;

public class File implements Serializable {
    private String title;
    private String contents;

    @Override
    public String toString() {
        return "File{" +
                "title=" + title +
                "contents" + contents +
                "}" ;
    }

}
