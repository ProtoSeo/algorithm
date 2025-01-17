class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int result = 0;
        for (int i : derived) {
            result ^= i;
        }
        return result == 0;
    }
}
