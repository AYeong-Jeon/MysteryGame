package com.repository;

import com.aggregate.User;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static final String USER_FILE = "C:/Users/USER/Desktop/Users.txt";

    public Map<String, User> loadUsers() {
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

    public void saveUsers(Map<String, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("회원 정보를 저장하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}