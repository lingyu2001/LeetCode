class Trie {
    Node root;
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Node cur = startsWithNode(word);
        return cur != null && cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = startsWithNode(prefix);
        return cur != null;
    }
    
    public Node startsWithNode(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) return null;
            cur = cur.children[c - 'a'];
        }
        return cur;
    }
}

class Node {
    char c;
    Node[] children;
    boolean isWord;
    
    public Node(char c) {
        this.c = c;
        this.isWord = false;
        this.children = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */