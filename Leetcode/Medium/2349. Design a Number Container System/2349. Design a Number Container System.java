class NumberContainers {

    private Map<Integer, Integer> container;
    private Map<Integer, Set<Integer>> count;

    public NumberContainers() {
        container = new HashMap<>();
        count = new HashMap<>();
    }

    public void change(int index, int number) {
        if (this.container.containsKey(index)) {
            int prev = this.container.get(index);
            Set<Integer> indices = count.get(prev);
            indices.remove(index);
            count.put(prev, indices);
        }
        this.container.put(index, number);
        Set<Integer> indices = count.getOrDefault(number, new TreeSet<>());
        indices.add(index);
        count.put(number, indices);
    }

    public int find(int number) {
        if (!count.containsKey(number)) {
            return -1;
        }
        TreeSet<Integer> indices = (TreeSet<Integer>) count.get(number);
        if (indices.isEmpty()) {
            return -1;
        }
        return indices.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
