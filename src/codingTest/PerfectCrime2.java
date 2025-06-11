package codingTest;

import java.util.Arrays;

class PerfectCrime2 {

    public static final int MAX_TRACE = 120;

    public static void main(String[] args) {
        solution(new int[][]{{1,2}, {2,3}, {2,1}}, 4, 4);

    }

    public static int solution(int[][] info, int n, int m) {
        int[] bTraces = new int[n];

        Arrays.fill(bTraces, MAX_TRACE + 1);
        bTraces[0] = 0;

        for (int[] traces : info) {
            for (int aTrace = n - 1; aTrace >= 0; aTrace--) {
                bTraces[aTrace] += traces[1];

                if (aTrace - traces[0] >= 0) {
                    bTraces[aTrace] = Math.min(bTraces[aTrace], bTraces[aTrace - traces[0]]);
                }
            }
        }

        for (int aTrace = 0; aTrace < n; aTrace++) {
            if (bTraces[aTrace] < m) {
                return aTrace;
            }
        }

        return -1;
    }
}