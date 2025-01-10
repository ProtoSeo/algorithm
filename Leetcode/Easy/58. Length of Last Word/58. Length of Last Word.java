class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result = 0;
                continue;
            }
            result++;
        }
        return result;
    }
}
