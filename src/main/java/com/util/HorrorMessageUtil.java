package com.util;

public class HorrorMessageUtil {

    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    public void gameFailImgView() {
        ImageUtil message = new ImageUtil();
        System.out.println(message.getBossImg());

        int count = 0;
        while (count < 10) {
            System.out.println(message.horrorImg1());
            System.out.println(message.horrorImg2());
            count++;
        }

        String textToBlink = message.horrorImg1();
        String textToBlink2 = message.horrorImg2();
        int interval = 50; // 깜빡임 간격 (밀리초 단위)
        int repetitions = 100; // 깜빡임 반복 횟수

        try {
            for (int i = 0; i < repetitions; i++) {
                System.out.print("\r" + textToBlink);
                Thread.sleep(interval); // 대기
                System.out.print("\r" + textToBlink2);
                Thread.sleep(interval); // 대기
            }
        } catch (InterruptedException e) {

        }
    }

    public void getWarningMsg() {
        System.out.println("\n\n\n\n");
        String text = """
                ##   ##    ##     ######   ##   ##  ######   ##   ##    #### \s
                ##   ##    ##     ##   ##  ###  ##    ##     ###  ##   ##  ##\s
                ## # ##   ####    ##   ##  ###  ##    ##     ###  ##  ##     \s
                ## # ##   ## #    ######   ## # ##    ##     ## # ##  ##     \s
                ## # ##  ######   ## ##    ## # ##    ##     ## # ##  ##  ###\s
                ### ###  ##   #   ##  ##   ##  ###    ##     ##  ###   ##  ##\s
                ##   ## ###   ##  ##   ##  ##   ##  ######   ##   ##    #####\s
        """;
        System.out.println(RED + text + RESET);
        System.out.println("\n⚠\uFE0F 본 게임은 폐병동에 관한 내용을 포함하고 있습니다. ⚠\uFE0F");
        System.out.println("\n⚠\uFE0F 심장이 약하신 분이나 노약자, 어린이, 강사님은 " +
                "성민이와 함께 플레이 해주시기 바랍니다. ⚠\uFE0F\n");
        System.out.println();
    }

    public String getHorrorGameStartMsg() {
        return "\n\n한적한 시골 마을에 있는 오래된 병원. " + "\n" +
                "1930년대에 지어진 이 병원은 한때 전염병 환자들을 치료하던 곳이었다. " + "\n" +
                "그러나 병원은 곧 비극의 중심지가 되었다. 환자들은 치료를 받는 도중 비명도 지르지 못한 채 사라졌고, 의사와 간호사들은 미쳐가며 서로를 공격하기 시작했다. " + "\n" +
                "병원에서는 실험적 치료법이 진행되었고, 그 과정에서 무언가 끔찍한 일이 벌어졌다. 급기야 병원 전체가 폐쇄되었고, 그 뒤로 아무도 이곳에 발을 들이지 않았다." + "\n" +
                "하지만 최근 이곳에서 이상한 불빛이 목격되고, 밤마다 마을로부터 들리지 않던 끔찍한 비명 소리가 들려왔다. " + "\n" +
                "사람들은 이곳을 두려워하며 절대 접근하지 않았지만, 당신은 이 비밀을 밝혀내기 위해 병원에 들어가기로 한다.\n\n";
    }

    public String getHorrorGameFirstMsg() {
        return "\n\n폐병원의 녹슨 철문을 열고 들어선 순간, 문이 스스로 닫히며 잠기고 만다." + "\n" +
                "병원 내부는 침묵에 잠겨 있지만, 공기는 무겁고 끈적한 불안감이 감돈다. " + "\n" +
                "구석구석에서 들려오는 알 수 없는 속삭임이 당신의 신경을 건드리고, 무엇인가가 여러분을 감시하고 있다는 느낌이 든다." + "\n" +
                "더 이상 돌아갈 수 없다. 이 병원에서 탈출하기 전까지는 결코 편안한 순간은 없을 것이다.\n\n\n\n"+
                "여러분이 처음 도착한 곳은 오래된 수술실이다." + "\n" +
                "희미한 불빛 아래, 녹슨 수술 도구들이 여기저기 흩어져 있고, 수술대 위에는 썩어가는 인형 같은 모형이 놓여 있다." + "\n" +
                "그러나 가까이 다가가면 그것이 인형이 아니라 실제 인간의 시체라는 것을 깨닫게 된다." + "\n" +
                "벽에는 말라붙은 피로 그린 이상한 기호와 글씨가 적혀 있다."+ "\n";
    }


}
