import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        split = br.readLine().split(" ");
        int[] diff = new int[n - 1];
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            diff[i] = Integer.parseInt(split[i + 1]) - Integer.parseInt(split[i]);
            answer += diff[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k - 1; i++) {
            answer -= diff[n - i - 2];
        }
        System.out.println(answer);
    }
}
