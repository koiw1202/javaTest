package codingTest;

import java.util.*;

public class PerfectCrime {

    static final int INF = 100000;

    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        // DP 배열 초기화
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE; // 초기값을 무한대로 설정
            }
        }
        dp[0][0] = 0; // 초기 상태: A도둑과 B도둑의 흔적이 0인 상태

        // 각 물건에 대해 DP 업데이트
        for (int i = 1; i < info.length; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            // 역순으로 업데이트하여 이전 상태를 유지
            for (int j = 0; j < m; j++) {

                // A도둑이 물건을 훔치는 경우
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + aTrace);

                // B도둑이 물건을 훔치는 경우
                if(j + bTrace < m){
                    dp[i][j + bTrace] = Math.min(dp[i][j + bTrace], dp[i-1][j]);
                }
            }

        }

        // A도둑의 흔적의 최소값 찾기
        int minA = Integer.MAX_VALUE;

        for(int j = 0; j < m; j++){
            minA = Math.min(dp[info.length][j], minA);
        }

        return minA == Integer.MAX_VALUE ? -1 : minA;
    }
}