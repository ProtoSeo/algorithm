import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        for (int i = 0; i < n; i += 4) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}
