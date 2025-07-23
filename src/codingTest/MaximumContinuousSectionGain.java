package codingTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-07-23        koiw1       최초 생성
 */
public class MaximumContinuousSectionGain {


    public static void main(String[] args) {

//        N K
//        w₁ w₂ ... wₙ  (일했을 때의 이득)
//        r₁ r₂ ... rₙ  (쉬었을 때의 이득)

        int N = 5;
        int K = 3;

        int[] work = {1,1,1,2,2};
        int[] rest = {1,1,1,1,1};

        int totalRest = 0;
        int totalWork = 0;
        int[] diff = new int[N];  // work - rest

        for (int i = 0; i < N; i++) {
            totalRest += rest[i];
            totalWork += work[i];
            diff[i] = Math.abs(work[i] - rest[i]);
        }

        int windowSum = 0;
        for (int i = 0; i < K; i++) windowSum += diff[i];

        int maxGain = windowSum;
        int index = K;
        for (int i = K; i < N; i++) {
            windowSum = windowSum - diff[i - K] + diff[i];

            if(maxGain < windowSum) {
                index = i - K;
                maxGain = windowSum;
            }
        }

        index--;
        int answer = 0;
        if(totalRest > totalWork) {
            answer = (rest[index] + rest[index+1] + rest[index+2]) + totalWork - (work[index] + work[index+1] + work[index+2]) ;
        } else {
            answer = (work[index] + work[index+1] + work[index+2]) + totalRest - (rest[index] + rest[index+1] + rest[index+2]) ;
        }

        System.out.println("정답: " + answer);


    }
}































