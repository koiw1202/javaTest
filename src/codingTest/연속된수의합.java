package codingTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-08-03        koiw1       최초 생성
 */
public class 연속된수의합 {
    public int[] solution(int num, int total) {

        int answer = 0;

        for(int i = -100; i <= 100; i++) {
            int tempAnswer = 0;

            for(int j=0; j < num; j++) {
                tempAnswer += i + j;
            }
            if(tempAnswer == total) {
                answer = i;
                break;
            }
        }

        int[] answerArr = new int[num];

        for(int j=0; j < num; j++) {
            answerArr[j] = answer + j;
        }

        return answerArr;
    }
}
