package baseball.domain;

import java.util.List;

public class Ball {

    private final static int BALL_SIZE = 3;

    private List<Integer> ball;

    public Ball(List<Integer> ball) {
        this.ball = ball;
    }

    public List<Integer> getBall() {
        return this.ball;
    }

    public int getBallCount(List<Integer> ball, List<Integer> userBall) {
        int ballCount = 0;

        for (int i = 0; i < BALL_SIZE; i++) {
            if (ball.contains(userBall.get(i)) && !ball.get(i).equals(userBall.get(i))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public int getStrikeCount(List<Integer> ball, List<Integer> userBall) {
        int strikeCount = 0;

        for (int i = 0; i < BALL_SIZE; i++) {
            if (ball.get(i).equals(userBall.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

}
