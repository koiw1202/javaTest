package codingTest;

import java.util.Iterator;
import java.util.Stack;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-07-23        koiw1       최초 생성
 */
public class StockPrice {

    class Price {
        int index;
        int value;

        public Price(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Price> stack = new Stack<>();

        for(int i=0; i < prices.length-1; i++) {
            stack.push(new Price(i, prices[i]));

            if(stack.peek().value <= prices[i+1]) {
                continue;
            } else {
                Iterator<Price> iterator = stack.iterator();
                while(iterator.hasNext()) {
                    Price price = iterator.next();

                    if(price.value > prices[i+1]) {

                        answer[price.index] = i - price.index + 1;
                        iterator.remove();
                    }
                }
            }
        }

        Iterator<Price> iterator = stack.iterator();

        while(iterator.hasNext()) {
            Price price = iterator.next();
            answer[price.index] = prices.length - price.index -1;
        }

        answer[prices.length-1] = 0;

        return answer;
    }


}
