class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[idx++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                result[idx++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                result[idx++] = nums[i];
            }
        }
        return result;
    }
}
