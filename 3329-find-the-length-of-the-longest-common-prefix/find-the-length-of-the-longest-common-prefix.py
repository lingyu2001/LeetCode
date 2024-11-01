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

    def find(self, num):
        node = self.root
        num_str = str(num)
        len = 0

        for digit in num_str:
            idx = int(digit)
            if node.children[idx]:
                # Increase length if the current digit matches
                len += 1
                node = node.children[idx]
            else:
                # Stop if no match for the current digit
                break
        return len


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
        