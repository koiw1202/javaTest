package codingTest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-17        koiw1       최초 생성
 */
import java.util.*;

public class GhostAvoidance {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 격자 세로 크기
        m = sc.nextInt(); // 격자 가로 크기
        grid = new int[n][m];
        visited = new boolean[n][m];

        // 격자 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // BFS 시작
        if (bfs(0, 0)) {
            System.out.println("도달 가능");
        } else {
            System.out.println("도달 불가능");
        }
    }

    static boolean bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 목표 지점에 도달했는지 확인
            if (x == n - 1 && y == m - 1) {
                return true;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 격자 범위 체크 및 방문 여부 체크
                if (isValid(newX, newY) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return false; // 목표 지점에 도달하지 못함
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != 1; // 1은 장애물
    }
}
