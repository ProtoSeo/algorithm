class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    sum++;
                    i++;
                }
            }
            if (sum >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
