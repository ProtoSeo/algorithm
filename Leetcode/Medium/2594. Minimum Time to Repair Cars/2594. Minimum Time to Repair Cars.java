class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 0;
        long r = (long) cars * cars * 100;

        while (l < r) {
            long mid = (l + r) >> 1;
            long sum = 0;
            for (int i = 0; i < ranks.length; i++) {
                long rank = ranks[i];
                sum += (long) Math.sqrt(mid / rank);
                if (sum >= cars) {
                    break;
                }
            }
            if (sum >= cars) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
