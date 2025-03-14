class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int l = 0;
        int r = queries.length;

        if (!currentIndex(nums, queries, r)) {
            return -1;
        }
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (currentIndex(nums, queries, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean currentIndex(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int sum = 0;
        int[] preSum = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int v = queries[i][2];

            preSum[l] += v;
            preSum[r + 1] -= v;
        }

        for (int i = 0; i < n; i++) {
            sum += preSum[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
