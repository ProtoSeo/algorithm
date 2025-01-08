// First Solution
import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] isVisited = new int[n];
        Arrays.fill(isVisited, -1);
        q.add(0);
        isVisited[0] = 0;

        int answer = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == n - 1) {
                answer = isVisited[now];
                break;
            }
            int j = nums[now];
            for (int i = now; i <= now + j && i < n; i++) {
                if (isVisited[i] >= 0) {
                    continue;
                }
                q.add(i);
                isVisited[i] = isVisited[now] + 1;
            }
        }
        return answer;
    }
}
// Second Solution
import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] isVisited = new int[n];
        Arrays.fill(isVisited, -1);
        q.add(0);
        isVisited[0] = 0;

        int answer = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == n - 1) {
                answer = isVisited[now];
                break;
            }
            int j = nums[now];
            for (int i = now; i <= now + j && i < n; i++) {
                if (isVisited[i] >= 0) {
                    continue;
                }
                q.add(i);
                isVisited[i] = isVisited[now] + 1;
            }
        }
        return answer;
    }
}
// Third Solution
class Solution {
    public int jump(int[] nums) {
        int maximum = 0;
        int current = 0;
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maximum = Math.max(maximum, i + nums[i]);
            if (current == i) {
                current = maximum;
                answer++;
            }
        }
        return answer;
    }
}
