class Solution {
    public long countOfSubstrings(String word, int k) {
        Map<Character, Integer> vowels = new HashMap<>();
        int n = word.length();
        long result = 0;
        int l = 0;

        int[] next = new int[n];
        int nextIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            next[i] = nextIndex;
            if (!isVowel(word.charAt(i))) {
                nextIndex = i;
            }
        }

        int consonant = 0;
        for (int r = 0; r < n; r++) {
            char c = word.charAt(r);
            if (isVowel(c)) {
                vowels.put(c, vowels.getOrDefault(c, 0) + 1);
            } else {
                consonant++;
            }

            while (consonant > k) {
                char left = word.charAt(l++);
                if (isVowel(left)) {
                    vowels.put(left, vowels.get(left) - 1);
                    if (vowels.get(left) == 0) {
                        vowels.remove(left);
                    }
                } else {
                    consonant--;
                }
            }
            while (l < n && vowels.keySet().size() == 5 && consonant == k) {
                result += next[r] - r;
                char left = word.charAt(l++);
                if (isVowel(left)) {
                    vowels.put(left, vowels.get(left) - 1);
                    if (vowels.get(left) == 0) {
                        vowels.remove(left);
                    }
                } else {
                    consonant--;
                }
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
