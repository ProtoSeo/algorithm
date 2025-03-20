class Solution {

    int[] parent;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        int[] values = new int[n];
        Arrays.fill(values, Integer.MAX_VALUE);
        for (int[] edge : edges) {
            int p = find(edge[0]);
            values[p] &= edge[2];
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int[] q = query[i];
            int s = find(q[0]);
            int e = find(q[1]);
            if (s != e) {
                result[i] = -1;
            } else {
                result[i] = values[s];
            }
        }
        return result;
    }

    public int find(int n) {
        if (parent[n] < 0) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        parent[pb] = pa;
        return true;
    }
}
