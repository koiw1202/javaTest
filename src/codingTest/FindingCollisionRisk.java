package codingTest;

import java.util.*;

public class FindingCollisionRisk {

    static class Data {
        int time;
        int x;
        int y;
        Map<String, Integer> isVisited;

        public Data(int time, int x, int y, Map<String, Integer> isVisited) {
            this.time = time;
            this.x = x;
            this.y = y;
            this.isVisited = isVisited;
        }
    }

    public static void main(String[] args) {

        int[] drX = {1,-1,0,0};
        int[] drY = {0,0,1,-1};
        int answer = 0;

        int[][] points = {
//            {3, 2}, {6, 4}, {4, 7}, {1, 4}
//            {3,2}, {6,4}, {4,7}, {1,4}
            {2,2},{2,3},{2,7},{6,6},{5,2}
        };

        int[][] routes = {
//                {4,2}, {1,3}, {2, 4}
//            {4,2}, {1,3},{4,2},{4,3}
            {2,3,4,5},{1,3,4,5}
        };

        for(int[] route : routes) {
            for (int i = 0; i < route.length; i++) {
                route[i] -= 1;
            }
        }

        for(int[] point : points) {
            point[0] -= 1;
            point[1] -= 1;
        }

        Map<String, Integer> allMap = new HashMap<>();

        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j += 2) {

                int startX = points[routes[i][j]][0];
                int startY = points[routes[i][j]][1];

                int endX = points[routes[i][j+1]][0];
                int endY = points[routes[i][j+1]][1];

                Queue<Data> que = new LinkedList<>();

                Map<String, Integer> isVisitedTemp = new HashMap<>();
                isVisitedTemp.put("(" + startX + "," + startY + ")", 0);

                Data data = new Data(0, startX, startY, isVisitedTemp);
                que.add(data);

                while( ! que.isEmpty()) {
                    Data tempData = que.poll();
                    Map<String, Integer> isVisited = new HashMap<>();

                    if(tempData.x == endX && tempData.y == endY) {
                        break;
                    }

                    for(int k=0; k<drX.length;k++){
                        int nextX = tempData.x + drX[k];
                        int nextY = tempData.y + drY[k];
                        int nextTime = tempData.time + 1;

                        Map<String, Integer> isVisitedForNextVisited = new HashMap<>();

                        for(String set: tempData.isVisited.keySet()) {
                            isVisitedForNextVisited.put(set, tempData.isVisited.get(set));
                        }

                        isVisitedForNextVisited.put("(" + nextX + "," + nextY, nextTime);

                        // 이동이 가능한 경우
                        if(nextX >= 0 && nextX < 100 && nextY >= 0 && nextY< 100 ) {
                            Data tempDataForQueue = new Data(nextTime, nextX, nextY, isVisited);
                            que.add(tempDataForQueue);
                        }
                    }


                } //End of while 이동
            } //End of second for
        } //End of first for

//        System.out.println(answer);


    }
}






















