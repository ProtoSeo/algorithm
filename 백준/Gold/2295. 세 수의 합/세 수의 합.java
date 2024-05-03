import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var ary = new int[n];
        var set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            set.add(ary[i]);
        }
        Arrays.sort(ary);

        var sum = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i * n + j] = ary[i] + ary[j];
            }
        }
        Arrays.sort(sum);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int l = 0;
                int r = n * n + 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (sum[mid] == ary[i] - ary[j]) {
                        answer = Math.max(answer, sum[mid] + ary[j]);
                        break;
                    } else if (sum[mid] < ary[i] - ary[j]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
