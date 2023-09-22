class Node {
    int key, val;
    Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    int capa;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        map = new HashMap<>();
        capa = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            removeFromList(map.get(key));
            addToList(map.get(key));
        } else return -1;
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = new Node(key, value);
            removeFromList(map.get(key));
            map.put(key, node);
            addToList(node);
        } else {
            if (map.size() >= capa) {
                map.remove(tail.prev.key);
                removeFromList(tail.prev);
            } 
            Node node = new Node(key, value);
            addToList(node);
            map.put(key, node);
        }
    }

    public void removeFromList(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        n.next = null;
        n.prev = null;
    }

    public void addToList(Node n) {
        Node next = head.next;
        n.next = next;
        next.prev = n;
        head.next = n;
        n.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */