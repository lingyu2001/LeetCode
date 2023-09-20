class Node {
    int key,val;
    Node prev, next;

    public Node (int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    int size;
    int capa;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = 0;
        capa = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeFromList(node);
            addToList(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeFromList(map.get(key));
            map.remove(key);
        }
        if (map.size() >= capa) {
            map.remove(tail.prev.key);
            removeFromList(tail.prev);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToList(newNode);
    }

    public void addToList(Node node) {
        Node ori = head.next;
        node.next = ori;
        ori.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void removeFromList(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */