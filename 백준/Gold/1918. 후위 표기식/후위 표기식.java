import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String s = br.readLine();

        ArrayDeque<Character> stk = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    sb.append(stk.pop());
                }
                stk.pop();
            } else if (c == '*' || c == '/') {
                while (!stk.isEmpty() && (stk.peek() == '*' || stk.peek() == '/')) {
                    sb.append(stk.pop());
                }
                stk.push(c);
            } else if (c == '+' || c == '-') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    sb.append(stk.pop());
                }
                stk.push(c);
            }
        }

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        System.out.println(sb);
    }
}
