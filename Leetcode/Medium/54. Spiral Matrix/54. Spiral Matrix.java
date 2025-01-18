class Solution {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] isVisited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();
        int x = 0;
        int y = 0;
        int i = 0;
        int d = 0;
        while (true) {
            result.add(matrix[y][x]);
            isVisited[y][x] = true;
            if (++i >= n * m) {
                break;
            }
            int yy = y + dy[d];
            int xx = x + dx[d];
            if (0 > yy || yy >= n || 0 > xx || xx >= m || isVisited[yy][xx]) {
                d = (d + 1) % 4;
                yy = y + dy[d];
                xx = x + dx[d];
            }
            y = yy;
            x = xx;
        }
        return result;
    }
}
