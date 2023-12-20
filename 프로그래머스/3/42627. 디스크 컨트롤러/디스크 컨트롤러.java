import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int jobCount = jobs.length;
        int answer = 0;
        
        int idx = 0;
        int now = 0;
        int[] run = {0, 0};
        PriorityQueue<int[]> waitQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i <= 500000; i++) {
           	if (idx < jobCount && jobs[idx][0] <= i) {
                int[] selectedJob = jobs[idx++];
                if (run[1] > i) {
                    waitQueue.add(selectedJob);
            	    continue;
            	}
              	waitQueue.add(selectedJob);
	          	int[] waitedJob = waitQueue.poll();
	            answer += i - waitedJob[0] + waitedJob[1];
	            run = new int[]{i, i + waitedJob[1]};
            } else if (!waitQueue.isEmpty()) {
                if (run[1] > i) {
            	    continue;
            	}
               	int[] waitedJob = waitQueue.poll();
	            answer += i - waitedJob[0] + waitedJob[1];
	            run = new int[]{i, i + waitedJob[1]};
            }     
        }
        return answer / jobCount;
    }
}