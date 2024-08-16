package com.util;

public class MessageUtil {

    public void getStartMsg() {
        System.out.println("도시는 오랜 시간 동안 평온했지만, 최근 들어 미스터리한 사건들이 연달아 일어나며 주민들의 불안이 커지고 있습니다. " +
                "명탐정성민은 도시에 도착하자마자 도시에 대한 첫 인상을 남길 수 있는 중대한 사건을 맞이하게 됩니다. ");
    }

    public void getHintMsg () {
        System.out.println("힌트를 보시겠습니까?(y/n)");
    }

    public void getLoginErrorMsg() {

    }

    public void getButtonErrorMsg () {
        System.out.println("잘못 누르셨습니다. 번호를 다시 입력해주세요.");
    }

}
