package com.run;

import com.util.ImageUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================================================================================================================================================");
        System.out.println(" _______   _______ .___________. _______   ______ .___________. __  ____    ____  _______      _______. __    __  .__   __.   _______ .___  ___.  __  .__   __. \n" +
                "|       \\ |   ____||           ||   ____| /      ||           ||  | \\   \\  /   / |   ____|    /       ||  |  |  | |  \\ |  |  /  _____||   \\/   | |  | |  \\ |  | \n" +
                "|  .--.  ||  |__   `---|  |----`|  |__   |  ,----'`---|  |----`|  |  \\   \\/   /  |  |__      |   (----`|  |  |  | |   \\|  | |  |  __  |  \\  /  | |  | |   \\|  | \n" +
                "|  |  |  ||   __|      |  |     |   __|  |  |         |  |     |  |   \\      /   |   __|      \\   \\    |  |  |  | |  . `  | |  | |_ | |  |\\/|  | |  | |  . `  | \n" +
                "|  '--'  ||  |____     |  |     |  |____ |  `----.    |  |     |  |    \\    /    |  |____ .----)   |   |  `--'  | |  |\\   | |  |__| | |  |  |  | |  | |  |\\   | \n" +
                "|_______/ |_______|    |__|     |_______| \\______|    |__|     |__|     \\__/     |_______||_______/     \\______/  |__| \\__|  \\______| |__|  |__| |__| |__| \\__| \n" +
                "                                                                                                                                                                ");
        System.out.println("=================================================================================================================================================================");

        System.out.println("1. 게임하기");
        System.out.println("2. 최근 게임 기록");
        System.out.println("3. 회원 가입");
        System.out.println("4. 회원 정보 수정");
        System.out.println("5. 회원 탈퇴");
        System.out.println("6. 도움말");
        System.out.println("7. 설정");
        System.out.println("9. 게임 종료");
        System.out.print("메뉴 선택 : ");


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