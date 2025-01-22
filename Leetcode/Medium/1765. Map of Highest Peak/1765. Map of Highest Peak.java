class Solution {
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {-1, 0, 1, 0};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] isVisited = new int[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisited[i], -1);
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    isVisited[i][j] = 0;
                    q.add(new int[]{j, i});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int c = isVisited[y][x];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n || isVisited[yy][xx] > -1) {
                    continue;
                }
                isVisited[yy][xx] = c + 1;
                q.add(new int[]{xx, yy});
            }
        }
        return isVisited;
    }
}
