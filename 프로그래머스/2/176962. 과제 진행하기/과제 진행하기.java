import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int idx = 0;
        String[] answer = new String[plans.length];
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (String[] plan : plans) {
            pq.add(new Task(plan[0], plan[1], plan[2]));
        }

        Task nowPlay = null;
        Deque<Task> stk = new ArrayDeque<>();
        for (int i = 0; i <= 1540; i++) {
            if (pq.isEmpty()) {
                if (nowPlay != null) {
                    answer[idx++] = nowPlay.name;
                    nowPlay = null;
                }
                break;
            }
            
            Task t = pq.peek();
            if (i < t.start && nowPlay == null) {
                if (stk.isEmpty()) {
                    continue;
                }
                nowPlay = stk.pop();
            } else if (i == t.start) {
                if (nowPlay != null) {
                    stk.push(nowPlay);    
                }
                nowPlay = pq.poll();
            }
            nowPlay.minusPlaytime();
            if (nowPlay.playtime == 0) {
                answer[idx++] = nowPlay.name;
                nowPlay = null;
            }    
        }
        while (!stk.isEmpty()) {
            answer[idx++] = stk.pop().name;
        }

        return answer;
    }
}

class Task implements Comparable<Task> {
    String name;
    int start;
    int playtime;

    public Task(String name, String start, String playtime) {
        String[] split = start.split(":");
        this.name = name;
        this.start = 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        this.playtime = Integer.parseInt(playtime);
    }

    void minusPlaytime() {
        this.playtime--;
    }

    public int compareTo(Task t) {
        return this.start - t.start;
    }
}
