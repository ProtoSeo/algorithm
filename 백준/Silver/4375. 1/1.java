import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (str != null) {
            BigInteger n = new BigInteger(str);
            BigInteger num = BigInteger.ONE;
            while (!num.mod(n).equals(BigInteger.ZERO)) {
                num = num.multiply(BigInteger.TEN).add(BigInteger.ONE);
            }
            sb.append(num.toString().length()).append('\n');
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
