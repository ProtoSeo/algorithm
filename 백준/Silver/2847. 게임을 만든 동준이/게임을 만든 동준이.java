import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (ary[i] <= ary[i - 1]) {
                answer += ary[i - 1] - ary[i] + 1;
                ary[i - 1] = ary[i] - 1;
            }
        }
        System.out.println(answer);
    }
}
