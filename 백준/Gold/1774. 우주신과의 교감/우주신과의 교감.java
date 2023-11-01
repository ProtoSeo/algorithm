import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        parent = new int[n];
        long[][] nodes = new long[n][2];

        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            stk = new StringTokenizer(br.readLine());
            nodes[i][0] = Long.parseLong(stk.nextToken());
            nodes[i][1] = Long.parseLong(stk.nextToken());
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken()) - 1;
            int b = Integer.parseInt(stk.nextToken()) - 1;
            union(a, b);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.distance, o2.distance));
        Set<Integer> cnt = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int pi = find(i);
            cnt.add(pi);
            for (int j = i + 1; j < n; j++) {
                if (pi == find(j)) {
                    continue;
                }
                pq.add(new Pair(i, j, getDistance(nodes[i], nodes[j])));
            }
        }

        double answer = 0.0;
        for (int i = 0; i < cnt.size() - 1; ) {
            final Pair p = pq.poll();
            int s = p.s;
            int e = p.e;
            double distance = p.distance;
            if (find(s) != find(e)) {
                answer += distance;
                union(s, e);
                i++;
            }
        }
        System.out.println(String.format("%.2f", answer));
    }

    static int find(int a) {
        if (parent[a] == -1) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        parent[pa] = pb;
        return true;
    }

    static double getDistance(long[] a, long[] b) {
        return Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
    }
}

class Pair {
    int s;
    int e;
    double distance;

    public Pair(int s, int e, double distance) {
        this.s = s;
        this.e = e;
        this.distance = distance;
    }
}
