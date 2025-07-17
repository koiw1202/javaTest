package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DividingNumberCards {

    public static void main(String[] args) {

        int[] arrayA = {
                14, 35, 119
        };

        int[] arrayB = {
                18, 30, 102
        };

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int maxVal = 0;
        List<Integer> listA = new ArrayList<>();

        for(int i = 2 ; i <= arrayA[arrayA.length-1]; i++) {

            boolean flagDividend = true;

            for(int j = 0 ; j < arrayA.length; j++) {
                if(arrayA[j] % i != 0) {
                    flagDividend = false;
                    break;
                }
            }
            if(flagDividend) {
                listA.add(i);
            }
        }

        List<Integer> listB = new ArrayList<>();

        for(int i = 2 ; i <= arrayB[arrayB.length-1]; i++) {

            boolean flagDividend = true;

            for(int j = 0 ; j < arrayB.length; j++) {
                if(arrayB[j] % i != 0) {
                    flagDividend = false;
                    break;
                }
            }
            if(flagDividend) {
                listB.add(i);
            }
        }

        int answer = 0;
        for(int i = 0; i < listA.size() ; i++) {
            int target = listA.get(i);
            boolean flagDividend = true;
            for(int j = 0; j < arrayB.length ; j++) {
                if(arrayB[j] % target == 0) {
                    flagDividend = false;
                    break;
                }
            }

            if(flagDividend) {
                answer = Math.max(answer, target);
            }
        }

        for(int i = 0; i < listB.size() ; i++) {
            int target = listB.get(i);
            boolean flagDividend = true;
            for(int j = 0; j < arrayA.length ; j++) {
                if(arrayA[j] % target == 0) {
                    flagDividend = false;
                    break;
                }
            }

            if(flagDividend) {
                answer = Math.max(answer, target);
            }
        }
        System.out.println(answer);
    }

}
