class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int diffCount = 0;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (++diffCount > 2) {
                    return false;
                }
            }

            f1[c1 - 'a']++;
            f2[c2 - 'a']++;
        }
        return Arrays.equals(f1, f2);
    }
}
