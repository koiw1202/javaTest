package codingTest;

public class SumOfConsecutiveSubarrays {

    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        for(int right = 0 ; right < sequence.length; right++) {
            currentSum += sequence[right];

            while(currentSum > k) {
                currentSum -= sequence[left];
                left++;
            }

            // 조건을 만족하는지 체크
            // 1. k와 값이 일치하는지
            int currentLength = right - left;

            if(currentSum == k) {

                // 2. 길이가 짧은지
                if(minLength > currentLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        System.out.println(answer[0] + "," + answer[1]);





    }
}