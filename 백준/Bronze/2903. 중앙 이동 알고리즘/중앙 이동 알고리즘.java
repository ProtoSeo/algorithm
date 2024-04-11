import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var dots = new int[n + 1];
        var diff = new int[n + 1];
        dots[0] = 2;
        diff[1] = 1;
        for (int i = 2; i <= n; i++) {
            diff[i] = diff[i - 1] * 2;
        }
        for (int i = 1; i <= n; i++) {
            dots[i] += dots[i - 1] + diff[i];
        }
        System.out.println(dots[n] * dots[n]);
    }
}