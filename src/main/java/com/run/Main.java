package com.run;

import com.aggregate.User;
import com.service.GameService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static GameService gameService = new GameService();
    static String loggedInUser = null;

    // 유저 정보를 저장할 파일
    static final String USER_FILE = "C:/Users/USER/Desktop/Users.txt";

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

        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        String c = scanner.nextLine();

        if ("1".equals(c)) {
            login();
        } else {
            createUser();
        }

        // 로그인한 유저만 게임 페이지 진입 가능
        if (loggedInUser != null) {
            startGame();
        } else {
            System.out.println("로그인이 필요합니다.");
        }
    }

    public static void login() {
        System.out.print("아이디를 입력하세요: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        Map<String, User> users = loadUsers();

        if (users.containsKey(userId)) {
            User user = users.get(userId);
            if (user.getPwd().equals(password)) {
                loggedInUser = userId;
                System.out.println("로그인 성공! " + user.getName() + "님 환영합니다.");
                return;
            }
        }

        System.out.println("로그인 실패. 아이디 또는 비밀번호가 일치하지 않습니다.");
    }

    public static void createUser() {
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("새 아이디를 입력하세요: ");
        String newUserId = scanner.nextLine();
        System.out.print("새 비밀번호를 입력하세요: ");
        String newPassword = scanner.nextLine();

        Map<String, User> users = loadUsers();

        if (users.containsKey(newUserId)) {
            System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 선택하세요.");
        } else {
            User newUser = new User(name, newUserId, newPassword, 0, "00:00:00");
            users.put(newUserId, newUser);
            saveUsers(users);
            System.out.println("회원가입 성공! 아이디: " + newUserId);
            loggedInUser = newUserId;
        }
    }

    public static void startGame() {
        gameService.startGame();
    }

    public static void stopGame() {
        System.out.println("게임을 종료합니다.");
    }

    private static void saveUsers(Map<String, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("회원 정보를 저장하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    private static Map<String, User> loadUsers() {
        if (new File(USER_FILE).exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
                return (Map<String, User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("회원정보를 불러오는 중 오류가 발생했습니다.");
                e.printStackTrace();
            }
        }
        return new HashMap<>();
    }
}
