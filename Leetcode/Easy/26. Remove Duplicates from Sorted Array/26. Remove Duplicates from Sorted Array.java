class Solution {
    public int removeDuplicates(int[] nums) {
        int[] count = new int[201];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 100]++;
        }

        int answer = 0;
        for (int i = 0, j = 0; i <= 200; i++) {
            if (count[i] == 0) {
                continue;
            }
            answer++;
            nums[j++] = i - 100;
        }
        return answer;
    }
}

