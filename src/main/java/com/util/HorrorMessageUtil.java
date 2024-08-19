package com.util;

public class HorrorMessageUtil {

    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    public void horrorImgView() {
        ImageUtil message = new ImageUtil();

        int count = 0;
        while (count < 10) {
            System.out.println(message.horrorImg1());
            System.out.println(message.horrorImg2());
            count++;
        }

        String textToBlink = message.horrorImg1();
        String textToBlink2 = message.horrorImg2();
        int interval = 50; // 깜빡임 간격 (밀리초 단위)
        int repetitions = 20; // 깜빡임 반복 횟수

        try {
            for (int i = 0; i < repetitions; i++) {
                System.out.print("\r" + textToBlink);
                Thread.sleep(interval);
                System.out.print("\r" + textToBlink2);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
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

    public String getHorrorGameSecondMsg() {
        return "\n\n수술실을 빠져나와 병동으로 들어서면, 이곳은 병원에서 가장 많은 사람들이 사라진 곳이다." + "\n" +
                "병원 내부는 침묵에 잠겨 있지만, 공기는 무겁고 끈적한 불안감이 감돈다. " + "\n" +
                "병실 문들은 일부 열려 있고, 안에는 오래된 침대와 벽에 걸린 사진들이 보인다. 사진 속 인물들의 얼굴은 모자이크처럼 흐려져 있다. " + "\n" +
                "갑자기 복도 끝에서 문이 닫히는 소리와 함께 아이의 웃음소리가 들려온다. 문을 열기 위해서는 복도 끝에 있는 방으로 가야 한다." + "\n\n\n\n"+
                "끼 익 . . . \n\n"
                ;
    }

    public String getHorrorGameThirdMsg() {
        return "\n\n이 방은 병원의 심장부, 가장 깊은 곳에 위치한 원장의 비밀 실험실이다." + "\n" +
                "방 안에는 원장의 일기와 금고가 남아 있다. 일기에는 정신을 조작하고 죽음을 초월하는 실험이 기록되어 있다." + "\n" +
                "그리고 원장은 병원에서 벌어진 끔찍한 일들을 기록해 두었으며, 금고에 모든 운영 기록을 봉인해 두었다고 적혀있다." + "\n" +
                "벽에는 실험 중 사망한 환자들의 사진이 걸려 있고, 그들의 얼굴은 고통으로 일그러져 있다." + "\n"
                ;
    }

    public String getHorrorGameFinalMsg() {
        return "출구를 찾아 병원을 탈출하던 순간, 원장의 그림자는 점점 가까워지고, 출구가 눈앞에 있을 때쯤, 병원 전체가 갑자기 흔들리며 무너지기 시작한다."  + "\n" +
                " 여러분은 간신히 병원 밖으로 나올 수 있었지만, 뒤돌아본 병원은 흔적도 없이 사라져 있었다. "  + "\n" +
                "그리고 마지막으로, 여러분의 손에 남아 있는 것은 원장의 방에서 발견한 낡은 열쇠뿐이다. "  + "\n\n" +
                "이 열쇠는 정말로 병원의 출구 열쇠였을까? 아니면 또 다른 문을 열기 위한 것일까?";
    }

}
