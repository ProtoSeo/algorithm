import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var stk = new StringTokenizer(br.readLine());
        var q = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            q.add(new int[]{Integer.parseInt(stk.nextToken()), i});
        }
        var sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int val = p[0];
            sb.append(p[1] + 1).append(' ');
            if (val < 0) {
                for (int i = 0; i < -val && !q.isEmpty(); i++) {
                    q.addFirst(q.pollLast());
                }
            } else {
                for (int i = 1; i < val && !q.isEmpty(); i++) {
                    q.add(q.poll());
                }
            }
        }
        System.out.println(sb);
    }
}
