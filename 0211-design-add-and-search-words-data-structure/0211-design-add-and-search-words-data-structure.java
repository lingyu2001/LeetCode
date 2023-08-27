class WordDictionary {

    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

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
        return helper(word, 0, root);
    }
    
    public boolean helper(String word, int index, Node cur) {
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (Node temp : cur.children) {
                    if (temp != null && helper(word, i + 1, temp)) return true;
                }
                return false;
            }
            if (cur.children[word.charAt(i) - 'a'] == null) return false;
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.isWord; 
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