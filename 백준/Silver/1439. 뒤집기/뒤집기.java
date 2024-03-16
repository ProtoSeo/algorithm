import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] result = new int[2];
        char prev = str.charAt(0);
        for (int i = 1; i <= str.length(); i++) {
            if (i == str.length()) {
                result[prev - '0']++;
                break;
            }
            final char c = str.charAt(i);
            if (prev == c) {
                continue;
            }
            result[prev - '0']++;
            prev = c;
        }
        System.out.println(Math.min(result[0], result[1]));
    }
}
