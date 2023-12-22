import java.io.*;
import java.util.*;

public class Main {

    private static final long INF = Long.MAX_VALUE;
    private static List<Edge>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        final int n = Integer.parseInt(split[0]);
        final int m = Integer.parseInt(split[1]);
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        split = br.readLine().split(" ");
        Set<Integer> isWard = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            if (Integer.parseInt(split[i]) == 1) {
                isWard.add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int t = Integer.parseInt(split[2]);
            if (isWard.contains(a) || isWard.contains(b)) {
                continue;
            }
            adjList[a].add(new Edge(a, b, t));
            adjList[b].add(new Edge(b, a, t));
        }

        long[] result = new long[n];
        Arrays.fill(result, INF);
        result[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            final Pair p = pq.poll();
            int now = p.s;
            long time = p.t;
            if (time > result[now]) {
                continue;
            }

            for (Edge edge : adjList[now]) {
                int next = edge.b;
                int nextTime = edge.t;
                if (result[next] > result[now] + nextTime) {
                    result[next] = result[now] + nextTime;
                    pq.add(new Pair(next, result[next]));
                }
            }
        }
        System.out.println((INF == result[n - 1]) ? -1 : result[n - 1]);
    }
}

class Pair implements Comparable<Pair> {

    int s;
    long t;

    public Pair(final int s, final long t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(final Pair o) {
        return Long.compare(this.t, o.t);
    }
}

class Edge {

    int a;
    int b;
    int t;

    public Edge(final int a, final int b, final int t) {
        this.a = a;
        this.b = b;
        this.t = t;
    }
}
