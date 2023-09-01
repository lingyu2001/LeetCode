class LRUCache {

    private class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        // Move the accessed node to the head
        Node node = map.get(key);
        removeFromList(node);
        addToList(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Remove the old value
            removeFromList(map.get(key));
            map.remove(key);
        }

        // Check if we're over capacity
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            removeFromList(tail.prev);
        }

        // Add the new node to the head of the list and to the map
        Node node = new Node(key, value);
        addToList(node);
        map.put(key, node);
    }

    private void removeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToList(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
