package codingTest;

import java.util.LinkedList;
import java.util.Queue;

public class MazeEscape {

    public static void main(String[] args) {

        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};

        char[][] mapArr = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        int startX = 0;
        int startY = 0;

        for(int i=0; i<mapArr.length;i++) {
            mapArr[i] = maps[i].toCharArray();
            for(int j=0; j<mapArr[i].length;j++) {
                if(mapArr[i][j] == 'S') {
                    startX = i;
                    startY = j;
                    mapArr[i][j] = 'O';
                }
            }
        }

        boolean isLeverReady = false;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startX, startY, 0});
        int[] drX = {1,0,-1,0};
        int[] drY = {0,1,0,-1};

        int answer = -1 ;

        while( ! que.isEmpty()) {
            int[] tempQueue = que.poll();

            int currentX = tempQueue[0];
            int currentY = tempQueue[1];
            int value = tempQueue[2];
            boolean isReachEndPoint = false;

            for(int i=0;i<drX.length;i++) {
                int nextX = currentX + drX[i];
                int nextY = currentY + drY[i];

                /* 이동 가능하다면 */
                if(nextX >=0 && nextY >=0 && nextX < mapArr.length && nextY < mapArr[0].length && ! visited[nextX][nextY] &&
                        (mapArr[nextX][nextY] == 'O' || mapArr[nextX][nextY] == 'E' || mapArr[nextX][nextY] == 'L' )) {

                    que.add(new int[]{nextX, nextY, value + 1});
                    visited[nextX][nextY] = true;

                    /* 레버를 찾은 경우 */
                    if(mapArr[nextX][nextY] == 'L') {
                        isLeverReady = true;
                        mapArr[nextX][nextY] = 'O';
                        que.clear();
                        que.add(new int[]{nextX, nextY, value + 1});
                        visited = new boolean[maps.length][maps[0].length()];
                        break;
                    }

                    /* 레버를 찾은 후, 도착지점을 찾은 경우 */
                    else if(isLeverReady && mapArr[nextX][nextY] == 'E') {
                        isReachEndPoint = true;
                        break;
                    }
                }
            }

            if(isReachEndPoint) {
                answer = value + 1;
                break;
            }
        }

        System.out.println(answer);


    }
}























