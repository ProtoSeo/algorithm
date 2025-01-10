class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (char c : strs[0].toCharArray()) {
            String temp = prefix + c;
            for (String str : strs) {
                if (!str.startsWith(temp)) {
                    return prefix;
                }
            }
            prefix += c;
        }
        return prefix;
    }
}
