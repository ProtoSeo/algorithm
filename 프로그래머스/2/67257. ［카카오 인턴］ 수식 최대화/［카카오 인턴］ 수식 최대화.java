import java.util.*;

class Solution {
    String[] orders = {"*-+", "*+-", "+-*", "+*-", "-*+", "-+*"};
    List<Long> numbers = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    public long solution(String expression) {
        init(expression);
        long answer = -1;
        for (String order : orders) {
            List<Long> nowNumbers = new ArrayList<>(numbers);
            List<Character> nowOperators = new ArrayList<>(operators);
            for (int j = 0; j < 3; j++) {
                Deque<Long> numberStack = new ArrayDeque<>();
                Deque<Character> operatorStack = new ArrayDeque<>();
                char c = order.charAt(j);
                
                numberStack.add(nowNumbers.get(0));
                for (int k = 1; k < nowNumbers.size(); k++) {
                    numberStack.push(nowNumbers.get(k));
                    operatorStack.push(nowOperators.get(k - 1));
                    if (operatorStack.getFirst() == c) {
                        long r = numberStack.pop();
                        long l = numberStack.pop();
                        numberStack.push(calculate(l, r, operatorStack.pop()));
                    }
                }
                nowNumbers = new ArrayList<>();
                nowOperators = new ArrayList<>();
                while (!numberStack.isEmpty()) {
                    nowNumbers.add(numberStack.pollLast());
                }
                while (!operatorStack.isEmpty()) {
                    nowOperators.add(operatorStack.pollLast());
                }
            }
            answer = Math.max(Math.abs(nowNumbers.get(0)), answer);
        }
        return answer;
    }
    
    private long calculate(long l, long r, char c) {
        if (c == '*') {
            return l * r;
        } else if (c == '+') {
            return l + r;
        }
        return l - r;
    }
    
    private void init(String expression) {
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '*' || c == '+' || c == '-') {
                numbers.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operators.add(c);
                continue;
            }
            sb.append(c);
        }
        numbers.add(Long.parseLong(sb.toString()));
    }
}