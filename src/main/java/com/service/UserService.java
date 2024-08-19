package com.service;

import com.aggregate.User;
import com.repository.UserRepository;

import java.util.Map;
import java.util.Scanner;

public class UserService {

    static Scanner scanner = new Scanner(System.in);
    public UserRepository userRepository = new UserRepository();
    static String loggedInUser = null;

    public String login() {
        while (true) {
            System.out.print("아이디를 입력하세요 : ");
            String userId = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요 : ");
            String password = scanner.nextLine();

            Map<String, User> users = userRepository.loadUsers();

            if (users.containsKey(userId)) {
                User user = users.get(userId);

                if (user.getPwd().equals(password)) {
                    loggedInUser = userId;
                    System.out.println("로그인 성공! " + user.getName() + "님 환영합니다.");

                    return loggedInUser;
                } else {
                    System.out.println("로그인 실패. 비밀번호가 일치하지 않습니다.");
                }
            } else {
                System.out.println("로그인 실패. 아이디가 존재하지 않습니다.");
            }

            System.out.println("다시 로그인 시도하려면 1번을 입력하세요.");
            System.out.println("회원가입을 하려면 2번을 입력하세요.");
            String choice = scanner.nextLine();
            if ("1".equals(choice)) {
                continue;
            } else if ("2".equals(choice)) {
                createUser();
                continue;
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                continue;
            }
        }
    }

    public void createUser() {
        while (true) {
            System.out.print("이름을 입력하세요 : ");
            String name = scanner.nextLine();
            System.out.print("아이디를 입력하세요 : ");
            String newUserId = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요 : ");
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
                return;
            }
        }
    }

}