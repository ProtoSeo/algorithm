import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            pq.add(new int[]{a, b, c});
        }

        int answer = 0;
        for (int i = 0; i < n - 2; ) {
            final int[] p = pq.poll();
            int s = p[0];
            int e = p[1];
            int w = p[2];

            if (find(s) != find(e)) {
                union(s, e);
                answer += w;
                i++;
            }
        }
        System.out.println(answer);
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
}