class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0;
        int tIdx = 0;
        for (;sIdx < s.length(); sIdx++) {
            boolean hasContain = false;
            char c = s.charAt(sIdx);
            for (;tIdx < t.length(); tIdx++) {
                if (t.charAt(tIdx) == c) {
                    tIdx++;
                    hasContain = true;
                    break;
                }
            }
            if (!hasContain) {
                return false;
            }
        }
        return true;
    }
}
