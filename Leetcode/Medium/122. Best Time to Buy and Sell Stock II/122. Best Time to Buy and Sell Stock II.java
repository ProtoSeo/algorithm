class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] diff = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            if (diff[i] > 0) {
                result += diff[i];
            }
        }
        return result;
    }
}
