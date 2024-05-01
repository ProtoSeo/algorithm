import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        var a = new TreeSet<Integer>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.valueOf(stk.nextToken()));
        }

        var b = new HashSet<Integer>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b.add(Integer.valueOf(stk.nextToken()));
        }

        a.removeAll(b);
        var sb = new StringBuilder();
        sb.append(a.size()).append('\n');
        for (int i : a) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
