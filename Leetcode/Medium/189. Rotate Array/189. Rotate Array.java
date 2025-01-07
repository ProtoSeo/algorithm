class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int start = (length - (k % length)) % length;
        int[] result = new int[length];
        for (int i = start , j = 0; j < length; i = (i + 1) % length, j++) {
            result[j] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = result[i];
        }
    }
}
