class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] sorted = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sorted[i][0] = queries[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] isVisited = new boolean[n][m];

        int point = 0;
        int[] result = new int[queries.length];
        pq.add(new int[]{grid[0][0], 0, 0});
        isVisited[0][0] = true;

        for (int[] query : sorted) {
            int value = query[0];
            int index = query[1];

            while (!pq.isEmpty() && pq.peek()[0] < value) {
                int[] top = pq.poll();
                int now = top[0];
                int y = top[1];
                int x = top[2];
                point++;
                for (int i = 0; i < 4; i++) {
                    int yy = y + dy[i];
                    int xx = x + dx[i];

                    if (xx >=0 && yy >= 0 && yy < n && xx < m && !isVisited[yy][xx]) {
                        pq.add(new int[] { grid[yy][xx], yy, xx });
                        isVisited[yy][xx] = true;
                    }
                }
            }
            result[index] = point;
        }
        return result;

    }
}
