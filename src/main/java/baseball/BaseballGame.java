package baseball;

import baseball.domain.Ball;
import baseball.domain.BallGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final static int BALL_SIZE = 3;

    private final InputView input;
    private final OutputView output;
    private final BallGenerator ballGenerator;
    private Ball ball;

    public BaseballGame() {
        this.input = new InputView();
        this.output = new OutputView();
        this.ballGenerator = new BallGenerator();
    }

    public void play() {
        output.printStartGameMessage();
        ball = ballGenerator.generate();
        int inputNumber = inputNumber();
        getResult(inputNumber);
    }

    private int inputNumber() {
        output.printInputMessage();

        return input.inputNumber();
    }

    private void getResult(int number) {
        List<Integer> userBall = makeBallList(number);
        int ballCount = ball.getBallCount(userBall);
        int strikeCount = ball.getStrikeCount(userBall);

        output.printResult(ballCount, strikeCount);
        if (isRight(strikeCount)) {
            output.printCorrectNumberMessage();
            output.printRetryGameMessage();
            input.inputRetryCommand();
        }
    }

    private List<Integer> makeBallList(int number) {
        List<Integer> ball = new ArrayList<>();

        for (int i = BALL_SIZE - 1; i >= 0; i--) {
            ball.add(number / (int) Math.pow(10, i));
            number %= (int) Math.pow(10, i);
        }

        return ball;
    }

    private boolean isRight(int strikeCount) {
        return strikeCount == BALL_SIZE;
    }
}
