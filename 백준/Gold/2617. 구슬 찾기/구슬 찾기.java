import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] upper, lower;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        upper = new int[n + 1];
        lower = new int[n + 1];
        adjList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            adjList[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, i, new boolean[n + 1]);
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (upper[i] > n / 2 || lower[i] > n / 2) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int now, int start, boolean[] isVisited) {
        if (isVisited[now]) {
            return;
        }
        isVisited[now] = true;
        for (int next : adjList[now]) {
            if (isVisited[next]) {
                continue;
            }
            lower[next]++;
            upper[start]++;
            dfs(next, start, isVisited);
        }
    }
}
