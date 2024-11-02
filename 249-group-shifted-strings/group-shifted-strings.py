class Solution(object):
    def get_hash(self, s):
        key = []
        for a, b in zip(s, s[1:]):
            key.append( str((ord(b) - ord(a)) % 26) + ',' )
        return "".join(key)
    def groupStrings(self, strings):
        """
        :type strings: List[str]
        :rtype: List[List[str]]
        """
        table = defaultdict(list)
        # key: how to design hash
        for s in strings:
            hash = self.get_hash(s)
            table[hash].append(s)
        return table.values()