package com.service;

import com.aggregate.User;
import com.repository.UserRepository;
import com.util.ImageUtil;

import java.util.*;

public class UserService {

    static Scanner scanner = new Scanner(System.in);

    public UserRepository userRepository = new UserRepository();
    public ImageUtil imageUtil = new ImageUtil();

    static String loggedInUser = null;

    public String login() {
        while (true) {
            System.out.print("아이디를 입력하세요 : \n");
            String userId = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요 : \n");
            String password = scanner.nextLine();

            Map<String, User> users = userRepository.loadUsers();

            if (users.containsKey(userId)) {
                User user = users.get(userId);

                if (user.getPwd().equals(password)) {
                    loggedInUser = userId;
                    System.out.println("\n\n로그인 성공! " + user.getName() + "님 환영합니다.\n\n");

                    return loggedInUser;
                } else {
                    System.out.println("\n\n비밀번호가 일치하지 않습니다. 다시 로그인 해주세요.\n\n");
                }
            } else {
                System.out.println("\n\n아이디가 존재하지 않습니다. 다시 로그인 해주세요.\n\n");
            }

            System.out.println("\n다시 로그인을 시도하려면 1번을 입력하세요.");
            System.out.println("회원가입을 하려면 2번을 입력하세요.\n");
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
            System.out.print("이름을 입력하세요 : \n");
            String name = scanner.nextLine();
            System.out.print("아이디를 입력하세요 : \n");
            String newUserId = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요 : \n");
            String newPassword = scanner.nextLine();

            Map<String, User> users = userRepository.loadUsers();

            if (users.containsKey(newUserId)) {
                System.out.println("\n이미 존재하는 아이디입니다. 다른 아이디를 선택하세요.\n");
            } else {
                User newUser = new User(name, newUserId, newPassword, 0, "00:00:00");
                users.put(newUserId, newUser);
                userRepository.saveUsers(users);
                System.out.println("\n\n회원가입 성공! 아이디: " + newUserId + "\n\n");
                loggedInUser = newUserId;
                return;
            }
        }
    }

    public void selectAllRanking() {
        Map<String, User> users = userRepository.loadUsers();

        System.out.println(imageUtil.getBossImg());
        System.out.println("\n===================================================================");
        if (users.isEmpty()) {
            System.out.println("\n\n 문제를 풀어라. \n\n");
        } else {
            List<Map.Entry<String, User>> userList = new ArrayList<>(users.entrySet());
            userList.sort(Comparator.comparing(entry -> entry.getValue().getTotalPlayTime()));

            Map<String, User> sortedUsers = new LinkedHashMap<>();
            for (Map.Entry<String, User> entry : userList) {
                sortedUsers.put(entry.getKey(), entry.getValue());
            }

            int count = 0;
            for (Map.Entry<String, User> entry : sortedUsers.entrySet()) {
                count++;
                System.out.println("|  " + count + "  |  ID : " + entry.getKey() + "  |  User : " + entry.getValue().getName() + "  |  TotalPlayTime : " + entry.getValue().getTotalPlayTime() + " | ");
                if (count == 10) break;
            }
            System.out.println("\n\n");
        }

    }

    public void updateTotalTime(String userId, String totalTime) {
        Map<String, User> userMap = new HashMap<>();
        Map<String, User> users = userRepository.loadUsers();
        if (users.isEmpty()) {
            System.out.println("사용자 정보가 없습니다.");
        } else {
            for (Map.Entry<String, User> entry : users.entrySet()) {
                if(userId.equals(users.get(userId).getId())) {
                    User newUser = new User(users.get(userId).getName(), users.get(userId).getId(), users.get(userId).getPwd(), users.get(userId).getScore(), totalTime);
                    userMap.put(users.get(userId).getId(), newUser);
                }
                userMap.put(entry.getKey(), entry.getValue());
            }
        }
        userRepository.saveUsers(userMap);
    }

    public boolean updatePassword(String userId) {
        boolean result = false;

        while (true) {
            System.out.print("\n본인 확인을 위해 로그인한 아이디를 입력하세요 : \n");
            String newUserId = scanner.nextLine();
            if (!userId.equals(newUserId)) {
                System.out.println("\n\n회원 아이디가 일치하지 않습니다. 다시 입력해주세요.\n");
            } else {
                break;

            }
        }

        System.out.print("\n\n변경할 새 비밀번호를 입력하세요 : ");
        String newPassword = scanner.nextLine();

        Map<String, User> userMap = new HashMap<>();
        Map<String, User> users = userRepository.loadUsers();
        if (users.isEmpty()) {
            System.out.println("사용자 정보가 없습니다.");
        } else {
            for (Map.Entry<String, User> entry : users.entrySet()) {
                if(userId.equals(users.get(userId).getId())) {
                    User newUser = new User(users.get(userId).getName(), users.get(userId).getId(), newPassword, users.get(userId).getScore(), users.get(userId).getTotalPlayTime());
                    userMap.put(users.get(userId).getId(), newUser);
                    result = true;
                }
                userMap.put(entry.getKey(), entry.getValue());
            }
        }
        userRepository.saveUsers(userMap);

        return result;
    }

    public boolean deleteUser() {
        boolean result = false;
        System.out.print("\n\n정말로 회원 탈퇴하시겠습니까? (y/n) ");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("y")) {
            System.out.println(imageUtil.textBoxImg());
            System.out.print("\n\n선택: ");
            int finalConfirm = scanner.nextInt();

            if (finalConfirm == 1) {
                String userIdToDelete = loggedInUser;

                Map<String, User> users = userRepository.loadUsers();

                if (users.containsKey(userIdToDelete)) {
                    users.remove(userIdToDelete);
                    userRepository.saveUsers(users);

                    System.out.println("회원 탈퇴가 완료되었습니다.");
                    result = true;
                    System.exit(0);
                } else {
                    System.out.println("사용자를 찾을 수 없습니다.");
                }
            } else {
                System.out.println("회원 탈퇴가 취소되었습니다.");
                result = false;
            }
        } else {
            System.out.println("회원 탈퇴가 취소되었습니다.");
        }
        return result;
    }
}