package codingTest;

import java.util.*;

public class ChoosingTangerines {

    public static void main(String[] args) {

        int k = 2;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ;i < tangerine.length; i++) {
            Integer value = map.get(tangerine[i]);

            if(value == null ) {
                map.put(tangerine[i],1);
            } else {
                map.put(tangerine[i],value+1);
            }
        }
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer value : map.values()) {
            arr.add(value);
        }

        Collections.sort(arr,Collections.reverseOrder());

        int index=0;
        while(k > 0) {
            k -= arr.get(index++);
            answer++;
        }

        System.out.println(answer);

    }
}



























