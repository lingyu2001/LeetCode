class TrieNode():
    def __init__(self):
        self.cnt = 0
        self.children = [None] * 26
    
class Trie():
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        word_str = str(word)
        node = self.root
        for w in word_str:
            idx = ord(w) - ord('a')
            if not node.children[idx]:
                node.children[idx] = TrieNode()
            node.children[idx].cnt += 1
            node = node.children[idx]

        
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        trie = Trie()
        for s in strs:
            trie.insert(s)
        node = trie.root
        res = ""
        while node:
            last_node = node
            for i in range(26):
                if node.children[i] and node.children[i].cnt == len(strs):
                    res += chr(ord('a') + i)
                    node = node.children[i]
                    break
            if node == last_node:
                break
        return res
