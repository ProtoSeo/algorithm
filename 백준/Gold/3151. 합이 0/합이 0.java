import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var stk = new StringTokenizer(br.readLine());
        var ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(ary);

        long answer = 0;
        for (int i = 0; i < n; i++) {
            if (ary[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = ary[i] + ary[j] + ary[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    int r = k;
                    int l = j;
                    if (ary[j] == ary[k]) {
                        answer += (k - j) * ((k - j) + 1) / 2;
                        break;
                    }
                    while (r > j && ary[r - 1] == ary[r]) {
                        r--;
                    }
                    while (l < k && ary[l + 1] == ary[l]) {
                        l++;
                    }
                    answer += (k - r + 1) * (l - j + 1);
                    k = r - 1;
                    j = l + 1;
                }
            }
        }
        System.out.println(answer);
    }
}
