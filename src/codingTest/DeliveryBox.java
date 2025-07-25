package codingTest;

import java.util.Stack;

public class DeliveryBox {

    public static void main(String[] args) {

        int[] order = {5,4,3,2,1};
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int answer = 0;

        for(int i=1; i<= order.length;i++) {

            /** order 와 같은 상자라면 */
            if(order[index] == i) {
                answer++;
                index++;
            } else {
                stack.push(i);
            }

            while( ! stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                answer++;
                index++;
            }
        }



        System.out.println(answer);

    }
}
