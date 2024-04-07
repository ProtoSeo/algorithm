import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] scores;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n + 1];
        adjList = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        while (true) {
            var stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            adjList[a].add(b);
            adjList[b].add(a);
        }

        int score = -1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            var isVisited = bfs(i);
            scores[i] = Arrays.stream(isVisited).max().getAsInt();
            if (score == -1 || score > scores[i]) {
                score = scores[i];
                count = 1;
            } else if (score == scores[i]) {
                count++;
            }
        }
        var sb = new StringBuilder();
        sb.append(score).append(' ').append(count).append('\n');
        for (int i = 1; i <= n; i++) {
            if (score == scores[i]) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    static int[] bfs(int target) {
        var isVisited = new int[n + 1];
        Arrays.fill(isVisited, -1);
        var q = new ArrayDeque<Integer>();
        isVisited[target] = 0;
        q.add(target);
        while (!q.isEmpty()) {
            int now = q.poll();
            int c = isVisited[now];
            for (int next : adjList[now]) {
                if (isVisited[next] >= 0) {
                    continue;
                }
                isVisited[next] = c + 1;
                q.add(next);
            }
        }
        return isVisited;
    }
}
