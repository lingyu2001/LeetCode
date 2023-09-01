class LRUCache {
    
    private class Node {
        int key, val;
        Node prev,next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head,tail;
    int size;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            Node n = map.get(key);
            removeFromList(n);
            addToList(n);
            return n.val;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeFromList(map.get(key));
            map.remove(key);
        } 
        if (map.size() >= size) {
            map.remove(tail.prev.key);
            removeFromList(tail.prev);
        }
        Node node = new Node(key,value);
        addToList(node);
        map.put(key, node);
    }
    
    public void removeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addToList(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */