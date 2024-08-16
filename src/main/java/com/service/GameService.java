package com.service;

import com.util.ImageUtil;

public class GameService {

    public void startGame() {
        System.out.println("1. 게임하기");
        System.out.println("2. 최근 게임 기록");
        System.out.println("3. 회원 가입");
        System.out.println("4. 회원 정보 수정");
        System.out.println("5. 회원 탈퇴");
        System.out.println("6. 도움말");
        System.out.println("7. 설정");
        System.out.println("9. 게임 종료");
        System.out.print("메뉴 선택 : ");
    }

    /* 게임 실패시 깜빡거리는 호러 이미지 노출 */
    public void gameFailImgView() {
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
