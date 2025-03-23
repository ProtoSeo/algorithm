class Solution {

    private final int MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int s = road[0];
            int e = road[1];
            int t = road[2];
            graph[s].add(new int[] {e, t});
            graph[e].add(new int[] {s, t});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[0], o2[0]));

        long[] times = new long[n];
        Arrays.fill(times, Long.MAX_VALUE);
        int[] count = new int[n];

        times[0] = 0;
        count[0] = 1;
        pq.add(new long[] {0, 0});

        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            long time = p[0];
            int node = (int) p[1];

            if (time > times[node]) {
                continue;
            }

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextTime = next[1];

                if (time + nextTime < times[nextNode]) {
                    times[nextNode] = time + nextTime;
                    count[nextNode] = count[node];
                    pq.add(new long[] { times[nextNode], nextNode });
                } else if (time + nextTime == times[nextNode]) {
                    count[nextNode] = (count[nextNode] + count[node]) % MOD;
                }
            }
        }
        return count[n - 1];
    }
}
