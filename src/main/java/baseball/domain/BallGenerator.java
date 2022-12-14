package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallGenerator {

    private static final int BALL_SIZE = 3;
    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 9;

    public Ball generate() {
        List<Integer> ball = new ArrayList<>();

        while (ball.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
            if (!ball.contains(randomNumber)) {
                ball.add(randomNumber);
            }
        }
        return new Ball(ball);
    }
}
