class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        while (l < r) {
            if (lMax < rMax) {
                answer += lMax - height[l];
                lMax = Math.max(height[++l], lMax);
            } else {
                answer += rMax - height[r];
                rMax = Math.max(height[--r], rMax);
            }
        }
        return answer;
    }
}
