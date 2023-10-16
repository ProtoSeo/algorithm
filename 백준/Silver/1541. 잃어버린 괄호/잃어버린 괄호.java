import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer stk = new StringTokenizer(s,"+-");
        int size = stk.countTokens();
        char[] op = new char[size-1];
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(stk.nextToken());
        }
        for (int i = 0,j=0; i < s.length(); i++) {
            if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                op[j++] = s.charAt(i);
            }
        }
        int ans = numbers[0];
        for (int i = 0; i < size-1;) {
            if(op[i]=='-'){
                int j = i+1;
                int next = numbers[j];
                for (; j < size-1; j++) {
                    if(op[j]=='+'){
                        next += numbers[j+1];
                        continue;
                    }else{
                        break;
                    }
                }
                ans -= next;
                i=j;
            }else{
                ans += numbers[++i];
            }
        }
        System.out.println(ans);
    }
}