import java.util.*;
import java.io.*;

public class Main {
	private static int n, m;
	private static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer stk;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		parent = new int[n + 1];
		Arrays.fill(parent, -1);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int Q = Integer.parseInt(stk.nextToken());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			if (Q == 0) {
				union(a, b);
			}
			if (Q == 1) {
				if (find(a) == find(b)) {
					sb.append("YES" + "\n");
				} else {
					sb.append("NO" + "\n");
				}
			}
		}
		System.out.println(sb);
	}

	private static int find(int a) {
		if (parent[a] == -1)
			return a;
		return parent[a] = find(parent[a]);
	}

	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return false;
		parent[pa] = pb;
		return true;
	}

}