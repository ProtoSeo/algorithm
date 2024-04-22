import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        var ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(ary);

        int answer = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int sum = ary[l] + ary[r];
            if (sum == x) {
                answer++;
                l++;
                r--;
            } else if (sum < x) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(answer);
    }
}
