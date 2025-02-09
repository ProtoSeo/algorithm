class Solution {
    private Map<Integer, Integer> counts = new HashMap<>();
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = getPair(n);
        for (int i = 0; i < n; i++) {
            counts.merge(nums[i] - i, 1, Integer::sum);
        }
        for (int value : counts.values()) {
            result -= getPair(value);
        }
        return result;
    }

    private long getPair(long n) {
        return n * (n - 1) / 2;
    }
}
