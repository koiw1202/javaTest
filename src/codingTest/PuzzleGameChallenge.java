package codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PuzzleGameChallenge {

    public static void main(String[] args) {

        int[] diffs = {1,5,3};
        int[] times = {2,4,7};
        long limit = 30;

        int min = 1;
        int max = 100000;
        int answer = 0;

        while(min <= max) {

            int level = (max+min)/2;
            long mid = calulate(diffs, times, level);

            // 제한시간 초과
            if (limit < mid) {
                min = level + 1;
            } else {
                max = level - 1;
                answer = level;
            }
        }
        System.out.println(answer);
    }

    public static long calulate(int[] diffs, int[] times, int level) {

        long ans = 0;

        for(int i=0; i < diffs.length; i++) {
            if (diffs[i] <= level) ans += times[i];
            else ans += (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
        }

        return ans;
    }
}
