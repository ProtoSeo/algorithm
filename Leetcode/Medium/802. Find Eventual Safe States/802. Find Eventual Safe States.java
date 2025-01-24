class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] inversion = new List[n];
        int[] outgoing = new int[n];
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            inversion[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int e : graph[i]) {
                inversion[e].add(i);
                outgoing[i]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outgoing[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            if (isVisited[now]) {
                continue;
            }
            isVisited[now] = true;
            for (int e : inversion[now]) {
                if (--outgoing[e] == 0) {
                    q.add(e);
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (outgoing[i] == 0) {
                answer.add(i);
            }
        }
        return answer;
    }
}
