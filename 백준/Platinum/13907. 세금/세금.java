import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 987654321;
    static List<Node>[] adjList;
    static int[] tax;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        tax = new int[k + 1];
        adjList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        stk = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            adjList[a].add(new Node(a, b, w));
            adjList[b].add(new Node(b, a, w));
        }
        for (int i = 0; i < k; i++) {
            int t = Integer.parseInt(br.readLine());
            tax[i + 1] = tax[i] + t;
        }

        var result = new int[n + 1][n + 1];
        var pq = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i <= n; i++) {
            Arrays.fill(result[i], INF);
        }

        result[0][s] = 0;
        pq.add(new int[]{s, 0, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int now = p[0];
            int cost = p[1];
            int count = p[2];
            if (now == d || count >= n) {
                continue;
            }
            if (result[count][now] < cost) {
                continue;
            }

            for (Node node : adjList[now]) {
                int next = node.b;
                int nextCost = node.w;
                if (result[count + 1][next] > result[count][now] + nextCost) {
                    result[count + 1][next] = result[count][now] + nextCost;
                    pq.add(new int[]{next, result[count + 1][next], count + 1});
                }
            }
        }

        var sb = new StringBuilder();
        for (int i = 0; i <= k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= n; j++) {
                min = Math.min(min, result[j][d] + (tax[i] * j));
            }
            sb.append(min).append('\n');

        }
        System.out.print(sb);
    }
}

class Node {
    int a;
    int b;
    int w;

    public Node(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }
}
