package codingTest;

import java.util.ArrayList;
import java.util.List;

public class ForkliftAndCrane {

    static final int[] drX = {1, 0, -1, 0};
    static final int[] drY = {0, 1, 0, -1};

    public static void main(String[] args) {
        String[] storage = {
                "ZZZZO",
                "ZAAOZ",
                "ZAAAZ",
                "ZAAAZ",
                "ZZZZZ"
        };

        String[] requests = {"O", "OO"};
        char[][] storageArr = new char[storage.length][storage[0].length()];

        // 0: 기본값
        // 1: 이동가능
        // 2: 크레인으로 삭제는 됐지만 주변이 막혀있음.
        int[][] visited = new int[storage.length][storage[0].length()];

        for(int i=0; i < storage.length; i++) {
            storageArr[i] = storage[i].toCharArray();
        }

        int answer = storageArr.length * storageArr[0].length;

        for (String request : requests) {
            char target = request.charAt(0);
            List<int[]> moveList = new ArrayList<>();

            // 크레인
            if (request.length() == 2) {

                for (int j = 0; j < storageArr.length; j++) {
                    for (int k = 0; k < storageArr[0].length; k++) {
                        if (storageArr[j][k] == target && visited[j][k] == 0) {
                            moveList.add(new int[]{j, k});
                            storageArr[j][k] = ' ';
                            answer--;
                        }
                    } // End of second for
                } // End of for

                for (int[] xy : moveList) {
                    int x = xy[0];
                    int y = xy[1];

                    // 예외 케이스 외곽쪽에 있는 항목들은 무조건 이동 가능
                    if (x == 0 || y == 0 || x == storageArr.length - 1 || y == storageArr[0].length - 1) {
                        visited[x][y] = 1;
                        changeVisited(x, y, visited);
                        continue;
                    }

                    // 우선 이동 불가능하다고 판단하고 아래 로직을 통해 이동 가능한 경록가 있다면 수정될 예정
                    visited[x][y] = 2;

                    // 주변에 이동이 가능한 경로가 있다면
                    for (int l = 0; l < drX.length; l++) {
                        int nextX = x + drX[l];
                        int nextY = y + drY[l];

                        if (nextX >= 0 && nextY >= 0 && nextX < visited.length && nextY < visited[0].length) {
                            //이동 가능하다면 현재 위치를 1로 변경
                            if (visited[nextX][nextY] == 1) {
                                visited[x][y] = 1;
                                changeVisited(x, y, visited);
                                break;
                            }
                        }
                    }
                }
            } // End of 크레인

            // 지게차
            else {
                for (int j = 0; j < storageArr.length; j++) {
                    for (int k = 0; k < storageArr[0].length; k++) {
                        if (storageArr[j][k] == target) {

                            // 예외 케이스 외곽쪽에 있는 항목들은 무조건 이동 가능
                            if (j == 0 || k == 0 || j == storageArr.length - 1 || k == storageArr[0].length - 1) {
                                moveList.add(new int[]{j, k});
                                continue;
                            }

                            // 주변에 이동이 가능한 경로가 있다면
                            for (int l = 0; l < drX.length; l++) {
                                int nextX = j + drX[l];
                                int nextY = k + drY[l];

                                if (nextX >= 0 && nextY >= 0 && nextX < visited.length && nextY < visited[0].length) {
                                    //이동 가능하다면 현재 위치를 배열에 담음
                                    if (visited[nextX][nextY] == 1) {
                                        moveList.add(new int[]{j, k});
                                        break;
                                    }
                                }
                            }
                        } // End of target이 같은 경우
                    } // End of second for
                } //  End of first for

                for (int[] xy : moveList) {
                    int x = xy[0];
                    int y = xy[1];

                    // 예외 케이스 외곽쪽에 있는 항목들은 무조건 이동 가능
                    if (x == 0 || y == 0 || x == storageArr.length - 1 || y == storageArr[0].length - 1) {
                        visited[x][y] = 1;
                        storageArr[x][y] = ' ';
                        answer--;
                        changeVisited(x, y, visited);
                        continue;
                    }

                    // 주변에 이동이 가능한 경로가 있다면
                    for (int l = 0; l < drX.length; l++) {
                        int nextX = x + drX[l];
                        int nextY = y + drY[l];

                        if (nextX >= 0 && nextY >= 0 && nextX < visited.length && nextY < visited[0].length) {
                            //이동 가능하다면 현재 위치를 1로 변경
                            if (visited[nextX][nextY] == 1) {
                                visited[x][y] = 1;
                                storageArr[x][y] = ' ';
                                answer--;
                                changeVisited(x, y, visited);
                                break;
                            }
                        }
                    }
                }
            } // End of 지게차
        } // End of request for

        System.out.println(answer);

    }

    // 상하좌우에 2인 값이 없는지 체크
    public static void changeVisited(int x, int y, int[][] visited) {

        for(int l=0; l<drX.length;l++){
            int nextX = x + drX[l];
            int nextY = y + drY[l];

            if(nextX >=0 && nextY >=0 && nextX < visited.length && nextY < visited[0].length) {
                if(visited[nextX][nextY] == 2) {
                    visited[nextX][nextY] = 1;
                    changeVisited(nextX, nextY, visited);
                }
            }
        }
    } // End of changeVisited
}