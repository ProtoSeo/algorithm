import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ary = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> q = new ArrayDeque<>();
        int[] isVisited = new int[n];
        Arrays.fill(isVisited, -1);
        q.add(0);
        isVisited[0] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == n - 1) {
                System.out.println(isVisited[now]);
                return;
            }

            for (int next = now + 1; next <= now + ary[now] && next < n; next++) {
                if (isVisited[next] >= 0) {
                    continue;
                }
                isVisited[next] = isVisited[now] + 1;
                q.add(next);
            }
        }
        System.out.println(-1);
    }
}
