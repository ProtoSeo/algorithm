class Solution {
    public int removeDuplicates(int[] nums) {
        int[] count = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 10000]++;
        }
        int idx = 0;
        int answer = 0;
        for (int i = 0; i <= 20000; i++) {
            if (count[i] == 0) {
                continue;
            }
            int min = Math.min(count[i], 2);
            for (int j = 0; j < min; j++) {
                answer++;
                nums[idx++] = i - 10000;
            }
        }
        return answer;
    }
}
