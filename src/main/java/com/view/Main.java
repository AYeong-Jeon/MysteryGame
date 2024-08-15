package com.view;

import com.util.MessageUtil;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        MessageUtil message = new MessageUtil();
        System.out.println(message.getHintMsg());
    }
}