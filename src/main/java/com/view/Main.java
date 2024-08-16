package com.view;

import com.util.MessageUtil;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        MessageUtil message = new MessageUtil();
        message.getHintMsg();
        message.getBossMsg();
    }
}