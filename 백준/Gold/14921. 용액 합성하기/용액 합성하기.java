import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }

        int l = 0;
        int r = n - 1;
        int answer = Integer.MAX_VALUE;
        while (l < r) {
            int sum = ary[l] + ary[r];
            if (sum == 0) {
                answer = 0;
                break;
            }
            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }

            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            }
        }
        System.out.println(answer);
    }
}
