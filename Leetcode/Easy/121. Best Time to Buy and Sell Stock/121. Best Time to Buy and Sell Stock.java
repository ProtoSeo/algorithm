import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            int nowPrice = prices[i];
            answer = Math.max(answer, nowPrice - minPrice);
            if (nowPrice < minPrice) {
                minPrice = nowPrice;
            }
        }
        return answer;
    }
}
