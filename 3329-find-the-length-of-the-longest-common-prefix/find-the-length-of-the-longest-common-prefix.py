class TrieNode:
    def __init__(self):
        self.children = [None] * 10

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, num):
        num_str = str(num)
        p = self.root
        for c in num_str:
            if not p.children[int(c)]:
                p.children[int(c)] = TrieNode()
            p = p.children[int(c)]
    def find_longest(self, target):
        p = self.root
        i = 0
        t_str = str(target)
        while i < len(t_str) and p:
            if p.children[int(t_str[i])]:
                p = p.children[int(t_str[i])]
                i += 1
            else:
                break
        return i
class Solution(object):
    def longestCommonPrefix(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: int
        """
        trie = Trie()
        res = 0
        for i in arr1:
            trie.insert(i)
        for i in arr2:
            cur_val = trie.find_longest(i)
            res = max(res, cur_val)
        return res