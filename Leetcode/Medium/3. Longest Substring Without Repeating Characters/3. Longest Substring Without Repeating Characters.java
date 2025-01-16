class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int n = s.length();
        int l = 0;
        int r = 0;

        while (l <= r && r < n) {
            char c = s.charAt(r);
            if (set.isEmpty() || !set.contains(c)) {
                set.add(c);
                r++;
                result = Math.max(result, r - l);
            } else if (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
        }
        return result;
    }
}
