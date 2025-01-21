class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] upper = new long[n];
        long[] lower = new long[n];
        for (int i = 1; i < n; i++) {
            upper[i] = upper[i - 1] + grid[0][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            lower[i] = lower[i + 1] + grid[1][i];
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, Math.max(upper[n - 1] - upper[i], lower[0] - lower[i]));
        }
        return result;
    }
}
