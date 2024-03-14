import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int end = pq.poll()[1];
            while (!pq.isEmpty() && pq.peek()[0] < end) {
                pq.poll();
            }
            answer++;
        }
        System.out.println(answer);
    }
}
