package codingTest;

import java.util.ArrayList;
import java.util.List;

public class ForkliftAndCrane {

    public static void main(String[] args) {

        String[] storage = {
                "AZWQY", "CAABX", "BBDDA", "ACACA"
        };

        String[] requests = {"A", "BB", "A"};
        int[] drX = {1,0,-1,0};
        int[] drY = {0,1,0,-1};

        char[][] storageChars = new char[storage.length][storage[0].length()];

        int index = 0;

        for(String str : storage) {
            storageChars[index++] = str.toCharArray();
        }

        boolean[][] storageCanMove = new boolean[storage.length][storage[0].length()];

        for(int i=0;i<storageCanMove[0].length;i++) {
            storageCanMove[0][i] = true;
        }

        for(int i=0;i<storageCanMove[0].length;i++) {
            storageCanMove[storageCanMove.length-1][i] = true;
        }

        for(int i=0;i<storageCanMove.length; i++) {
            storageCanMove[i][0] = true;
        }

        for(int i=0;i<storageCanMove.length; i++) {
            storageCanMove[i][storageCanMove[0].length-1] = true;
        }

        int answer = storageCanMove.length * storageCanMove[0].length;

        for(int i = 0; i < requests.length; i++) {

            List<int[]> visitedList = new ArrayList<>();

            /* 1 글자인 경우 */
            if(requests[i].length() == 1) {
                for(int j=0; j < storageChars.length; j++) {
                    for(int k = 0; k < storageChars[j].length; k++) {

                        if(requests[i].equals(storageChars[j][k] + "") && storageCanMove[j][k]) {
                            storageChars[j][k] = '~';
                            answer--;

                            for(int l=0;l<drX.length ;l++) {
                                int nextX = j + drX[l];
                                int nextY = k + drY[l];

                                if(nextX >= 0 && nextY >= 0 && nextX <= storageChars.length - 1 && nextY <= storageChars[0].length - 1 && ! storageCanMove[nextX][nextY]) {
                                    //상하좌우 모두 움직일 수 있게 표시
                                    visitedList.add(new int[]{nextX,nextY});
                                }
                            } //End of 방향이동
                        }
                    }
                }
            }

            /* 2 글자인 경우 */
            else if(requests[i].length() == 2) {

                String target = requests[i].substring(0,1);

                for(int j=0; j < storageChars.length; j++) {
                    for(int k = 0; k < storageChars[j].length; k++) {

                        if(target.equals(storageChars[j][k] + "") && storageCanMove[j][k]) {

                            storageChars[j][k] = '~';
                            answer--;

                            for(int l=0;l<drX.length ;l++) {
                                int nextX = j + drX[l];
                                int nextY = k + drY[l];

                                if(nextX >= 0 && nextY >= 0 && nextX <= storageChars.length - 1 && nextY <= storageChars[0].length - 1 &&  ! storageCanMove[nextX][nextY]) {
                                    //상하좌우 모두 움직일 수 있게 표시
                                    visitedList.add(new int[]{nextX,nextY});
                                }
                            } //End of 방향이동
                        }
                    }
                }
            }

            for(int[] arr : visitedList) {
                storageCanMove[arr[0]][arr[1]] = true;
            }
//            break;
        }

        for(int i =0 ; i <storageChars.length; i++) {
            for(int j = 0; j < storageChars[0].length; j++) {
                System.out.print(storageCanMove[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(answer);
    }



}
