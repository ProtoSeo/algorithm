import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (n != -1) {
            int sum = 1;
            var candidate = new ArrayList<Integer>();
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    sum += (i + n / i);
                    candidate.add(i);
                    candidate.add(n / i);
                }
            }
            if (sum == n) {
                candidate.sort(Comparator.naturalOrder());
                sb.append(n).append(" = 1");
                for (int i : candidate) {
                    sb.append(" + ").append(i);
                }
            } else {
                sb.append(n).append(" is NOT perfect.");
            }
            sb.append('\n');
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}