import java.io.*;
import java.util.*;

public class Main {

    static int n, count;
    static int[] d;
    static boolean[] isVisited;
    static boolean[] isFinished;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            var stk = new StringTokenizer(br.readLine());

            d = new int[n + 1];
            isVisited = new boolean[n + 1];
            isFinished = new boolean[n + 1];
            count = 0;
            for (int i = 1; i <= n; i++) {
                d[i] = Integer.parseInt(stk.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            sb.append(n - count).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int now) {
        if (isVisited[now]) {
            return;
        }
        isVisited[now] = true;
        int next = d[now];
        if (!isVisited[next]) {
            dfs(next);
        } else if (!isFinished[next]) {
            for (int i = next; i != now; i = d[i]) {
                count++;
            }
            count++;
        }
        isFinished[now] = true;
    }
}
