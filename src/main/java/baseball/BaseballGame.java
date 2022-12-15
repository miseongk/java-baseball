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
    private boolean isGoing;

    public BaseballGame() {
        this.input = new InputView();
        this.output = new OutputView();
        this.ballGenerator = new BallGenerator();
        this.isGoing = true;
    }

    public void play() {
        output.printStartGameMessage();
        ball = ballGenerator.generate();
        while (isGoing) {
            int inputNumber = inputNumber();
            getResult(inputNumber);
        }
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
            askRetryGame();
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

    private void askRetryGame() {
        output.printRetryGameMessage();
        int retryCommand = input.inputRetryCommand();

        if (retryCommand == 1) {
            restart();
        }
        if (retryCommand == 2) {
            isGoing = false;
        }
    }

    private void restart() {
        ball = ballGenerator.generate();
    }
}
