class Solution {
    public long coloredCells(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result += 4 * (i - 1);
        }
        return result;
    }
}
