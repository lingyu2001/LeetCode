class TrieNode():
    def __init__(self):
        self.children = [None] * 10

class Trie():
    def __init__(self):
        self.root = TrieNode()

    def insert(self, num):
        num_str = str(num)
        p = self.root
        for c in num_str:
            if not p.children[int(c)]:
                p.children[int(c)] = TrieNode()
            p = p.children[int(c)]

    def find(self, target):
        target_str = str(target)
        p = self.root
        idx = 0
        while p and idx < len(target_str):
            if p.children[int(target_str[idx])]:
                p = p.children[int(target_str[idx])]
                idx += 1
            else:
                break
        return idx


class Solution(object):
    def longestCommonPrefix(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: int
        """
        trie = Trie()
        for n in arr1:
            trie.insert(n)
        res = 0
        for n in arr2:
            res = max(res,trie.find(n))
        return res
        