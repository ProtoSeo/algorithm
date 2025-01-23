class MinStack {

    private PriorityQueue<Integer> minimum;
    private Map<Integer, Integer> count;
    private Deque<Integer> stk;

    public MinStack() {
        this.minimum = new PriorityQueue<>();
        this.count = new HashMap<>();
        this.stk = new ArrayDeque<>();
    }

    public void push(int val) {
        minimum.add(val);
        count.put(val, count.getOrDefault(val, 0) + 1);
        stk.addLast(val);
    }

    public void pop() {
        int val = stk.pollLast();
        count.put(val, count.get(val) - 1);
    }

    public int top() {
        return stk.peekLast();
    }

    public int getMin() {
        int result = 0;
        while (!minimum.isEmpty()) {
            result = minimum.peek();
            if (count.get(result) > 0) {
                break;
            }
            minimum.poll();
        }
        return result;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
