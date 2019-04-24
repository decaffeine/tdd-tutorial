import baseball.Game;
import baseball.Score;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GameTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidParamCount() {
        Game game = new Game(1, 2, 3);
        game.guess(1, 2);
        game.guess(1,2,3,4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNumberRange() {
        Game game = new Game(1,2,3);
        game.guess(-1,2,3);
        game.guess(1,10,3);
        game.guess(1,2,-3);
    }

    @Test
    public void noMatch() {
        Game game = new Game(1,2,3);
        Score s = game.guess(4,5,6);
        assertEquals(0, s.balls());
        assertEquals(0, s.strikes());
    }

    @Test
    public void oneStrike() {
        Game game = new Game(1,2,3);
        Score s = game.guess(1,4,5);
        assertEquals(new Score(0,1), s);

        Game game2 = new Game(9,2,3);
        Score s2 = game2.guess(9,4,5);
        assertEquals(new Score(0,1), s2);
    }

    @Test
    public void twoStrike() {
        Game game = new Game(1,2,3);
        Score s = game.guess(1,2,4);
        assertEquals(new Score(0,2), s);

        Game game2 = new Game(9,2,3);
        Score s2 = game2.guess(1,2,3);
        assertEquals(new Score(0,2), s2);
    }

    @Test
    public void threeStrike() {
        Game game = new Game(1,2,3);
        Score s = game.guess(1,2,3);
        assertEquals(new Score(0,3), s);
    }

    @Test
    public void oneBall() {
        Game game = new Game(1,2,3);
        assertScore(game.guess(4,1,5), new Score(1,0));
        assertScore(game.guess(4,5,1), new Score(1,0));

    }

    @Test
    public void oneBallOneStrike() {
        Game game = new Game(1,2,3);
        assertScore(game.guess(1,4,2), new Score(1,1));
        assertScore(game.guess(3,2,4), new Score(1,1));
        assertScore(game.guess(2,5,3), new Score(1,1));
    }

    @Test
    public void twoBall() {
        Game game = new Game(1,2,3);
        assertScore(game.guess(4,1,2), new Score(2,0));
        assertScore(game.guess(5,1,2), new Score(2,0));
        assertScore(game.guess(2,3,6), new Score(2,0));

    }

    static public void assertScore(Object expected, Object actual) {
        assertEquals(null, expected, actual);
    }


}
