class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int n = sb.length();
        for (int i = 0; i < n / 2; i++) {
            if (sb.charAt(i) != sb.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
