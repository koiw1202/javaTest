package codingTest;

import java.util.*;

class PerfectCrime {

    public static void main(String[] args) {

        int[][] info = {{1,2}, {2,3}, {2,1}};
        int n = 4;
        int m = 4;

        int N = info.length;
        final int INF = n + m + 1; // 충분히 큰 값

        // dp[i][j] = i개 물건 고려했을 때, A 흔적 = j일 경우 B 흔적의 최소값
        int[][] dp = new int[N + 1][n];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            int a = info[i][0];
            int b = info[i][1];
            for (int j = 0; j < n; j++) {
                if (dp[i][j] >= INF) continue;

                // A가 훔칠 경우
                if (j + a < n) {
                    dp[i + 1][j + a] = Math.min(dp[i + 1][j + a], dp[i][j]);
                }

                // B가 훔칠 경우
                if (dp[i][j] + b < m) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);
                }
            }
        }

        int ans = INF;
        for (int j = 0; j < n; j++) {
            if (dp[N][j] < m) {
                ans = Math.min(ans, j);
            }
        }

        System.out.println(ans == INF ? -1 : ans);
    }
}