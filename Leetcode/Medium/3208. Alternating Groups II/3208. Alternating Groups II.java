class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] total = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            total[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            total[n + i] = colors[i];
        }

        int result = 0;
        int l = 0, r = 1;
        while (r < n + k -1) {
            if (total[r] == total[r - 1]) {
                l = r;
                r++;
                continue;
            }
            r++;
            if (r - l < k) {
                continue;
            }
            result++;
            l++;
        }

        return result;
    }
}
