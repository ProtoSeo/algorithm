import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && --k == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
