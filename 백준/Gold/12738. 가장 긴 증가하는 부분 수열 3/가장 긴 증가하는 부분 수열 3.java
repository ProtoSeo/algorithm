import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());
        final String[] split = br.readLine().split(" ");
        
        List<Integer> ary = new ArrayList<>();
        ary.add(-1000000001);
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(split[i]);
            if (now > ary.get(ary.size() - 1)) {
                ary.add(now);
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
        }
        System.out.println(ary.size() - 1);
    }
}
