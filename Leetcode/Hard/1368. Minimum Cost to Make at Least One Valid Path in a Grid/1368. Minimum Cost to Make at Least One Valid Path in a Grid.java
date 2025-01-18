class Solution {
    private int[] dx = {0, 1, -1, 0, 0};
    private int[] dy = {0, 0, 0, 1, -1};
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] isVisited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisited[i], -1);
        }
        Deque<int[]> q = new ArrayDeque<>();
        isVisited[0][0] = 0;
        q.add(new int[]{0, 0});

        int result = 0;
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();
            int x = now[0];
            int y = now[1];
            if (x == m - 1 && y == n - 1) {
                break;
            }
            for (int i = 1; i <= 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                    continue;
                }
                int v = 0;
                if (grid[y][x] != i) {
                    v = 1;
                }
                if (isVisited[yy][xx] == -1 || isVisited[yy][xx] > isVisited[y][x] + v) {
                    isVisited[yy][xx] = isVisited[y][x] + v;
                    if (grid[y][x] == i) {
                        q.addFirst(new int[]{xx, yy});
                    } else {
                        q.addLast(new int[]{xx, yy});
                    }
                }
            }
        }
        return isVisited[n - 1][m - 1];
    }
}
