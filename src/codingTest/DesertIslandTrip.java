package codingTest;

import java.util.*;

public class DesertIslandTrip {

    public static void main(String[] args) {

        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        // 1, 1, 27

        char[][] mapsArr = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[mapsArr.length][mapsArr[0].length];
        final int[] drX = {1,0,-1,0};
        final int[] drY = {0,1,0,-1};


        for(int i=0;i<mapsArr.length;i++) {
            mapsArr[i] = maps[i].toCharArray();
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<mapsArr.length;i++) {
            for(int j=0;j<mapsArr[0].length;j++) {

                // 더할 수 있는 숫자라면
                if (mapsArr[i][j] != 'X' && ! visited[i][j]) {
                    int tempAnswer = Integer.parseInt(mapsArr[i][j] + "");
                    visited[i][j] = true;
                    Queue<int[]> que = new LinkedList<>();

                    que.add(new int[]{i,j});

                    while( ! que.isEmpty()) {
                        int[] tempValue = que.poll();
                        int x = tempValue[0];
                        int y = tempValue[1];

                        for(int k=0;k<drX.length;k++){
                            int nextX = x + drX[k];
                            int nextY = y + drY[k];

                            // 이동할 수 있고 방문한 적이 없다면
                            if(nextX >=0 && nextY >=0 && nextX < mapsArr.length && nextY < mapsArr[0].length && mapsArr[nextX][nextY] != 'X' && ! visited[nextX][nextY]) {
                                visited[nextX][nextY] = true;
                                tempAnswer += Integer.parseInt(mapsArr[nextX][nextY] + "");
                                que.add(new int[]{nextX,nextY});
                            }
                        }
                    } // End of while
                    answer.add(tempAnswer);
                } // End of 이동할 수 있다면
            }
        }

        Collections.sort(answer);
        answer.toArray(new Integer[0]);

        for(Integer i : answer) {
            System.out.println(i);
        }
    }
}