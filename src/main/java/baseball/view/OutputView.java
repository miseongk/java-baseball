package baseball.view;

public class OutputView {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CORRECT_NUMBER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printInputMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printResult(int ball, int strike) {
        String result = "";

        if (ball > 0) {
            result += ball + BALL + " ";
        }
        if (strike > 0) {
            result += strike + STRIKE;
        }
        if (ball == 0 && strike == 0) {
            result += NOTHING;
        }

        System.out.println(result);
    }

    public void printCorrectNumberMessage() {
        System.out.println(CORRECT_NUMBER_MESSAGE);
    }

    public void printRetryGameMessage() {
        System.out.println(RETRY_GAME_MESSAGE);
    }
}
