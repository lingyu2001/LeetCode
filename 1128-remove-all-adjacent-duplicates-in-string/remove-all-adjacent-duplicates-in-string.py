class Solution(object):
    def removeDuplicates(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        for c in s:
            if stack:
                if c == stack[-1]:
                    stack.pop()
                    continue
            stack.append(c)
        return "".join([c for c in stack])

            