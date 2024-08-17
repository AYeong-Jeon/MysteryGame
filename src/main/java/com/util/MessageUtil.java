package com.util;

public class MessageUtil {

    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    public void getStartMsg() {
        System.out.println("도시는 오랜 시간 동안 평온했지만, 최근 들어 미스터리한 사건들이 연달아 일어나며 주민들의 불안이 커지고 있습니다. " +
                "명탐정성민은 도시에 도착하자마자 도시에 대한 첫 인상을 남길 수 있는 중대한 사건을 맞이하게 됩니다. ");
    }

    public void getHintMsg () {
        System.out.println("힌트를 보시겠습니까?(y/n)");
    }

    public void getLoadUserErrorMsg() {
        System.out.println("회원정보를 불러오는 중 오류가 발생했습니다.");
    }

    public void getSaveErrorMsg() {
        System.out.println("회원 정보를 저장하는 중 오류가 발생했습니다.");
    }

    public void getButtonErrorMsg () {
        System.out.println("잘못 누르셨습니다. 번호를 다시 입력해주세요.");
    }

    public void getWarningMsg() {
        String text = """
                ##   ##    ##     ######   ##   ##  ######   ##   ##    #### \s
                ##   ##    ##     ##   ##  ###  ##    ##     ###  ##   ##  ##\s
                ## # ##   ####    ##   ##  ###  ##    ##     ###  ##  ##     \s
                ## # ##   ## #    ######   ## # ##    ##     ## # ##  ##     \s
                ## # ##  ######   ## ##    ## # ##    ##     ## # ##  ##  ###\s
                ### ###  ##   #   ##  ##   ##  ###    ##     ##  ###   ##  ##\s
                ##   ## ###   ##  ##   ##  ##   ##  ######   ##   ##    #####\s
        """;
        System.out.println("");
        System.out.println(RED + text + RESET);
        System.out.println("⚠\uFE0F 본 게임은 폐병동에 관한 내용을 포함하고 있습니다. ⚠\uFE0F");
        System.out.println("⚠\uFE0F 심장이 약하신 분이나 노약자, 어린이, 강사님은 " +
                "성민이와 함께 플레이 해주시기 바랍니다. ⚠\uFE0F");
        System.out.println("");
    }

}
