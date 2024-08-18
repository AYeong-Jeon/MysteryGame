package com.service;

import com.util.HorrorMessageUtil;
import com.util.ImageUtil;
import com.util.MessageUtil;
import com.util.TimeUtil;

import java.util.Scanner;

public class GameService {

    static Scanner scanner = new Scanner(System.in);
    static MessageUtil messageUtil = new MessageUtil();
    static ImageUtil imageUtil = new ImageUtil();
    static TimeUtil timeUtil = new TimeUtil();
    static HorrorMessageUtil horrorMessageUtil = new HorrorMessageUtil();
    static boolean running = true;

    public void startGame() {
        messageUtil.getStartMsg();
        selectStartGame();
    }

    public void selectStartGame() {

        while (running) {
            //running = false;
            System.out.println("1. 게임하기");
            System.out.println("2. 도움말");
            System.out.println("3. 게임 랭킹 조회(클리어 타임)");
            System.out.println("4. 회원 정보 수정 (비번 수정)");
            System.out.println("5. 회원 탈퇴");
            System.out.println("6. 게임 종료");
            System.out.print("원하는 메뉴의 번호를 입력해주세요. : ");

            int num = 0;
            while (true) {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    messageUtil.getButtonErrorMsg();
                }

                num = scanner.nextInt();

                if (num >= 1 && num <= 6) {
                    break;
                } else {
                    messageUtil.getButtonErrorMsg();
                }
            }

            switch (num) {
                case 1:
                    System.out.println("\n\n");
                    System.out.println("게임을 시작합니다.");
                    gameStart();
                    break;
                case 2:
                    System.out.println("\n\n");
                    System.out.println("도움말:???????????");
                    // 추가적인 도움말 내용
                    break;
                case 3:
                    System.out.println("\n\n");
                    System.out.println("게임 랭킹을 조회합니다");
                    // 여기에 랭킹 조회 코드 추가
                    break;
                case 4:
                    System.out.println("\n\n");
                    System.out.print("새 비밀번호를 입력하세요 : ");
                    String newPassword = scanner.next();
                    // 여기에 비밀번호 수정 코드 추가
                    System.out.println("비밀번호가 변경되었습니다.");
                    break;
                case 5:
                    System.out.println("\n\n");
                    System.out.print("정말로 회원 탈퇴하시겠습니까? (y/n) ");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("예")) {
                        System.out.println("회원 탈퇴가 완료되었습니다.");
                        // 여기에 회원 탈퇴 코드 추가
                    } else {
                        System.out.println("회원 탈퇴가 취소되었습니다.");
                    }
                    break;
                case 6:
                    System.out.println("\n\n");
                    System.out.println("게임을 종료합니다.");
                    //running = true;
                    break;
            }

            System.out.println();
        }
    }

    public void gameStart() {
        System.out.println("\n\n");
        System.out.println("게임을 선택하세요. : ");
        System.out.println("1. 추리 게임");
        System.out.println("2. 공포 게임");

        while (!scanner.hasNextInt()) {
            scanner.next();
            messageUtil.getButtonErrorMsg();
        }

        int mode = scanner.nextInt();
        while (!(mode == 1 || mode == 2)) {
            messageUtil.getButtonErrorMsg();
            mode = scanner.nextInt();
        }

        if (mode == 1) {
            System.out.println("\n\n추리 게임 START\n");
        } else if (mode == 2) {
            horrorGameStart();
        } else {
            System.out.println("\n\n잘못된 입력입니다. 게임이 선택되지 않았습니다.\n");
        }
        System.out.println();
    }

    public void horrorGameStart() {
        horrorMessageUtil.getWarningMsg();
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameStartMsg(), 30);
        System.out.println(imageUtil.horrorGameStartImg());

        horrorGameLevel1();
    }

    public void horrorGameLevel1() {
        System.out.println("문을 열고 들어가려면 1번을 입력해주세요.");

        while (true) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                messageUtil.getButtonErrorMsg();
            }

            int num = scanner.nextInt();
            if (num == 1) {
                break;
            } else {
                messageUtil.getButtonErrorMsg();
            }
        }
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameFirstMsg(), 20);
        System.out.println(imageUtil.horrorGameFirstImg());

        System.out.println(messageUtil.getGameEndMsg());
        while (true) {
            while (!scanner.hasNextLine()) {
                scanner.next();
                messageUtil.getButtonErrorMsg();
            }

            String c = scanner.nextLine();
            if ("병동".equals(c)) {
                System.out.println("\n정답입니다. 병동으로 이동합니다.\n\n");
                break;
            } else if ("h".equals(c)) {
                System.out.println("1. 정답은 두 글자 입니다.");
                System.out.println("2. 나침반 왼쪽에 다른 문자가 있습니다.\n" +
                        " _             _    _    _       \n" +
                        "| |           | |  | |  | |      \n" +
                        "| |__    ___  | |_ | |_ | |  ___ \n" +
                        "| '_ \\  / _ \\ | __|| __|| | / _ \\\n" +
                        "| |_) || (_) || |_ | |_ | ||  __/\n" +
                        "|_.__/  \\___/  \\__| \\__||_| \\___|" + "\n");
                System.out.println(messageUtil.getAnswerMsg());
                System.out.println("정답 : ");
            } else if ("정답".equals(c)) {
                System.out.println("\n 정답은 [병동] 입니다. \n");
                System.out.println("정답 : ");
            } else {
                messageUtil.getButtonErrorMsg();
            }
        }

    }

}
