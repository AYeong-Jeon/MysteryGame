package com.repository;

import com.aggregate.User;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static final String USER_FILE = "/Users/jeon-ayeong/Desktop/test.txt";

    public Map<String, User> loadUsers() {
        if (new File(USER_FILE).exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
                return (Map<String, User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("loadUserErr");
            }
        }
        return new HashMap<>();
    }

    public void saveUsers(Map<String, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            throw new RuntimeException("saveUserErr");
        }
    }

}