import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var cents = new int[]{25, 10, 5, 1};
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (n-- > 0) {
            int money = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                int result = money / cents[i];
                money %= cents[i];
                sb.append(result).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}