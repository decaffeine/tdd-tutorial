package baseball;

import java.util.Objects;

public class Score {

    private int balls;
    private int strikes;

    public Score(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public int balls() {
        return 0;
    }

    public int strikes() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return balls == score.balls &&
                strikes == score.strikes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, strikes);
    }

    @Override
    public String toString() {
        return "Score{" +
                "balls=" + balls +
                ", strikes=" + strikes +
                '}';
    }
}
