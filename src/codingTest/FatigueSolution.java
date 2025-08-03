package codingTest;

public class FatigueSolution {

    static int answer = 0;


    public static int dfs(int currentFatigue, boolean[] visited, int[][] dungeons, int index) {
        answer = Math.max(index, answer);

        for(int i=0; i < dungeons.length; i++) {
            if( ! visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(currentFatigue - dungeons[i][1], visited, dungeons, index + 1);
                visited[i] = false;
            }
        }
        return answer;
    }

    // 테스트용 main 함수
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
                {80, 20}, // 최소 80 필요, 20 소모
                {50, 40}, // 최소 50 필요, 40 소모
                {30, 10}  // 최소 30 필요, 10 소모
        };

        int result = dfs(k,new boolean[dungeons.length], dungeons, 0);

        System.out.println("최대 던전 탐험 수: " + result); // 예상 출력: 3
    }
}