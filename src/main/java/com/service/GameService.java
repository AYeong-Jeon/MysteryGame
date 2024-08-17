package com.service;

import com.aggregate.User;
import com.util.ImageUtil;
import com.util.MessageUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GameService {

    static Scanner scanner = new Scanner(System.in);
    static MessageUtil messageUtil = new MessageUtil();

    public void startGame() {
        messageUtil.getStartMsg();
        selectStartGame();
    }
    public void selectStartGame() {
        boolean running = true;

        while (running) {
            System.out.println("1. 게임하기");
            System.out.println("2. 도움말");
            System.out.println("3. 게임 랭킹 조회(클리어 타임)");
            System.out.println("5. 회원 정보 수정 (비번 수정)");
            System.out.println("6. 회원 탈퇴");
            System.out.println("7. 설정(추리, 공포)");
            System.out.println("9. 게임 종료");
            System.out.print("원하는 메뉴의 번호를 입력해주세요. : ");

            try {
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        // 게임하기 기능
                        System.out.println("게임을 시작합니다");
                        // 여기에 게임 시작 코드 추가
                        break;
                    case 2:
                        // 도움말 기능
                        System.out.println("도움말:???????????");
                        // 추가적인 도움말 내용
                        break;
                    case 3:
                        // 게임 랭킹 조회 기능
                        System.out.println("게임 랭킹을 조회합니다");
                        // 여기에 랭킹 조회 코드 추가
                        break;
                    case 5:
                        // 회원 정보 수정 (비번 수정) 기능
                        System.out.print("새 비밀번호를 입력하세요: ");
                        String newPassword = scanner.next();
                        // 여기에 비밀번호 수정 코드 추가
                        System.out.println("비밀번호가 변경되었습니다.");
                        break;
                    case 6:
                        // 회원 탈퇴 기능
                        System.out.print("정말로 회원 탈퇴하시겠습니까? (예/아니오): ");
                        String confirm = scanner.next();
                        if (confirm.equalsIgnoreCase("예")) {
                            System.out.println("회원 탈퇴가 완료되었습니다.");
                            // 여기에 회원 탈퇴 코드 추가
                        } else {
                            System.out.println("회원 탈퇴가 취소되었습니다.");
                        }
                        break;
                    case 7:
                        // 설정 기능 (추리, 공포)
                        System.out.println("설정을 변경합니다");
                        System.out.println("1. 추리 모드");
                        System.out.println("2. 공포 모드");
                        System.out.print("모드를 선택하세요: ");
                        int mode = scanner.nextInt();
                        if (mode == 1) {
                            System.out.println("추리 모드로 변경.");
                        } else if (mode == 2) {
                            System.out.println("공포 모드로 변경.");
                        } else {
                            System.out.println("잘못된 입력입니다. 설정이 변경되지 않았습니다.");
                        }
                        break;
                    case 9:
                        // 게임 종료 기능
                        System.out.println("게임을 종료합니다.");
                        running = false;
                        break;
                    default:
                        // 잘못된 입력 처리
                        System.out.println("잘못된 번호입니다. 다시 시도해주세요.");
                        break;
                }
            } catch (InputMismatchException e) {
                messageUtil.getButtonErrorMsg();
                scanner.nextLine();
            }

            System.out.println();
        }
    }

    public void gameFailImgView() {
        ImageUtil message = new ImageUtil();
        System.out.println(message.getBossImg());

        int count = 0;
        while (count < 10) {
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
                System.out.print("\r" + textToBlink);
                Thread.sleep(interval); // 대기
                System.out.print("\r" + textToBlink2);
                Thread.sleep(interval); // 대기
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
