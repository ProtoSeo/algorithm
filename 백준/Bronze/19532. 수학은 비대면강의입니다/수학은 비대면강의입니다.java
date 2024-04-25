import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());
        int f = Integer.parseInt(stk.nextToken());
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
    }
}
