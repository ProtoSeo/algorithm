class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Map<Integer, Node> cache = new HashMap<>();
    Node head;
    Node tail;
    int count;
    int capacity;
    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        this.count = 0;
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            this.moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            this.moveToHead(node);
            return;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        cache.put(key, node);
        this.addNode(node);
        count++;
        if (count > capacity) {
            Node tail = this.popTail();
            cache.remove(tail.key);
            --count;
        }
    }

    private void moveToHead(Node node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private Node popTail() {
        Node node = tail.prev;
        this.removeNode(node);
        return node;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
