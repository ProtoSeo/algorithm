import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] result = new int[n + 1][m + 1];
        List<Node>[] adjList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(result[i], INF);
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());
            adjList[u].add(new Node(u, v, c, d));
        }

        result[1][0] = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (Node next : adjList[j]) {
                    if (i + next.c <= m) {
                        result[next.e][i + next.c] = Math.min(result[next.e][i + next.c], result[j][i] + next.d);
                    }
                }
            }
        }

        int answer = INF;
        for (int i = 0; i <= m; i++) {
            answer = Math.min(answer, result[n][i]);
        }
        System.out.println((answer == INF) ? "Poor KCM" : answer);
    }
}

class Node {
    int s;
    int e;
    int c;
    int d;

    public Node(int s, int e, int c, int d) {
        this.s = s;
        this.e = e;
        this.c = c;
        this.d = d;
    }
}
