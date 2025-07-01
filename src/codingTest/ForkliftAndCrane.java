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
        int rows = storage.length;
        int cols = storage[0].length();
        char[][] storageArr = new char[rows][cols];
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            storageArr[i] = storage[i].toCharArray();
        }

        int answer = rows * cols;

        for (String request : requests) {
            char target = request.charAt(0);
            List<int[]> toProcess = new ArrayList<>();

            if (request.length() == 2) {
                // 크레인
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (storageArr[i][j] == target && visited[i][j] == 0) {
                            toProcess.add(new int[]{i, j});
                            storageArr[i][j] = ' ';
                            answer--;
                        }
                    }
                }

                for (int[] pos : toProcess) {
                    int x = pos[0], y = pos[1];

                    if (isEdge(x, y, rows, cols)) {
                        visited[x][y] = 1;
                        spreadMovable(x, y, visited);
                    } else if (hasMovableNeighbor(x, y, visited)) {
                        visited[x][y] = 1;
                        spreadMovable(x, y, visited);
                    } else {
                        visited[x][y] = 2;
                    }
                }

            } else {
                // 지게차
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (storageArr[i][j] == target) {
                            if (isEdge(i, j, rows, cols) || hasMovableNeighbor(i, j, visited)) {
                                toProcess.add(new int[]{i, j});
                            }
                        }
                    }
                }

                for (int[] pos : toProcess) {
                    int x = pos[0], y = pos[1];

                    if (isEdge(x, y, rows, cols) || hasMovableNeighbor(x, y, visited)) {
                        visited[x][y] = 1;
                        storageArr[x][y] = ' ';
                        answer--;
                        spreadMovable(x, y, visited);
                    }
                }
            }
        }

        System.out.println(answer);

    }

    static boolean isEdge(int x, int y, int rows, int cols) {
        return x == 0 || y == 0 || x == rows - 1 || y == cols - 1;
    }

    static boolean hasMovableNeighbor(int x, int y, int[][] visited) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + drX[dir];
            int ny = y + drY[dir];

            if (nx >= 0 && ny >= 0 && nx < visited.length && ny < visited[0].length) {
                if (visited[nx][ny] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static void spreadMovable(int x, int y, int[][] visited) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + drX[dir];
            int ny = y + drY[dir];

            if (nx >= 0 && ny >= 0 && nx < visited.length && ny < visited[0].length) {
                if (visited[nx][ny] == 2) {
                    visited[nx][ny] = 1;
                    spreadMovable(nx, ny, visited);
                }
            }
        }
    }
}