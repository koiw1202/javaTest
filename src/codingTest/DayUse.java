package codingTest;

import java.util.Arrays;
import java.util.Comparator;

public class DayUse {

    public static void main(String[] args) {

        String[][] book_time = {
                {"23:58", "23:59"},
                {"23:58", "23:59"},
        };
        int[] rooms = new int[24 * 60 + 10]; // 1440분 + 정리 시간 고려

        Arrays.sort(book_time, (String[] o1, String[] o2) -> {
            return toMinutes(o1[0]) - toMinutes(o2[0]);
        });

        int answer = 0;
        for (int i = 0; i < book_time.length; i++) {
            int start = toMinutes(book_time[i][0]);
            int end = toMinutes(book_time[i][1]) + 10; // 퇴실 후 10분 청소 시간

            for (int j = start; j < end; j++) {
                rooms[j]++;
                answer = Math.max(answer, rooms[j]);
            }
        }

        System.out.println(answer);

    }
    static private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
