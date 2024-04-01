import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        var stk = new StringTokenizer(br.readLine());
        if (n <= k) {
            System.out.println(0);
            return;
        }

        var censors = new int[n];
        var diff = new int[n - 1];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            censors[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(censors);
        for (int i = 0; i < n - 1; i++) {
            diff[i] = censors[i + 1] - censors[i];
            answer += diff[i];
        }
        Arrays.sort(diff);

        for (int i = 0; i < k - 1; i++) {
            answer -= diff[n - i - 2];
        }
        System.out.println(answer);
    }
}
