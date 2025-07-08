package codingTest;

import java.util.Arrays;

public class NumberConversion {

    public static void main(String[] args) {

        int x = 10;
        int y = 50;
        int n = 10;

        int[] dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for(int i=x; i <= y; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;

            if(i+n <= y) {
                dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
            }
            if(i*2 <= y) {
                dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
            }
            if(i*3 <= y) {
                dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
            }
        }

        System.out.println(dp[y] == Integer.MAX_VALUE ? -1 : dp[y]);

    }
}