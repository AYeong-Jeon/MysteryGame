package com.util;

public class MessageUtil {

    public void getStartMsg() {
        System.out.println("\n\n");
        System.out.println("도시는 오랜 시간 동안 평온했지만, 최근 들어 미스터리한 사건들이 연달아 일어나며 주민들의 불안이 커지고 있습니다. " + "\n" +
                "명탐정 성민은 도시에 도착하자마자 도시에 대한 첫 인상을 남길 수 있는 중대한 사건을 맞이하게 됩니다. ");
        System.out.println("\n");
    }

    public String getGameEndMsg() {
        return "\n 정답을 입력해 주세요. (힌트는 [힌트]를 입력해 주세요.) : \n";
    }

    public String getAnswerMsg() {
        return "(정답을 보시려면 [정답]이라고 입력해주세요.)";
    }

    public void getLoadUserErrorMsg() {
        System.out.println("회원정보를 불러오는 중 오류가 발생했습니다.");
    }

    public void getSaveErrorMsg() {
        System.out.println("회원 정보를 저장하는 중 오류가 발생했습니다.");
    }

    public void getButtonErrorMsg () {
        System.out.println("잘못 누르셨습니다. 다시 입력해주세요.");
    }

}
