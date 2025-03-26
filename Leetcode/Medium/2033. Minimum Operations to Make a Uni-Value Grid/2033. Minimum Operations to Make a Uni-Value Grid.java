class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] values = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                values[i * m + j] = grid[i][j];
            }
        }
        Arrays.sort(values);
        int median = values[(n * m) / 2];
        int result = 0;
        for (int value : values) {
            if (value % x != median % x) {
                return -1;
            }
            result += Math.abs(median - value) / x;
        }
        return result;
    }
}
