class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ", 0);
        StringBuilder result = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].length() == 0) {
                continue;
            }
            result.append(str[i]).append(' ');
        }
        return result.toString().trim();
    }
}
