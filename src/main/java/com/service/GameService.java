package com.service;

import com.util.ImageUtil;
import com.util.MessageUtil;

import java.util.Scanner;

public class GameService {

    static Scanner scanner = new Scanner(System.in);
    static MessageUtil messageUtil = new MessageUtil();

    static boolean running = true;

    public void startGame() {
        messageUtil.getStartMsg();
        selectStartGame();
    }
    public void selectStartGame() {

        while (running) {
            System.out.println("1. 게임하기");
            System.out.println("2. 도움말");
            System.out.println("3. 게임 랭킹 조회(클리어 타임)");
            System.out.println("4. 회원 정보 수정 (비번 수정)");
            System.out.println("5. 회원 탈퇴");
            System.out.println("6. 게임 종료");
            System.out.print("원하는 메뉴의 번호를 입력해주세요. : ");

            while (!scanner.hasNextInt()) {
                scanner.next();
                messageUtil.getButtonErrorMsg();
            }
            int num = scanner.nextInt();
            while(num<1 || num>6) {
                messageUtil.getButtonErrorMsg();
                num = scanner.nextInt();
            }

            switch (num) {
                case 1:
                    System.out.println("\n\n");
                    System.out.println("게임을 시작합니다");
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
                    break;
            }

            System.out.println();
        }
    }

    public void gameStart() {
        System.out.println("\n\n");
        System.out.println("1. 추리 모드");
        System.out.println("2. 공포 모드");
        System.out.print("모드를 선택하세요 : ");

        while (!scanner.hasNextInt()) {
            scanner.next();
            messageUtil.getButtonErrorMsg();
        }

        int mode = scanner.nextInt();
        while(mode!=1 || mode!=2) {
            messageUtil.getButtonErrorMsg();
            mode = scanner.nextInt();
        }

        if (mode == 1) {
            System.out.println("추리 모드로 변경");
        } else if (mode == 2) {
            System.out.println("공포 모드로 변경");
            horrorGameStart();
        } else {
            System.out.println("잘못된 입력입니다. 설정이 변경되지 않았습니다.");
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

        }
    }

    private void horrorGameStart() {
        System.out.println("\n\n\n\n");
        System.out.println("한적한 시골 마을에 있는 오래된 병원. " + "\n" +
                "1930년대에 지어진 이 병원은 한때 전염병 환자들을 치료하던 곳이었다. " + "\n" +
                "그러나 병원은 곧 비극의 중심지가 되었다. 환자들은 치료를 받는 도중 비명도 지르지 못한 채 사라졌고, 의사와 간호사들은 미쳐가며 서로를 공격하기 시작했다. " + "\n" +
                "병원에서는 실험적 치료법이 진행되었고, 그 과정에서 무언가 끔찍한 일이 벌어졌다. 급기야 병원 전체가 폐쇄되었고, 그 뒤로 아무도 이곳에 발을 들이지 않았다." + "\n" +
                "하지만 최근, 이곳에서 이상한 불빛이 목격되고, 밤마다 마을로부터 들리지 않던 끔찍한 비명 소리가 들려왔다. " + "\n" +
                "사람들은 이곳을 두려워하며 절대 접근하지 않았지만, 당신은 이 비밀을 밝혀내기 위해 병원에 들어가기로 한다.");
        System.out.println("\n\n");

    }

}
