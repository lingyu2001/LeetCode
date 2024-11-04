# Python Solution
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        maxans = 0
        stack = []
        stack.append(-1)
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                if stack:
                    stack.pop()
                # If, while popping the element, the stack becomes empty, 
                # we will push the current element's index onto the stack. 
                # In this way, we can continue to calculate the length of the 
                # valid substrings and return the length of the longest valid string at the end.
                if not stack:
                    stack.append(i)
                else:
                    maxans = max(maxans, i - stack[-1])
        return maxans