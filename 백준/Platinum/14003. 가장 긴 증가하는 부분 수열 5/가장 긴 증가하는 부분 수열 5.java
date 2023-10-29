import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());
        final String[] split = br.readLine().split(" ");
        int[] num = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        List<Integer> ary = new ArrayList<>();
        ary.add(-1000000001);
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(split[i]);
            num[i] = now;
            if (now > ary.get(ary.size() - 1)) {
                ary.add(now);
                prev[i] = ary.size() - 1;
                continue;
            }
            int l = 0;
            int r = ary.size() - 1;
            while (l < r) {
                int m = (l + r) >> 1;
                if (now <= ary.get(m)) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            ary.set(r, now);
            prev[i] = r;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ary.size() - 1).append('\n');

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int idx = ary.size() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (idx == prev[i]) {
                stk.push(num[i]);
                idx--;
            }
        }
        while(!stk.isEmpty()) {
            sb.append(stk.pop()).append(' ');
        }
        System.out.println(sb);
    }
}
