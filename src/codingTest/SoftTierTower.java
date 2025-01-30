package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class SoftTierTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 기둥의 수 N과 최대 연산 횟수 K 입력
        int N = scanner.nextInt();
        long K = scanner.nextLong();
        long[] heights = new long[N];

        // 각 기둥의 높이 입력
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextLong();
        }

        // 최대 높이 찾기
        long maxHeight = findMaxHeight(heights, K);
        System.out.println(maxHeight);

        scanner.close();
    }

    private static long findMaxHeight(long[] heights, long K) {
        long left = 0;
        long right = 0;

        // 현재 최대 높이 계산
        for (long height : heights) {
            right = Math.max(right, height);
        }

        // K를 모두 사용할 수 있는 최대 높이 계산
        right += K;

        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canAchieveHeight(heights, mid, K)) {
                result = mid; // 현재 높이를 달성할 수 있다면 결과 업데이트
                left = mid + 1; // 더 높은 높이를 시도
            } else {
                right = mid - 1; // 낮은 높이를 시도
            }
        }

        return result;
    }

    private static boolean canAchieveHeight(long[] heights, long targetHeight, long K) {
        long requiredK = 0;
        int N = heights.length;

        // 각 기둥의 높이를 목표 높이에 맞추기 위해 필요한 K 계산
        for (int i = 0; i < N; i++) {
            if (heights[i] < targetHeight) {
                requiredK += targetHeight - heights[i];
            }
            // 인접 기둥의 높이 차이를 고려하여 필요한 K 계산
            if (i > 0 && heights[i] < heights[i - 1] + 1) {
                long diff = heights[i - 1] + 1 - heights[i];
                requiredK += diff;
            }
        }

        return requiredK <= K;
    }
}