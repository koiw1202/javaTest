package codingTest;

public class Dot {

    public static void main(String[] args) {

        int k = 1;
        int d = 5;

        long answer = 0;

//        제한사항
//        •	1 ≤ k ≤ 1,000,000
//        •	1 ≤ d ≤ 1,000,000

        int mod = d/k;

        for(int i=0; i < d; i += k) {
            answer += mod;
        }

        System.out.println(answer);





    }
}
