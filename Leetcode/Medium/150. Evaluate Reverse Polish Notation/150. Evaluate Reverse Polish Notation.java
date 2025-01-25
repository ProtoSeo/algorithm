class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")) {
                int b = stk.pollLast();
                int a = stk.pollLast();
                if (token.equals("+")) {
                    stk.addLast(a + b);
                } else if (token.equals("*")) {
                    stk.addLast(a * b);
                } else if (token.equals("/")) {
                    stk.addLast(a / b);
                } else if (token.equals("-")) {
                    stk.addLast(a - b);
                }
                continue;
            }
            stk.addLast(Integer.parseInt(token));
        }
        return stk.pollLast();
    }
}
