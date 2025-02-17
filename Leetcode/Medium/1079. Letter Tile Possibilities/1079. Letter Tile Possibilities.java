class Solution {

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return find(count);
    }

    public int find(int[] count) {
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            result++;
            count[i]--;
            result += find(count);
            count[i]++;
        }
        return result;
    }
}
