class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            int s = nums[i];
            int e = nums[i];
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] > e + 1) {
                    break;
                }
                e = nums[j];
            }
            if (s == e) {
                result.add(String.valueOf(s));
            } else {
                result.add(s + "->" + e);
            }
            i = j;
        }
        return result;
    }
}
