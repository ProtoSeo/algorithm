import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] ary = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }

        int l = 0;
        int r = 50000001;

        while (l < r) {
            int mid = (l + r) / 2;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count = 1;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, ary[i]);
                max = Math.max(max, ary[i]);

                if (max - min > mid) {
                    min = ary[i];
                    max = ary[i];
                    count++;
                }
            }

            if (count > m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(r);
    }
}
