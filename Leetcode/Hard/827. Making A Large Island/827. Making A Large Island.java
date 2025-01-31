class Solution {
    private int[] counts;
    private int[][] isVisited;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {-1, 0, 1, 0};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int result = 0;
        counts = new int[(n + 1) * (n + 1)];
        isVisited = new int[n][n];

        for (int i = 0, idx = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || isVisited[i][j] > 0) {
                    continue;
                }
                Deque<int[]> q = new ArrayDeque<>();
                int cnt = 0;
                q.add(new int[]{j, i});
                isVisited[i][j] = idx;
                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    int x = p[0];
                    int y = p[1];
                    cnt++;
                    for (int k = 0; k < 4; k++) {
                        int xx = x + dx[k];
                        int yy = y + dy[k];
                        if (xx < 0 || yy < 0 || xx >= n || yy >= n || grid[yy][xx] == 0 || isVisited[yy][xx] > 0) {
                            continue;
                        }
                        q.add(new int[]{xx, yy});
                        isVisited[yy][xx] = idx;
                    }
                }
                counts[idx++] = cnt;
                result = Math.max(result, cnt);
            }
        }
        for (int i = 0, idx = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                Set<Integer> isUsedCount = new HashSet<>();
                int cnt = 1;
                for (int k = 0; k < 4; k++) {
                    int xx = j + dx[k];
                    int yy = i + dy[k];
                    if (xx < 0 || yy < 0 || xx >= n || yy >= n || grid[yy][xx] == 0) {
                        continue;
                    }
                    int v = isVisited[yy][xx];
                    if (isUsedCount.contains(v)) {
                        continue;
                    }
                    isUsedCount.add(v);
                    cnt += counts[v];
                }
                result = Math.max(result, cnt);
            }
        }
        return result;
    }
}
