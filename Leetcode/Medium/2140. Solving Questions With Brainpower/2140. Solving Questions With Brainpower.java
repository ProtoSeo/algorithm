class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            int point = questions[i][0];
            int brainPower = questions[i][1];
            long result = (brainPower + i + 1 < n) ? point + dp[i + brainPower + 1] : point;
            dp[i] = Math.max(dp[i + 1], result);
        }
        return dp[0];
    }
}
