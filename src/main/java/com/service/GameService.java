package com.service;

import com.util.GuessingMessageUtil;
import com.util.HorrorMessageUtil;
import com.util.ImageUtil;
import com.util.MessageUtil;
import com.util.TimeUtil;

import java.util.Scanner;

public class GameService {

    Scanner scanner = new Scanner(System.in);

    public ImageUtil imageUtil = new ImageUtil();
    public TimeUtil timeUtil = new TimeUtil();
    public MessageUtil messageUtil = new MessageUtil();

    public HorrorMessageUtil horrorMessageUtil = new HorrorMessageUtil();
    public GuessingMessageUtil guessingMessageUtil = new GuessingMessageUtil();

    public UserService userService = new UserService();

    private static boolean running = true;

    public void startGame(String userId) {
        timeUtil.slowPrinter(messageUtil.getStartMsg(), 50);
        selectStartGame(userId);
    }

    public void selectStartGame(String userId) {
        while (running) {
            System.out.println("1. 게임하기");
            System.out.println("2. 도움말");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 탈퇴");
            System.out.println("5. 게임 종료");
            System.out.print("원하는 메뉴의 번호를 입력해주세요. : ");

            int num = 0;
            while (true) {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    messageUtil.getButtonErrorMsg();
                }

                num = scanner.nextInt();
                if (num >= 1 && num <= 5) {
                    break;
                } else {
                    messageUtil.getButtonErrorMsg();
                }
            }

            switch (num) {
                case 1:
                    gameStart();
                    break;
                case 2:
                    System.out.println("\n\n");
                    System.out.println("도움말");
                    helpMessage();
                    break;
                case 3:
                    if (userService.updatePassword(userId)) {
                        System.out.println("비밀번호가 변경되었습니다.");
                    } else {
                        System.err.println("비밀번호 변경 중 오류가 발생하였습니다.");
                    }
                    break;
                case 4:
                    if(userService.deleteUser()) {
                        System.out.println("회원 탈퇴가 완료되었습니다.");
                    } else {
                        System.out.println("회원 탈퇴가 취소되었습니다.");
                    }
                    break;
                case 5:
                    System.out.println("\n\n");
                    System.out.println("게임을 종료합니다.");
                    running = false;
                    break;
            }

            System.out.println();
        }
    }

    public void gameStart() {
        System.out.println("\n\n게임을 시작합니다.\n\n");
        System.out.println("게임을 선택하세요 : ");
        System.out.println("1. 추리 게임");
        System.out.println("2. 공포 게임");

        while (!scanner.hasNextInt()) {
            scanner.next();
            messageUtil.getButtonErrorMsg();
        }

        int mode = scanner.nextInt();
        while (mode != 1 && mode != 2) {
            System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
            mode = scanner.nextInt();
        }

        if (mode == 1) {
            guessingGameStart();
        } else if (mode == 2) {
            horrorGameStart();
        }
    }

    public void helpMessage() {
        messageUtil.getHelpMessage();
    }

    private void guessingGameStart() {
        System.out.println(guessingMessageUtil.guessingGameStartMsg());
        System.out.println();

        boolean allQuestionsCorrect = true;

        if (!playMystery(1)) {
            allQuestionsCorrect = false;
        }
        if (!playMystery(2)) {
            allQuestionsCorrect = false;
        }
        if (!playMystery(3)) {
            allQuestionsCorrect = false;
        }
        if (allQuestionsCorrect) {
            System.out.println("\n모든 문제를 맞췄습니다! 축하합니다!\n\n");
            imageUtil.escape1();
        } else {
            System.out.println("\n문제를 모두 맞추지 못했습니다. 다시 시도해 보세요.\n");
        }
    }

    private boolean playMystery(int questionNumber) {
        String message = getMysteryQuestion(questionNumber);
        timeUtil.slowPrinter(message, 30);
        System.out.println("\n 정답을 입력해 주세요. (힌트는 [h]를 입력해 주세요.) : \n");

        boolean isCorrect = false;
        while (!isCorrect) {
            String input = scanner.next();

            if ("h".equalsIgnoreCase(input)) {
                provideHint(questionNumber);
                System.out.print(messageUtil.getGameEndMsg());
            } else {
                try {
                    int suspect = Integer.parseInt(input);
                    isCorrect = checkAnswer(questionNumber, suspect);
                    if (isCorrect) {
                        System.out.println("정답입니다!");
                    } else {
                        System.out.println("틀렸습니다. 다시 시도해 보세요.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력하거나 'h'를 입력해 주세요.");
                }
            }
        }
        return true;
    }

    private String getMysteryQuestion(int questionNumber) {
        switch (questionNumber) {
            case 1:
                return guessingMessageUtil.guessingMsg1();
            case 2:
                return guessingMessageUtil.guessingMsg2();
            case 3:
                return guessingMessageUtil.guessingMsg3();
            default:
                return "문제가 존재하지 않습니다.";
        }
    }

    private void provideHint(int questionNumber) {
        switch (questionNumber) {
            case 1:
                System.out.println("힌트 1: '모래시계는 시간이 흐르는 것을 나타냅니다. 그러나 이 문제에서 모래시계는 단순히 시간을 나타내는 것이 아니라, 특정 이름과의 언어적 연결을 의미합니다. '시간이 멈춘 것'과 관련이 있을 수 있습니다.'");
                System.out.println("힌트 2: '음악이 정지된 상태는 '멈춤'을 의미합니다. 이와 관련하여, 단서를 제공하는 이름은 발음이 다른 단어와 유사한 점이 있습니다. 특히, 모래시계의 단어와 발음이 비슷한 이름을 생각해 보세요.'");
                break;
            case 2:
                System.out.println("힌트 1: 'P씨의 컴퓨터에 남겨진 메시지 '741231475369'는 어떤 의미를 담고 있을까요? 숫자와 관련된 힌트를 생각해보세요.'");
                System.out.println("힌트 2: '전화기 키패트 숫자와 관련된 힌트를 생각해보세요.'");
                break;
            case 3:
                System.out.println("힌트 1: '다잉 메시지 'A ㅁ P'는 특정 단어의 약자일 수 있습니다. 해당 약자가 의미하는 것은 무엇일까요?'");
                System.out.println("힌트 2:  AOP 해당 약자가 의미하는 것은 무엇일까요?'");
                break;
            default:
                System.out.println("해당 문제의 힌트는 없습니다.");
                break;
        }
    }

    private boolean checkAnswer(int questionNumber, int suspect) {
        switch (questionNumber) {
            case 1:
                return (suspect == 2);
            case 2:
                return (suspect == 4);
            case 3:
                return (suspect == 1);
            default:
                return false;
        }
    }
    public void horrorGameStart() {
        horrorMessageUtil.getWarningMsg();
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameStartMsg(), 30);
        System.out.println(imageUtil.horrorGameStartImg());

        horrorGameLevel1();
    }
    public void horrorGameLevel1() {
        System.out.println("문을 열고 들어가려면 1번을 입력해주세요.");

        while (true) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                messageUtil.getButtonErrorMsg();
            }

            int num = scanner.nextInt();
            if (num == 1) {
                break;
            } else {
                messageUtil.getButtonErrorMsg();
            }
        }

        scanner.nextLine();
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameFirstMsg(), 40);
        System.out.println(imageUtil.horrorGameFirstImg());
        System.out.println(messageUtil.getGameEndMsg());

        while (true) {
            while (!scanner.hasNextLine()) {
                scanner.next();
                messageUtil.getButtonErrorMsg();
            }

            String c = scanner.nextLine();
            if ("병동".equals(c)) {
                System.out.println("\n정답입니다. 병동으로 이동합니다.\n\n");
                horrorGameLevel2();
                break;
            } else if ("힌트".equals(c)) {
                getHint(1);
            } else if ("정답".equals(c)) {
                getAnswer(1);
            } else {
                messageUtil.getButtonErrorMsg();
            }
        }
    }

    public void horrorGameLevel2() {
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameSecondMsg(), 50);
        System.out.println(imageUtil.horrorGameSecondImg());
        System.out.println(messageUtil.getGameEndMsg());

        while (true) {
            while (!scanner.hasNextLine()) {
                scanner.next();
                messageUtil.getButtonErrorMsg();
            }

            String c = scanner.nextLine();
            if ("원장".equals(c)) {
                System.out.println("\n정답입니다. 원장의 비밀 실험실로 이동합니다.\n\n");
                horrorGameLevel3();
                break;
            } else if ("힌트".equals(c)) {
                getHint(2);
            } else if ("정답".equals(c)) {
                getAnswer(2);
            } else {
                messageUtil.getButtonErrorMsg();
            }
        }
    }

    public void horrorGameLevel3() {
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameThirdMsg(), 50);
        System.out.println(imageUtil.horrorGameThirdImg());
        System.out.println(messageUtil.getGameEndMsg());

        while (true) {
            while (!scanner.hasNextLine()) {
                scanner.next();
                messageUtil.getButtonErrorMsg();
            }

            String c = scanner.nextLine();
            if ("26734".equals(c)) {
                System.out.println("\n정답입니다. 출구로 이동합니다.\n\n");
                horrorGameSuccess();
                break;
            } else if ("힌트".equals(c)) {
                getHint(3);
            } else if ("정답".equals(c)) {
                getAnswer(3);
            } else {
                messageUtil.getButtonErrorMsg();
            }
        }
    }

    public void horrorGameSuccess () {
        horrorMessageUtil.horrorImgView();
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameFinalMsg(), 20);
        System.out.println("\n\n");
    }

    public void getHint(int levelNum) {
        System.out.println("\n");
        switch (levelNum) {
            case 1 :
                System.out.println("1. 정답은 두글자 입니다.");
                System.out.println("2. 나침반 왼쪽에 다른 문자가 있습니다.\n" +
                        " _             _    _    _       \n" +
                        "| |           | |  | |  | |      \n" +
                        "| |__    ___  | |_ | |_ | |  ___ \n" +
                        "| '_ \\  / _ \\ | __|| __|| | / _ \\\n" +
                        "| |_) || (_) || |_ | |_ | ||  __/\n" +
                        "|_.__/  \\___/  \\__| \\__||_| \\___|" + "\n");
                break;
            case 2 :
                System.out.println("1. 정답은 두글자 입니다.");
                System.out.println("2. one");
                break;
            case 3 :
                System.out.println("1. 일기 내용 중 특수 문자가 포함되어 있습니다.");
                System.out.println("2. 정답은 5개의 숫자 입니다.");
                break;
        }
        System.out.println(messageUtil.getAnswerMsg());
        System.out.println("정답 : ");
    }

    public void getAnswer(int levelNum) {
        switch (levelNum) {
            case 1 :
                System.out.println("\n 정답은 [병동] 입니다. \n");
                break;
            case 2:
                System.out.println("\n 정답은 [원장] 입니다. \n");
                break;
            case 3:
                System.out.println("\n 정답은 [26734] 입니다. \n");
                break;
        }
        System.out.println("정답 : ");
    }

}
