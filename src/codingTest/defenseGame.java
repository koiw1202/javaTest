package codingTest;

import java.util.Collections;
import java.util.PriorityQueue;

public class defenseGame {

    public static void main(String[] args) {

        int n = 7;
        int k = 3;
        int[] enemy = {10, 10, 10, 7, 3, 3, 1};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for(int i=0;i < enemy.length ;i++) {
            maxHeap.add(enemy[i]);
            int tempN = n - enemy[i];
            boolean enableKeepDoingFlag = true;

            while(true) {
                if(tempN >= 0) {
                    n = tempN;
                    break;
                }

                if(k > 0) {
                    Integer maxVal = maxHeap.poll();
                    tempN += maxVal;
                    k--;
                } else {
                    enableKeepDoingFlag = false;
                    break;
                }
            }

            // 지속할 수 없는 경우
            if( ! enableKeepDoingFlag) {
                break;
            }

            answer++;
        }

        System.out.println(answer);

    }
}
