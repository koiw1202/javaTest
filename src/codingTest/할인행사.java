package codingTest;

import java.util.*;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-08-03        koiw1       최초 생성
 */
public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 슬라이딩 윈도우: discount 배열에서 연속된 10개씩 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            // 현재 10일간 할인 품목의 개수 세기
            Map<String, Integer> map = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }

            boolean isMatch = true;

            // 내가 원하는 품목이 정확히 있는지 확인
            for (int k = 0; k < want.length; k++) {
                if (map.getOrDefault(want[k], 0) != number[k]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) answer++;
        }

        return answer;
    }

}
