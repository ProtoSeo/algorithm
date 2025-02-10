class Solution {
    public String clearDigits(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) && !stk.isEmpty()) {
                stk.pollLast();
                continue;
            }
            stk.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stk) {
            sb.append(c);
        }
        return sb.toString();
    }
}
