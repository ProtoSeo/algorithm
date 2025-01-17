class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }
        Map<Character, Integer> target = createTarget(t);
        Map<Character, Integer> counts = new HashMap<>();
        int l = 0;
        int r = 0;
        String answer = "";
        while (l <= r) {
            boolean isContains = true;
            for (char k : target.keySet()) {
                if (counts.getOrDefault(k, 0) < target.get(k)) {
                    isContains = false;
                    break;
                }
            }
            if (isContains) {
                if (answer.equals("") || answer.length() > r - l) {
                    answer = s.substring(l, r);
                }
                char c = s.charAt(l++);
                counts.put(c, counts.get(c) - 1);
                continue;
            }
            if (r + 1 > m) {
                break;
            }
            char c = s.charAt(r++);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return answer;
    }

    public Map<Character, Integer> createTarget(String t) {
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        return target;
    }
}
