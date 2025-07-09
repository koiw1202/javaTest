package codingTest;

import java.util.HashMap;
import java.util.Map;

public class SeesawPartner {

    public static void main(String[] args) {
        int[] weights = {10, 40, 20, 30};

        final int[] seats = {2,3,4};
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int weight : weights) {
            for(int seat: seats) {
                map.merge(weight * seat, 1, Integer::sum);
            }
        }

        for(int i=0;i<weights.length; i++) {
            boolean isExist = false;
            for(int j=i+1; j < weights.length; j++) {
                for(int seat: seats) {
                    Integer tempVal = map.get(weights[j] * seat);
                    if(tempVal != null && tempVal > 0) {
                        answer++;
                        isExist = true;
                        map.put(weights[j] * seat, tempVal - 1);
                        break;
                    }
                }
                if(isExist) break;
            }
        }

        System.out.println(answer);






    }

}
