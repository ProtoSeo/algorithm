class Solution {
    int[] colors;
    int[] distances;
    List<Integer>[] graph;
    public int magnificentSets(int n, int[][] edges) {
        colors = new int[n + 1];
        distances = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            colors[i] = -1;
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (colors[i] > -1) {
                continue;
            }
            colors[i] = 0;
            if (!dfs(i, colors[i])) {
                return -1;
            }
        }
        for (int i = 1; i <= n; i++) {
            distances[i] = bfs(i, new boolean[n + 1]);
        }

        int result = 0;
        boolean[] isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) {
                continue;
            }
            result += getGroupCount(i, isVisited);
        }
        return result;
    }

    public boolean dfs(int now, int color) {
        for (int next : graph[now]) {
            if (colors[next] == colors[now]) {
                return false;
            }
            if (colors[next] > 0) {
                continue;
            }
            colors[next] = 1 - color;
            if (!dfs(next, colors[next])) {
                return false;
            }
        }
        return true;
    }

    public int bfs(int start, boolean[] isVisited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        isVisited[start] = true;
        int dist = 0;

        while (!q.isEmpty()) {
            int sizeOfLayer = q.size();
            for (int i = 0; i < sizeOfLayer; i++) {
                int now = q.poll();
                for (int next : graph[now]) {
                    if (isVisited[next]) {
                        continue;
                    }
                    q.add(next);
                    isVisited[next] = true;
                }
            }
            dist++;
        }
        return dist;
    }

    public int getGroupCount(int now, boolean[] isVisited) {
        int dist = distances[now];
        isVisited[now] = true;
        for (int next : graph[now]) {
            if (isVisited[next]) {
                continue;
            }
            dist = Math.max(dist, getGroupCount(next, isVisited));
        }
        return dist;
    }
}
