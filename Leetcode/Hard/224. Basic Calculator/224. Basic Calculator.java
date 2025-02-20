class Solution {
    public int calculate(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = s.length();
        int sign = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stk.addLast(result);
                stk.addLast(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result * stk.pollLast() + stk.pollLast();
            }
        }
        return result;
    }
}
