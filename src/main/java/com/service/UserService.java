package com.service;

import com.aggregate.User;
import com.repository.UserRepository;

import java.util.Map;
import java.util.Scanner;

public class UserService {

    static Scanner scanner = new Scanner(System.in);
    private UserRepository userRepository = new UserRepository();
    static String loggedInUser = null;

    public String login() {
        System.out.print("아이디를 입력하세요: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        Map<String, User> users = userRepository.loadUsers();

        if (users.containsKey(userId)) {
            User user = users.get(userId);
            if (user.getPwd().equals(password)) {
                loggedInUser = userId;
                System.out.println("로그인 성공! " + user.getName() + "님 환영합니다.");
                return loggedInUser;
            }
        }

        return "로그인 실패. 아이디 또는 비밀번호가 일치하지 않습니다.";
    }

    public void createUser() {
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print(" 아이디를 입력하세요: ");
        String newUserId = scanner.nextLine();
        System.out.print(" 비밀번호를 입력하세요: ");
        String newPassword = scanner.nextLine();

        Map<String, User> users = userRepository.loadUsers();

        if (users.containsKey(newUserId)) {
            System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 선택하세요.");
        } else {
            User newUser = new User(name, newUserId, newPassword, 0, "00:00:00");
            users.put(newUserId, newUser);
            userRepository.saveUsers(users);
            System.out.println("회원가입 성공! 아이디: " + newUserId);
            loggedInUser = newUserId;
        }
    }
}
