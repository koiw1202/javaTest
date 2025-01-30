package codingTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-30        koiw1       최초 생성
 */
public class Aircon {

    public static void main(String args[]) {

        Solution solution = new Solution();

//        solution.solution(28, 18, 26, 10, 8, new int[]{0, 0, 1, 1, 1, 1, 1});
        solution.solution(-10, -5, 5, 5, 1, new int[]{0, 0, 0, 0, 0, 1, 0});
    }
}

class Solution {

    int answer = Integer.MAX_VALUE;
    int a;
    int b;
    int externalTemperature;

    public int solution(int externalTemperature1, int t1, int t2, int a1, int b1, int[] onboard) {

        int currentTemperature = externalTemperature1;
        a = a1;
        b = b1;
        externalTemperature = externalTemperature1;

        dp(1, onboard, currentTemperature, t1, t2, 0);

        System.out.println(answer);

        return answer;

    } // End of solution method

    public void dp(int depth, int[] onboard, int currentTemperature, int t1, int t2, int energy) {

        if(answer != Integer.MAX_VALUE && answer < energy) {
            return;
        }

        if(depth == onboard.length) {
            if( onboard[depth - 1] == 1) {
                if( t1 <= currentTemperature && currentTemperature <= t2 ){
                    if(answer > energy) {
                        answer = energy;
                    }
                }
            } else {
                if(answer > energy) {
                    answer = energy;
                }
            }
            return;
        } // End of depth 체크

        if(onboard[depth - 1] == 1) {
            if( ! (t1 <= currentTemperature && currentTemperature <= t2)) {
                return;
            }
        }

        dp(depth + 1, onboard, calcTemperature(currentTemperature, externalTemperature), t1, t2, energy); // off 상태(실내온도 -> 실외온도로 이동)
        dp(depth + 1, onboard, currentTemperature, t1, t2, energy + b); // 에어컨 on 상태 온도가 같은 경우
        dp(depth + 1, onboard,  calcTemperature2(currentTemperature, t1, t2), t1, t2, energy + a); // 에어컨 on 상태 온도가 다른 경우

    } // End of dp method

    public int calcTemperature(int currentTemperature, int externalTemperature) {
        if(currentTemperature > externalTemperature) {
            return --currentTemperature;
        } else if(currentTemperature < externalTemperature) {
            return ++currentTemperature;
        } else {
            return currentTemperature;
        }
    }

    public int calcTemperature2(int currentTemperature, int t1, int t2) {
        int differenceT1 = Math.abs(t1 - currentTemperature);
        int differenceT2 = Math.abs(t2 - currentTemperature);

        if(differenceT1 > differenceT2) {
            currentTemperature--;
        } else {
            currentTemperature++;
        }
        return currentTemperature;
    }
} // End of class

