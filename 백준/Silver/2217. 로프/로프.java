import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ary);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(ary[i] * (n - i), answer);
        }
        System.out.println(answer);
    }
}
