package codingTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ForkliftAndCrane {

    static List<int[]> creaneDeleteList = new LinkedList<>();

    public static void main(String[] args) {

        String[] storage = {
                "AAA","BAB","AAA"
        };

        String[] requests = {"A", "AA"};

        int[] drX = {1,0,-1,0};
        int[] drY = {0,1, 0,-1};

        int answer = storage.length * storage[0].length();

        char[][] storageChar = new char[storage.length][storage[0].length()];

        for(int i=0;i< storage.length;i++) {
            storageChar[i] = storage[i].toCharArray();
        }

        for(int i=0; i <requests.length;i++) {
            String targetStr = requests[i];
            List<int[]> deleteList = new ArrayList<>();

            for(int j=0; j < storageChar.length; j++) {
                for(int k=0; k < storageChar[j].length; k++) {

                    /* 크레인으로 가져가는 경우 */
                    if(requests[i].length() == 2) {
                        targetStr = requests[i].substring(0,1);
                        if(targetStr.equals(storageChar[j][k] + "")) {
                            storageChar[j][k] = '0';

                            for(int l=0; l < drX.length; l++) {
                                int nextX = j + drX[l];
                                int nextY = k + drY[l];

                                if(j == 0 || k == 0 || j == storageChar.length-1 || k == storageChar[j].length-1) {
                                    storageChar[j][k] = '1';
                                    break;
                                }

                                if(nextX <= storageChar.length - 1 && nextY <= storageChar[j].length - 1) {

                                    if(storageChar[nextX][nextY] == '1') {
                                        storageChar[j][k] = '1';
                                        break;
                                    }
                                }
                            }

                            if(storageChar[j][k] == '0') {
                                creaneDeleteList.add(new int[]{j,k});
                            }
                            answer--;
                        }
                    } else {
                        if(targetStr.equals(storageChar[j][k] + "") && checkEnableDeleteOrNot(storageChar, j, k )) {
                            deleteList.add(new int[]{j,k});
                            answer--;
                        }
                    }
                } // End of third for
            } // End of second for

            /* 삭제 리스트에 있는 항목들 삭제 */
            for(int[] tempDeleteTarget : deleteList) {
                int x = tempDeleteTarget[0];
                int y = tempDeleteTarget[1];
                storageChar[x][y] = '1';
            }


            /* map 초기화(0을 1로 초기화 작업 수행) */
            changingStorageCharForCarrier(storageChar);
        } // End of First for

        System.out.println(answer);

    } // End of main

    public static void changingStorageCharForCarrier(char[][] storageChar) {
        int[] drX = {1,0,-1,0};
        int[] drY = {0,1,0,-1};

        Iterator<int[]> iterator = creaneDeleteList.iterator();
        while(iterator.hasNext()) {
            int[] index = iterator.next();

            for(int i =0 ; i < drX.length; i++ ) {

                int nextX = index[0] + drX[i];
                int nextY = index[1] + drY[i];

                if(nextX >= 0 && nextY >= 0 && nextX <= storageChar.length-1 && nextY <= storageChar[0].length-1) {

                    if(storageChar[nextX][nextY] == '1') {
                        storageChar[index[0]][index[1]] = '1';
                        iterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public static boolean checkEnableDeleteOrNot(char[][] storageChar, int x, int y) {
        int[] drX = {1,0,-1,0};
        int[] drY = {0,1,0,-1};

        for(int i=0;i<drX.length; i++) {
            int nextX = x+drX[i];
            int nextY = y+drY[i];

            if(x == 0 || y == 0 || x == storageChar.length-1 || y == storageChar[0].length-1) {
                return true;
            }

            if(nextX >= 0 && nextY >= 0 && nextX <= storageChar.length-1 && nextY <= storageChar[0].length-1) {
                if(storageChar[nextX][nextY] == '1') {
                    return true;
                }
            }
        }
        return false;
    }

}