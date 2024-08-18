package com.service;

import com.util.GuessingMessageUtil;
import com.util.HorrorMessageUtil;
import com.util.ImageUtil;
import com.util.MessageUtil;
import com.util.TimeUtil;

import java.util.Scanner;

public class GameService {

    static Scanner scanner = new Scanner(System.in);
    static GuessingMessageUtil guessingMessageUtil = new GuessingMessageUtil();
    static ImageUtil imageUtil = new ImageUtil();
    static TimeUtil timeUtil = new TimeUtil();
    static MessageUtil messageUtil = new MessageUtil(); // MessageUtil 인스턴스 생성
    static HorrorMessageUtil horrorMessageUtil = new HorrorMessageUtil();
    static boolean running = true;

    public void startGame() {
        // 게임 시작 메시지 출력
        messageUtil.getStartMsg(); // MessageUtil의 getStartMsg() 메서드 호출
        selectStartGame(); // 게임 메뉴를 선택합니다.
    }

    public void selectStartGame() {
        while (running) {
            System.out.println("1. 게임하기");
            System.out.println("2. 도움말");
            System.out.println("3. 게임 랭킹 조회(클리어 타임)");
            System.out.println("4. 회원 정보 수정 (비번 수정)");
            System.out.println("5. 회원 탈퇴");
            System.out.println("6. 게임 종료");
            System.out.print("원하는 메뉴의 번호를 입력해주세요. : ");

            int num = 0;
            while (true) {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    messageUtil.getButtonErrorMsg();
                }

                num = scanner.nextInt();

                if (num >= 1 && num <= 6) {
                    break;
                } else {
                    messageUtil.getButtonErrorMsg();
                }
            }

            switch (num) {
                case 1:
                    System.out.println("\n\n");
                    System.out.println("게임을 시작합니다.");
                    gameStart();
                    break;
                case 2:
                    System.out.println("\n\n");
                    System.out.println("도움말:???????????");
                    // 추가적인 도움말 내용
                    break;
                case 3:
                    System.out.println("\n\n");
                    System.out.println("게임 랭킹을 조회합니다");
                    // 여기에 랭킹 조회 코드 추가
                    break;
                case 4:
                    System.out.println("\n\n");
                    System.out.print("새 비밀번호를 입력하세요 : ");
                    String newPassword = scanner.next();
                    // 여기에 비밀번호 수정 코드 추가
                    System.out.println("비밀번호가 변경되었습니다.");
                    break;
                case 5:
                    System.out.println("\n\n");
                    System.out.print("정말로 회원 탈퇴하시겠습니까? (y/n) ");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("y")) {
                        System.out.println("회원 탈퇴가 완료되었습니다.");
                        // 여기에 회원 탈퇴 코드 추가
                    } else {
                        System.out.println("회원 탈퇴가 취소되었습니다.");
                    }
                    break;
                case 6:
                    System.out.println("\n\n");
                    System.out.println("게임을 종료합니다.");
                    running = false; // 게임 종료
                    break;
            }

            System.out.println();
        }
    }

    public void gameStart() {
        System.out.println("\n\n");
        System.out.println("게임을 선택하세요: ");
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
            startGuessingGame();
        } else if (mode == 2) {
            horrorGameStart();
        }
    }

    private void startGuessingGame() {
        // 추리 게임 시작 메시지 출력
        System.out.println(guessingMessageUtil.guessingGameStartMsg());
        System.out.println();

        // 문제를 순차적으로 출력하고 사용자의 답을 확인합니다.
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
            System.out.println("모든 문제를 맞췄습니다! 축하합니다!");
        } else {
            System.out.println("문제를 모두 맞추지 못했습니다. 다시 시도해 보세요.");
        }
    }

    private boolean playMystery(int questionNumber) {
        // 문제 메시지를 가져와서 출력
        String message = getMysteryQuestion(questionNumber);
        timeUtil.slowPrinter(message, 30); // 문제 메시지를 서서히 출력

        // 힌트 제공 여부를 물어봄
        System.out.print("힌트를 보시겠습니까? (1: 예, 2: 아니오): ");
        int hintChoice = scanner.nextInt();
        if (hintChoice == 1) {
            provideHint(questionNumber);
        }

        // 사용자로부터 범인 번호를 입력 받음
        System.out.print("\n범인은 누구일까요? 번호를 입력하세요: ");
        int suspect = scanner.nextInt();

        boolean isCorrect = checkAnswer(questionNumber, suspect);
        if (isCorrect) {
            System.out.println("정답입니다!");
            return true;
        } else {
            System.out.println("틀렸습니다.");
            return false;
        }
        System.out.println();
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
                // 문제 2에 대한 힌트를 여기에 추가
                System.out.println("힌트 1: 'P씨의 컴퓨터에 남겨진 메시지 '741231475369'는 어떤 의미를 담고 있을까요? 숫자와 관련된 힌트를 생각해보세요.'");
                break;
            case 3:
                // 문제 3에 대한 힌트를 여기에 추가
                System.out.println("힌트 1: '다잉 메시지 'A ㅁ P'는 특정 단어의 약자일 수 있습니다. 해당 약자가 의미하는 것은 무엇일까요?'");
                break;
            default:
                System.out.println("해당 문제의 힌트는 없습니다.");
                break;
        }
    }

    private boolean checkAnswer(int questionNumber, int suspect) {
        switch (questionNumber) {
            case 1:
                return (suspect == 3); // 문제 1의 정답
            case 2:
                return (suspect == 2); // 문제 2의 정답
            case 3:
                return (suspect == 4); // 문제 3의 정답
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
        timeUtil.slowPrinter(horrorMessageUtil.getHorrorGameFirstMsg(), 20);
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
                break;
            } else if ("h".equals(c)) {
                System.out.println("1. 정답은 두 글자 입니다.");
                System.out.println("2. 나침반 왼쪽에 다른 문자가 있습니다.\n" +
                        " _             _    _    _       \n" +
                        "| |           | |  | |  | |      \n" +
                        "| |__    ___  | |_ | |_ | |  ___ \n" +
                        "| '_ \\  / _ \\ | __|| __|| | / _ \\\n" +
                        "| |_) || (_) || |_ | |_ | ||  __/\n" +
                        "|_.__/  \\___/  \\__| \\__||_| \\___|" + "\n");
                System.out.println(messageUtil.getAnswerMsg());
                System.out.println("정답 : ");
            } else if ("정답".equals(c)) {
                System.out.println("\n 정답은 [병동] 입니다. \n");
                System.out.println("정답 : ");
            } else {
                messageUtil.getButtonErrorMsg();
            }
        }

    }

}
