import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> ary = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            ary.add(new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});
        }
        ary.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int start = ary.get(i)[0];
            int end = ary.get(i)[1];
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.add(end);
        }
        System.out.println(pq.size());
    }
}
