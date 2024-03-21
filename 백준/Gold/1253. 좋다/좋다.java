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
        Arrays.sort(ary);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int target = ary[i];
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int sum = ary[l] + ary[r];
                if (target > sum) {
                    l++;
                } else if (target < sum) {
                    r--;
                } else {
                   if (l == i) {
                       l++;
                   } else if (r == i) {
                       r--;
                   } else {
                       answer++;
                       break;
                   }
                }
            }
        }
        System.out.println(answer);
    }
}
