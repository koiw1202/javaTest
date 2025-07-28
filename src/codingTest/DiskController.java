package codingTest;

import java.util.*;

public class DiskController {

    public static void main(String[] args) {

        int[][] jobs = {
                {0, 3}, {3, 5}, {1, 9}
        };

        Queue<int[]> que = new LinkedList<>();
        Map<Integer, Integer> jobMap =new HashMap<>();
        for(int[] job : jobs) {
            jobMap.put(job[0], job[1]);
        }

        boolean[] isWorking = new boolean[2001];
        int answer = 0;

        for(int time = 0 ; time < 2001; time++) {

            Integer takeTime = jobMap.get(time);
            if(takeTime == null && que.isEmpty()) continue;
            if(isWorking[time] && takeTime == null) continue;


            if(isWorking[time] && takeTime != null) {
                que.add(new int[]{time, takeTime});
                continue;
            }

            int requestTime = time;
            if(takeTime == null) {
                int[] tempQue = que.poll();
                takeTime = tempQue[1];
                requestTime = tempQue[0];
            }

            for(int i=time; i < time + takeTime; i++) {
                isWorking[i] = true;
            }

            answer += (time + takeTime - requestTime);
            System.out.println(time + takeTime - requestTime);
        }

        System.out.println(answer / jobs.length);

    }
}
