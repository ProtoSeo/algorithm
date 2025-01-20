class Solution {
    private int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    private int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] next = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveCount = 0;
                for (int k = 0; k < 8; k++) {
                    int xx = j + dx[k];
                    int yy = i + dy[k];
                    if (yy < 0 || xx < 0 || xx >= m || yy >= n) {
                        continue;
                    }
                    if (board[yy][xx] == 1) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3) ) {
                    next[i][j] = 0;
                } else if (board[i][j] == 1) {
                    next[i][j] = 1;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    next[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = next[i][j];
            }
        }
    }
}
