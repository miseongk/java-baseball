package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    private Ball ball;

    @BeforeEach
    void init() {
        ball = new Ball(List.of(1, 2, 3));
    }

    @DisplayName("볼 개수가 2여야 한다.")
    @Test
    void getBallCount() {
        int ballCount = ball.getBallCount(ball.getBall(), List.of(1, 3, 2));
        assertThat(ballCount).isEqualTo(2);
    }

    @DisplayName("스트라이크 개수가 1이여야 한다.")
    @Test
    void getStrikeCount() {
        int ballCount = ball.getStrikeCount(ball.getBall(), List.of(1, 3, 2));
        assertThat(ballCount).isEqualTo(1);
    }
}