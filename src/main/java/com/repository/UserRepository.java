package com.repository;

import com.aggregate.User;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    //private static final String USER_FILE = "/Users/jeon-ayeong/Desktop/test.txt";
    private static final String USER_FILE = "C:/Users/USER/Desktop/Users.txt/";

    public Map<String, User> loadUsers() {
        File file = new File(USER_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Map<String, User>) ois.readObject();
            } catch (EOFException e) {
                return new HashMap<>();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("사용자 정보를 불러오는 중 오류가 발생했습니다.");
            }
        }
        return new HashMap<>();
    }

    public void saveUsers(Map<String, User> users) {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("파일 생성 중 오류가 발생했습니다.");
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(users);
            //System.out.println("사용자 정보를 파일에 저장했습니다.");
        } catch (IOException e) {
            System.err.println("사용자 정보 저장 실패\n파일 경로 : " + USER_FILE);
        }
    }

    public boolean deleteFile() {
        File file = new File(USER_FILE);
        if( file.exists() ){
            return file.delete();
        }else{
            return false;
        }
    }

}