class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        while (l < r) {
            result = Math.max(result, Math.min(height[r], height[l]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else if(height[l] >= height[r]) {
                r--;
            }
        }
        return result;
    }
}
