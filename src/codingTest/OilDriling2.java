package codingTest;

import java.util.*;

public class OilDriling2 {

    static class Oil {
        int x;
        int y;

        public Oil(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class OilValue {
        int value;

        public OilValue(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        int[][] land = {
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0}
        };

        int[] drX = {1,0,-1,0};
        int[] drY = {0,1,0,-1};
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] sum = new int[land[0].length];

        /* 전체 land의 점수 합산 */
        for(int j=0; j< land[0].length; j++) {



            for(int i=0; i < land.length; i++) {

                if(land[i][j] == 0 || visited[i][j]) continue;

                int size = 0;
                int maxY = j;

                ArrayDeque<Oil> que = new ArrayDeque<>();
                que.add(new Oil(i,j));
                visited[i][j] = true;

                // 근처에 이동이 가능한 항목이 있다면
                while( ! que.isEmpty()) {
                    Oil oil = que.poll();
                    size++;

                    for(int k=0;k<drX.length;k++){
                        int nextX = oil.x + drX[k];
                        int nextY = oil.y + drY[k];

                        if(nextX>=0 && nextY>=0 && nextX < land.length && nextY < land[0].length && ! visited[nextX][nextY] && land[nextX][nextY] == 1) {
                            visited[nextX][nextY] = true;
                            que.add(new Oil(nextX,nextY));

                            if(nextY > maxY) maxY = nextY;
                        }
                    }
                }

                if( size !=0 ) {
                    for(int k = j; k <= maxY; k++) {
                        sum[k] += size;
                    }
                }
            } // End of second for
        } //End of first for

        Arrays.sort(sum);
        System.out.println(sum[sum.length-1]);


    }
}
