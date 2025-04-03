class Solution {
    public long maximumTripletValue(int[] nums) {
        long result = 0, dmax = 0, imax = 0;
        for (int num : nums) {
            result = Math.max(result, dmax * num);
            dmax = Math.max(dmax, imax - num);
            imax = Math.max(imax, num);
        }
        return result;
    }
}
