class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1] && candies[i] >= candies[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && candies[i] >= candies[i - 1]) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        int answer = 0;
        for (int c : candies) {
            answer += (c + 1);
        }
        return answer;
    }
}
