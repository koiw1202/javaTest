package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Players {

    public static void main(String[] args) {

        // [0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0]	5	1

        int[] players = {0,0,1};
        int m = 1;
        int k = 24;

//        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
//        int m = 3;
//        int k = 5;

        // n * m명 이상 <= 값 <(n + 1) * m

        List<Integer> list = new ArrayList<>();
        int answer = 0;

        for(int i = 0 ; i < players.length;i++) {

            /* list 값 내부 1씩 증가 */
            for(int j = 0 ; j < list.size(); j++) {

                list.set(j, list.get(j) + 1);

                if(list.get(j) > k) {
                    list.remove(j);
                    j--;
                }
            }

            int needs = players[i] / m;

            /* 서버가 더 필요한지 체크 */
            if( ! (needs <= list.size())) {

                int needsCnt = needs - list.size();

                for(int j= 0; j < needsCnt ; j++) {
                    list.add(1);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}