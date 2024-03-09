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
        System.out.println(ary[0] * ary[n - 1]);
    }
}