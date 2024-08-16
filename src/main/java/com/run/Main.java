package com.run;

import com.util.ImageUtil;
import com.util.MessageUtil;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        ImageUtil message = new ImageUtil();
        System.out.println(message.getBossImg());

        int count = 0;
        while (count<10) {
            System.out.println(message.horrorImg1());
            System.out.println(message.horrorImg2());
            count++;
        }

        String textToBlink = message.horrorImg1();
        String textToBlink2 = message.horrorImg2();
        int interval = 50; // 깜빡임 간격 (밀리초 단위)
        int repetitions = 100; // 깜빡임 반복 횟수

        try {
            for (int i = 0; i < repetitions; i++) {
                System.out.print("\r" + textToBlink); // 텍스트 출력 및 커서를 행의 시작으로 이동
                Thread.sleep(interval); // 대기
                System.out.print("\r" + textToBlink2);
                Thread.sleep(interval); // 대기
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}