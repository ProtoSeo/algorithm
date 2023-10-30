import java.io.*;
import java.util.*;

public class Main {

    private static final int L = 100000;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        boolean[] isVisited = new boolean[L + 1];
        int result = Integer.MAX_VALUE;
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{n, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int now = p[0];
            int count = p[1];

            if (now == k && count <= result) {
                result = count;
                answer++;
                continue;
            }
            if (count > result) {
                continue;
            }
            isVisited[now] = true;

            if (now + 1 <= L && !isVisited[now + 1]) {
                pq.add(new int[]{now + 1, count + 1});
            }
            if (now - 1 >= 0 && !isVisited[now - 1]) {
                pq.add(new int[]{now - 1, count + 1});
            }
            if (now * 2 <= L && !isVisited[now * 2]) {
                pq.add(new int[]{now * 2, count + 1});
            }
        }
        System.out.println(result);
        System.out.println(answer);
    }
}
