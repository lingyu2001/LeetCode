class TrieNode:
    def __init__(self):
            self.children = [None] * 10
class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, num):
        node = self.root
        num_str = str(num)
        for d in num_str:
            idx = int(d)
            if not node.children[idx]:
                node.children[idx] = TrieNode()
            node = node.children[idx]
        
    def find_longest_prefix(self, num):
        node = self.root
        res = 0
        num_str = str(num)
        for d in num_str:
            idx = int(d)
            if node.children[idx]:
                res += 1
                node = node.children[idx]
            else:
                return res
        return res
class Solution(object):

    def longestCommonPrefix(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: int
        """
        res = 0
        # insert nums in arr1 to trie
        trie = Trie()
        for num in arr1:
            trie.insert(num)
        
        # find the longest common prefix in arr2
        for num in arr2:
            longest_prefix = trie.find_longest_prefix(num)
            res = max(res, longest_prefix)
        return res
    
    