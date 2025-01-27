class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] inDegree = new int[numCourses];
        Set<Integer>[] isPre = new Set[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
            isPre[i] = new HashSet<>();
        }
        for (int[] pre : prerequisites) {
            int s = pre[0];
            int e = pre[1];
            inDegree[e]++;
            graph[s].add(e);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : graph[node]) {
                isPre[next].add(node);
                isPre[next].addAll(isPre[node]);
                if (--inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPre[query[1]].contains(query[0]));
        }
        return result;
    }
}
