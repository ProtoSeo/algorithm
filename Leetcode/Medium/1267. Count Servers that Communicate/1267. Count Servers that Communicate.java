// First
class Solution {

    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }
                int cnt = 0;
                Deque<int[]> q = new ArrayDeque<>();
                q.add(new int[]{j, i});
                isVisited[i][j] = true;

                while (!q.isEmpty()) {
                    int[] p = q.poll();
                    int x = p[0];
                    int y = p[1];
                    cnt++;

                    for (int k = 0; k < m; k++) {
                        if (grid[y][k] == 0 || isVisited[y][k]) {
                            continue;
                        }
                        q.add(new int[]{k, y});
                        isVisited[y][k] = true;
                    }
                    for (int k = 0; k < n; k++) {
                        if (grid[k][x] == 0 || isVisited[k][x]) {
                            continue;
                        }
                        q.add(new int[]{x, k});
                        isVisited[k][x] = true;
                    }
                }

                if (cnt > 1) {
                    result += cnt;
                }
            }
        }
        return result;
    }
}
// Second
class Solution {

    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                rowCount[i]++;
                colCount[j]++;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }
}
