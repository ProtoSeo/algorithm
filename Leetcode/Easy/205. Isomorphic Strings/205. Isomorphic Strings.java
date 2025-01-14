class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (!sMap.containsKey(sc) && !tMap.containsKey(tc)) {
                sMap.put(sc, tc);
                tMap.put(tc, sc);
            }
            if (sMap.getOrDefault(sc, '\0') == tc  && tMap.getOrDefault(tc, '\0') == sc) {
                continue;
            }
            return false;
        }
        return true;
    }
}
