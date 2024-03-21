import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 987654321;
    static int[][] adjAry;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());
        adjAry = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                adjAry[i][j] = INF;
            }
        }
        nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            nodes[i] = new Node(s, x, y);
        }

        for (int i = 1; i <= n; i++) {
            Node start = nodes[i];
            for (int j = i + 1; j <= n; j++) {
                Node end = nodes[j];
                int time = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
                if (start.s == 1 && end.s == 1) {
                    time = Math.min(time, t);
                }
                adjAry[i][j] = Math.min(adjAry[i][j], time);
                adjAry[j][i] = Math.min(adjAry[j][i], time);
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (adjAry[i][j] > adjAry[i][k] + adjAry[k][j]) {
                        adjAry[i][j] = adjAry[i][k] + adjAry[k][j];
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            sb.append(adjAry[s][e]).append('\n');
        }
        System.out.println(sb);
    }
}

class Node {
    int s;
    int x;
    int y;

    public Node(int s, int x, int y) {
        this.s = s;
        this.x = x;
        this.y = y;
    }
}
