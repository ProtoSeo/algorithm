import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] ary = new long[1000001];
        for (int i = 1; i <= 1000000; i++) {
            for (int j = 1; i * j <= 1000000; j++) {
                ary[i * j] += i;
            }
            ary[i] += ary[i - 1];
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(ary[n]).append('\n');
        }
        System.out.println(sb);
    }
}
