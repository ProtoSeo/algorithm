class Solution {
    public int removeElement(int[] nums, int val) {
        int answer = 0;
        int idx = 0;
        int[] notEqualValues = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            notEqualValues[idx++] = nums[i];
            answer++;
        }
        for (int i = 0; i < idx; i++) {
            nums[i] = notEqualValues[i];
        }
        return answer;
    }
}

