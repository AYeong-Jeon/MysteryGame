package com.aggregate;

public enum GameStatus {
    WAIT("대기중"),
    START("게임시작"),
    END("게임종료");

    private String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
