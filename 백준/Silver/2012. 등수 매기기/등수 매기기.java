import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ary);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.abs(ary[i] - i - 1);
        }
        System.out.println(answer);
    }
}