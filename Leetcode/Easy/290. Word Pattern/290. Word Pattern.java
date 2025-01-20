class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> hash1 = new HashMap<>();
        Map<String, Character> hash2 = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (hash1.containsKey(c) && hash2.containsKey(word)) {
                if (!hash1.get(c).equals(word) || !hash2.get(word).equals(c)) {
                    return false;
                }
            } else if (!hash1.containsKey(c) && !hash2.containsKey(word)) {
                hash1.put(c, word);
                hash2.put(word, c);
            } else {
                return false;
            }
        }
        return true;
    }
}
