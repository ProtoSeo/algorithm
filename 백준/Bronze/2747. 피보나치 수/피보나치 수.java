import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var ary = new int[n + 1];
        ary[1] = 1;
        for (int i = 2; i <= n; i++) {
            ary[i] = ary[i - 1] + ary[i - 2];
        }
        System.out.println(ary[n]);
    }
}
