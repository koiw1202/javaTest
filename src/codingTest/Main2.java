package codingTest;

import java.util.Scanner;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-16        koiw1       최초 생성
 */
public class Main2 {
    public static void main(String argsp[]) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt(); // 사람의 수
        int M = scanner.nextInt(); // CPTI의 길이
        int[] cpti = new int[N];

        for (int i = 0; i < N; i++) {
            String cptiString = scanner.next(); // 각 사람의 CPTI 문자열
            cpti[i] = Integer.parseInt(cptiString, 2); // 이진 문자열을 정수로 변환
        }

        int count = 0; // 친밀감을 느끼는 사람 쌍의 수

        // 모든 쌍을 비교
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 두 CPTI의 비트 차이 계산
                int diff = cpti[i] ^ cpti[j]; // XOR 연산
                // 서로 다른 성격 영역의 수 계산
                int diffCount = Integer.bitCount(diff); // 1의 개수 세기

                // 친밀감 조건 확인
                if (diffCount <= 2) {
                    count++;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
