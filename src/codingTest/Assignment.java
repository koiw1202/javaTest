package codingTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Stack;

public class Assignment {

    public static void main(String[] args) {

        String[][] plans = {{"a", "09:00", "30"}, {"b", "09:20", "10"}, {"c", "09:40", "10"}};

        Arrays.sort(plans, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });

        String[] answer = new String[plans.length];

        int index =0;
        Stack<String[]> plansList = new Stack<>();

        for(int i=0; i< plans.length - 1; i++) {

            String[] timeCurrent = plans[i][1].split(":");
            String[] timeNext = plans[i+1][1].split(":");

            final LocalDateTime localTimeCurrent = LocalDateTime.of(2025,01,01, Integer.parseInt(timeCurrent[0]), Integer.parseInt(timeCurrent[1]));
            LocalDateTime localTimeNext = LocalDateTime.of(2025,01,01,Integer.parseInt(timeNext[0]), Integer.parseInt(timeNext[1]));

            // 현재 시간을 더한 후에, 처리할 수 있다면 처리하고 만약에 처리가 불가능 하다면 List에 넣어둠.
            final LocalDateTime localTimeAdded = localTimeCurrent.plusMinutes(Integer.parseInt(plans[i][2]));

            // 가능한 시간 계산
            long timeGap = Math.abs(Duration.between(localTimeCurrent, localTimeNext).toMinutes() - Long.parseLong(plans[i][2]));

            // 정확하게 딱 제한시간이 일치 한다면
            if(localTimeAdded.equals(localTimeNext)) {
                answer[index++] = plans[i][0];
            }
            // 처리하고 시간이 남는다면
            else if(localTimeAdded.isBefore(localTimeNext)) {
                answer[index++] = plans[i][0];

                // 남은 시간 만큼 list에 항목들 처리
                while( ! plansList.isEmpty()) {
                    String[] remainPlan = plansList.peek();
                    long remainTime = Long.parseLong(remainPlan[1]);
                    // 남는 시간 여유분이 크다면
                    if( timeGap >= remainTime) {
                        answer[index++] = remainPlan[0];
                        timeGap -= Long.parseLong(remainPlan[1]);
                        plansList.pop();
                    } else {
                        remainTime -= timeGap;
                        plansList.set(plansList.size()-1, new String[]{remainPlan[0], remainTime + ""});
                        break;
                    }
                }
            } else {
                plansList.add(new String[]{plans[i][0], timeGap + ""});
            }
        } // End of for

        answer[index++] = plans[plans.length-1][0];

        while( ! plansList.isEmpty()) {
            String[] arr = plansList.pop();
            answer[index++] = arr[0];
        }

        for(String str : answer) {
            System.out.println(str);
        }
    }
}
