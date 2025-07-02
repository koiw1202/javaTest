package codingTest;

import java.util.*;

public class FindingCollisionHazards {

    public static void main(String[] args) {

        int[][] points = {
                {2, 2}, {2, 3}, {2, 7}, {6, 6}, {5,2}
        };

        int[][] routes = {
            {2,3,4,5},{1,3,4,5}
        };

        Map<String, Integer> routeMap = new HashMap<>();
        int answer = 0;

        for (int[] route : routes) {

            int time = 0;
            answer = checkDup(points[route[0] - 1][0],points[route[0] - 1][1],time,routeMap,answer);
            time++;

            for(int i=0; i < route.length -1; i++) {

                int currentX = points[route[i] - 1][0];
                int currentY = points[route[i] - 1][1];
                int targetX = points[route[i+1] - 1][0];
                int targetY = points[route[i+1] - 1][1];

                while (currentX != targetX || currentY != targetY) {

                    if(currentX != targetX) {
                        currentX += (currentX > targetX) ? -1 : 1;
                    }

                    else {
                        currentY += (currentY > targetY) ? -1 : 1;
                    }

                    answer = checkDup(currentX,currentY,time,routeMap,answer);
                    time++;

                } //End of moving
            }
        } //End of routes

        System.out.println(answer);

    } // End of main

    public static int checkDup(int currentX, int currentY, int time, Map<String, Integer> routeMap, int answer) {
        Integer tempAnswer = routeMap.get(currentX + ":" + currentY + ":" + time);

        if (tempAnswer == null) {
            routeMap.put(currentX + ":" + currentY + ":" + time, 0);
        } else {
            if (tempAnswer == 0) {
                answer++;
                routeMap.put(currentX + ":" + currentY + ":" + time, 1);
            }
        }
        return answer;
    }
}























