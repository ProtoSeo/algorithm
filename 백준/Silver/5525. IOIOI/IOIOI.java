import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        final String str = br.readLine();

        int answer = 0;
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'O') {
                count = 0;
                continue;
            }
            if (str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                count++;
                i++;
                if (count == n) {
                    answer++;
                    count--;
                }
            } else {
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
