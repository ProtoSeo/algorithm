class Solution {

    int[] parent;
    int[] size;
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);
        Map<Integer, Integer> counts = new HashMap<>();

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = find(edge[0]);
            counts.put(root, counts.getOrDefault(root, 0) + 1);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                int s = size[i];
                int count = s * (s - 1) / 2;
                if (counts.getOrDefault(i, 0) == count) {
                    result++;
                }
            }
        }
        return result;
    }

    private int find(int n) {
        if (parent[n] < 0) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    private boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        parent[pa] = pb;
        size[pb] += size[pa];
        return true;
    }
}
