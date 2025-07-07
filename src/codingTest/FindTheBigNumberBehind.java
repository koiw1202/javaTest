package codingTest;

import java.util.*;

public class FindTheBigNumberBehind {

    public static void main(String[] args) {

        int[] numbers = {9, 1, 5, 3, 6, 2};

        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=numbers.length-1; i>=0;i--) {

            while( ! stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.add(numbers[i]);
        }

        for(int i : answer) {
            System.out.println(i);
        }

    }
}












