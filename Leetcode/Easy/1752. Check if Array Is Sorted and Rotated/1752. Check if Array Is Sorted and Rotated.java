class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] copied = Arrays.copyOf(nums, n);
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            boolean isSame = true;
            for (int j = 0; j < n; j++) {
                if (copied[(j + i) % n] != nums[j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return true;
            }
        }
        return false;
    }
}
