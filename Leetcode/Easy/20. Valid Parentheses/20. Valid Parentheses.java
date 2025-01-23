class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stk.addLast(c);
                continue;
            }
            if (!stk.isEmpty() && ((stk.peekLast() == '(' && c == ')') ||
                    (stk.peekLast() == '{' && c == '}') ||
                    (stk.peekLast() == '[' && c == ']'))) {
                stk.pollLast();
                continue;
            }
            return false;
        }
        return stk.isEmpty();
    }
}
