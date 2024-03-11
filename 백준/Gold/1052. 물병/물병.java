import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        if (k >= n) {
            System.out.println(0);
            return;
        }
        int answer = 0;
        while (true) {
            int tmp = n + answer;
            int cnt = 0;

            while (tmp > 0) {
                if (tmp % 2 == 1) {
                    cnt++;
                }
                tmp /= 2;
            }
            if (cnt <= k) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
