class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] col = new int[n];
        int[] row = new int[m];
        Arrays.fill(col, m);
        Arrays.fill(row, n);

        Map<Integer, int[]> pair = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pair.put(mat[i][j], new int[]{j, i});
            }
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] p = pair.get(num);
            int x = p[0];
            int y = p[1];
            if (--col[y] == 0) {
                result = i;
                break;
            }
            if (--row[x] == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
