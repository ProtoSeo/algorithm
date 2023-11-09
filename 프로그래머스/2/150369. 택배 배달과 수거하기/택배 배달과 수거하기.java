class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliveryIdx = -1;
        int pickupIdx = -1;
        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0) {
                deliveryIdx = i;
            }
            if (pickups[i] > 0) {
                pickupIdx = i;
            }
        }
        
        long answer = 0;
        while (deliveryIdx != -1 || pickupIdx != -1) {
            int idx = Math.max(deliveryIdx, pickupIdx) + 1;
            answer += (idx * 2);
            
            deliveryIdx = move(cap, deliveryIdx, deliveries);
            pickupIdx = move(cap, pickupIdx, pickups);
        }
        return answer;
    }
    
    int move(int cap, int idx, int[] target) {
        while (idx >= 0 && cap > 0) {
            if (target[idx] > cap) {
                target[idx] -= cap;
                cap = 0;
            } else {
                cap -= target[idx];
                target[idx] = 0;
                idx--;
            }
        }
        while (idx >= 0 && target[idx] == 0) {
            idx--;
        }
        return idx;
    }

}