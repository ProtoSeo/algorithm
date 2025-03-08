class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int w = 0;
        int result = k;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                w++;
            }
        }
        for (int i = k; i <= n; i++) {
            result = Math.min(result, w);
            if (i == n) {
                break;
            }
            if (blocks.charAt(i - k) == 'W') {
                w--;
            }
            if (blocks.charAt(i) == 'W') {
                w++;
            }
        }
        return result;
    }
}
