class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0;
        int n = s.length();
        int result = 0;
        int[] abc = new int[3];
        while (r < n) {
            abc[s.charAt(r) - 'a']++;
            while (abc[0] > 0 && abc[1] > 0 && abc[2] > 0) {
                result += n - r;
                abc[s.charAt(l++) - 'a']--;
            }
            r++;
        }
        return result;
    }
}
