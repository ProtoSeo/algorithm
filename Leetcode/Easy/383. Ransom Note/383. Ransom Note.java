class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[(int)c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[(int)c - 'a']--;
        }
        for (int i : count) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
