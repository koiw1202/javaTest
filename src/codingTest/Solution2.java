package codingTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-30        koiw1       최초 생성
 */
public class Solution2 {
    final static Solution2 method = new Solution2();

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int k = 1000 * 100;
        t1 += 10;
        t2 += 10;
        temperature += 10;

        int[][] DP = new int[onboard.length][51];
        for (int i = 0; i < onboard.length; i++) {
            for (int j = 0; j < 51; j++) {
                DP[i][j] = k;
            }
        }

        DP[0][temperature] = 0;

        int flag = 1;
        if (temperature > t2) {
            flag = -1;
        }

        for (int i = 1; i < onboard.length; i++) {
            for (int j = 0; j < 51; j++) {
                int minV = k;
                if (( onboard[i] == 1 && t1 <= j && j <= t2 ) || onboard[i] == 0) {

                    if (0 <= j+flag && j+flag <= 50) {
                        minV = method.min(minV, DP[i-1][j+flag]);
                    }

                    if (j == temperature) {
                        minV = method.min(minV, DP[i-1][j]);
                    }

                    if (0 <= j-flag && j-flag <= 50) {
                        minV = method.min(minV, DP[i-1][j-flag] + a);
                    }

                    if (t1 <= j && j <= t2) {
                        minV = method.min(minV, DP[i-1][j] + b);
                    }

                    DP[i][j] = minV;

                }
            }

//            for(int a1 = 0 ; a1 < DP.length; a1++){
//                for(int a2 = 0 ; a2 < DP[a1].length; a2++){
//                    System.out.print(DP[a1][a2] + " ");
//                }
//                System.out.println();
//            }

        }

        int i = onboard.length-1;
        int answer = DP[i][0];
        for (int j = 1; j < 51; j++) {
            answer = method.min(answer, DP[i][j]);
        }
        return answer;
    }

    public int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}