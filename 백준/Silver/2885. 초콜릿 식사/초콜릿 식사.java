import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = 1;
        while (t < n) {
            t *= 2;
        }
        System.out.println(t + " " + brokenCount(n, t));
    }

    static int brokenCount(int n, int t) {
        if (n == t) {
            return 0;
        }
        int result = 0;
        int k = t;
        while (n != 0) {
            result++;
            k /= 2;
            if (n - k >= 0) {
                n -= k;
            }
        }
        return result;
    }
}