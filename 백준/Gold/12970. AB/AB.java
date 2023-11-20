import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        for (int a = 0; a <=n; a++) {
            int b = n-a;
            if(a*b<k) continue;
            int[] cnt = new int[b+1];
            for (int i = 0; i < a; i++) {
                int x = Math.min(b,k);
                cnt[x]++;
                k -= x;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = b; i>= 0; i--) {
                for (int j = 0; j < cnt[i]; j++) {
                    sb.append('A');
                }
                if(i>0){
                    sb.append('B');
                }
            }
            System.out.println(sb);
            return;
        }
        System.out.println(-1);
    }
}