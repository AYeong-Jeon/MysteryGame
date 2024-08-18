package com.util;

public class MessageUtil {

    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    public void getStartMsg() {
        System.out.println("\n\n");
        System.out.println("도시는 오랜 시간 동안 평온했지만, 최근 들어 미스터리한 사건들이 연달아 일어나며 주민들의 불안이 커지고 있습니다. " + "\n" +
                "명탐정 성민은 도시에 도착하자마자 도시에 대한 첫 인상을 남길 수 있는 중대한 사건을 맞이하게 됩니다. ");
        System.out.println("\n");
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

    public String getHorrorGameStartMsg() {
        return "\n\n\n\n공포 게임 START\n\n"
                + "\n\n한적한 시골 마을에 있는 오래된 병원. " + "\n" +
                "1930년대에 지어진 이 병원은 한때 전염병 환자들을 치료하던 곳이었다. " + "\n" +
                "그러나 병원은 곧 비극의 중심지가 되었다. 환자들은 치료를 받는 도중 비명도 지르지 못한 채 사라졌고, 의사와 간호사들은 미쳐가며 서로를 공격하기 시작했다. " + "\n" +
                "병원에서는 실험적 치료법이 진행되었고, 그 과정에서 무언가 끔찍한 일이 벌어졌다. 급기야 병원 전체가 폐쇄되었고, 그 뒤로 아무도 이곳에 발을 들이지 않았다." + "\n" +
                "하지만 최근, 이곳에서 이상한 불빛이 목격되고, 밤마다 마을로부터 들리지 않던 끔찍한 비명 소리가 들려왔다. " + "\n" +
                "사람들은 이곳을 두려워하며 절대 접근하지 않았지만, 당신은 이 비밀을 밝혀내기 위해 병원에 들어가기로 한다.\n\n";
    }

}
