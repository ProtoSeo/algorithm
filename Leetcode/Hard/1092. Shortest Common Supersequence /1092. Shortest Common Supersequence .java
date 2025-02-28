class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int r = n, c = m;
        while (r > 0 && c > 0) {
            if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
                sb.append(str1.charAt(r - 1));
                --r;
                --c;
            } else if (dp[r - 1][c] < dp[r][c - 1]) {
                sb.append(str1.charAt(--r));
            } else {
                sb.append(str2.charAt(--c));
            }
        }
        while (r > 0) {
            sb.append(str1.charAt(--r));
        }
        while (c > 0) {
            sb.append(str2.charAt(--c));
        }
        return sb.reverse().toString();
    }
}
