import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int idx = 1;
        int l = Integer.parseInt(stk.nextToken());
        int p = Integer.parseInt(stk.nextToken());
        int v = Integer.parseInt(stk.nextToken());
        var sb = new StringBuilder();
        while (l != 0 && p != 0 && v != 0) {
            int answer = (v / p) * l + Math.min(l, v % p);
            sb.append("Case ").append(idx++).append(": ").append(answer).append('\n');
            stk = new StringTokenizer(br.readLine());
            l = Integer.parseInt(stk.nextToken());
            p = Integer.parseInt(stk.nextToken());
            v = Integer.parseInt(stk.nextToken());
        }
        System.out.println(sb);
    }
}
