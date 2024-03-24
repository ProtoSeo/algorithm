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
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
            l = Math.max(l, ary[i]);
            r += ary[i];
        }

        while (l < r) {
            int mid = (l + r) / 2;
            int count = 1;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (temp + ary[i] > mid) {
                    temp = 0;
                    count++;
                }
                temp += ary[i];
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
