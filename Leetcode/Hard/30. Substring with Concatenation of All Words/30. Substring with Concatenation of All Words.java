class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int m = words[0].length();
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - (n * m) + 1; i++) {
            Map<String, Integer> now = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String str = s.substring(j * m + i, (j + 1) * m + i);
                now.put(str, now.getOrDefault(str, 0) + 1);
            }
            if (counts.equals(now)) {
                result.add(i);
            }
        }
        return result;
    }
}
