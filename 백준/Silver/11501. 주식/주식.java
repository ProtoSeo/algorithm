import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ary = new int[n];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                ary[i] = Integer.parseInt(stk.nextToken());
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            long answer = 0;
            for (int i = n - 1; i >= 0; i--) {
                while (!pq.isEmpty() && pq.peek() <= ary[i]) {
                    pq.poll();
                }
                pq.add(ary[i]);
                answer += pq.peek() - ary[i];
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
