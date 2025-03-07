class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j] - 1]++;
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < n * n; i++) {
            if (count[i] == 0) {
                result[1] = i + 1;
            } else if (count[i] == 2) {
                result[0] = i + 1;
            }
        }
        return result;
    }
}
