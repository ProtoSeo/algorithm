class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> vertical = new HashSet<>();
        Set<Integer> horizontal = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    horizontal.add(i);
                    vertical.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (horizontal.contains(i)) {
                    matrix[i][j] = 0;
                }
                if (vertical.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
