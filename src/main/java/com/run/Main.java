package com.run;

import com.service.GameService;
import com.service.UserService;
import com.util.MessageUtil;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static GameService gameService = new GameService();
    public static UserService userService = new UserService();
    static MessageUtil messageUtil = new MessageUtil();

    public static void main(String[] args) {
        while (true) {
            System.out.println("================================================================================================================================================================");
            System.out.println(" _______   _______ .___________. _______   ______ .___________. __  ____    ____  _______      _______. __    __  .__   __.   _______ .___  ___.  __  .__   __. \n" +
                    "|       \\ |   ____||           ||   ____| /      ||           ||  | \\   \\  /   / |   ____|    /       ||  |  |  | |  \\ |  |  /  _____||   \\/   | |  | |  \\ |  | \n" +
                    "|  .--.  ||  |__   `---|  |----`|  |__   |  ,----'`---|  |----`|  |  \\   \\/   /  |  |__      |   (----`|  |  |  | |   \\|  | |  |  __  |  \\  /  | |  | |   \\|  | \n" +
                    "|  |  |  ||   __|      |  |     |   __|  |  |         |  |     |  |   \\      /   |   __|      \\   \\    |  |  |  | |  . `  | |  | |_ | |  |\\/|  | |  | |  . `  | \n" +
                    "|  '--'  ||  |____     |  |     |  |____ |  `----.    |  |     |  |    \\    /    |  |____ .----)   |   |  `--'  | |  |\\   | |  |__| | |  |  |  | |  | |  |\\   | \n" +
                    "|_______/ |_______|    |__|     |_______| \\______|    |__|     |__|     \\__/     |_______||_______/     \\______/  |__| \\__|  \\______| |__|  |__| |__| |__| \\__| \n" +
                    "                                                                                                                                                                ");
            System.out.println("=================================================================================================================================================================");

            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            String c = scanner.nextLine();

            String loggedInUser = null;
            if ("1".equals(c)) {
                loggedInUser = login();
            } else if ("2".equals(c)) {
                createUser();
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                continue;
            }

            if (loggedInUser != null) {
                startGame();
                break;
            } else {
                System.out.println("로그인이 필요합니다.");
            }
        }
    }

    public static String login() {
        try {
            return userService.login();
        } catch (Exception e) {
            if ("loadUserErr".equals(e.getMessage())) {
                System.out.println("사용자 정보를 불러오는 중 오류가 발생했습니다.");
            } else {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void createUser() {
        try {
            userService.createUser();
        } catch (Exception e) {
            if ("saveUserErr".equals(e.getMessage())) {
                System.out.println("사용자 정보를 저장하는 중 오류가 발생했습니다.");
            } else if ("loadUserErr".equals(e.getMessage())) {
                System.out.println("사용자 정보를 불러오는 중 오류가 발생했습니다.");
            } else {
                e.printStackTrace();
            }
        }
    }

    public static void startGame() {
        try {
            gameService.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopGame() {
        System.out.println("게임을 종료합니다.");
    }
}
