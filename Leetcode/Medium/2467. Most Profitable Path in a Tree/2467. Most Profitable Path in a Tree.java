class Solution {

    List<List<Integer>> tree = new ArrayList<>();
    Map<Integer, Integer> bobPath = new HashMap<>();
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            tree.get(s).add(e);
            tree.get(e).add(s);
        }

        findBob(bob, 0, new boolean[n]);

        Deque<int[]> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        q.add(new int[]{0, 0, 0});
        isVisited[0] = true;
        int maxIncome = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int s = node[0];
            int t = node[1];
            int i = node[2];
            if (!bobPath.containsKey(s) || t < bobPath.get(s)) {
                i += amount[s];
            } else if (t == bobPath.get(s)) {
                i += amount[s] / 2;
            }

            if (tree.get(s).size() == 1 && s != 0) {
                maxIncome = Math.max(maxIncome, i);
            }
            for (int next : tree.get(s)) {
                if (isVisited[next]) {
                    continue;
                }
                q.add(new int[]{next, t + 1, i});
                isVisited[next] = true;
            }
        }
        return maxIncome;
    }

    private boolean findBob(int s, int t, boolean[] isVisited) {
        bobPath.put(s, t);
        isVisited[s] = true;
        if (s == 0) {
            return true;
        }
        for (int node : tree.get(s)) {
            if (isVisited[node]) {
                continue;
            }
            if (findBob(node, t + 1, isVisited)) {
                return true;
            }
        }
        bobPath.remove(s);
        return false;
    }
}
