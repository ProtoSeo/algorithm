class Solution {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }
                Deque<int[]> q = new ArrayDeque<>();
                q.add(new int[]{j, i});
                isVisited[i][j] = true;
                int sum = grid[i][j];
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    int x = p[0];
                    int y = p[1];
                    for (int k = 0; k < 4; k++) {
                        int xx = x + dx[k];
                        int yy = y + dy[k];
                        if (xx < 0 || yy < 0 || yy >= n || xx >= m || isVisited[yy][xx] || grid[yy][xx] == 0) {
                            continue;
                        }
                        q.add(new int[]{xx, yy});
                        isVisited[yy][xx] = true;
                        sum += grid[yy][xx];
                    }
                }
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
