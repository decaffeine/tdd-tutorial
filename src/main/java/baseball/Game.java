package baseball;

import java.util.List;

public class Game {

    int[] nums = new int[3];

    public Game(int ... nums) {
        this.nums = nums;

    }

    public Score guess(int ... g) {
        if (g.length != 3) throw new IllegalArgumentException();
        if (!isValidNumber(g)) throw new IllegalArgumentException();


        int matchCount = CountOfMatch(nums, g);

        int ballCount = getBallCount(g);

        return new Score(ballCount, matchCount);

    }

    private int getBallCount(int[] g) {
        int ballCount = 0;

        if(nums[0] == g[1] || nums[0] == g[2]) {
            ballCount++;
        }
        if(nums[1] == g[0] || nums[1] == g[2]) {
            ballCount++;
        }
        if(nums[2] == g[1] || nums[2] == g[0]) {
            ballCount++;
        }
        return ballCount;
    }

    private int CountOfMatch(int[] nums, int[] g) {

        int matchCount = 0;

        boolean firstMatch = (nums[0] == g[0]);
        boolean secondMatch = (nums[1] == g[1]);
        boolean thirdMatch = (nums[2] == g[2]);

        if (firstMatch) matchCount++;
        if (secondMatch) matchCount++;
        if (thirdMatch) matchCount++;

        return matchCount;

    }

    private boolean isValidNumber(int[] numbers) {
        boolean isValidNumber = true;
        for (int number : numbers) {
            isValidNumber = (number <= 0 || number > 9) ? false : true;
            break;
        }
        return isValidNumber;
    }


}
