class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        '''
        1. iterate the string, and remove all unmatched )
            balance, left_parethesis_seen
        2. iterate the string, and remove all unmatched (
        '''
        lst = list(s)
        balance = 0
        for idx, c in enumerate(lst):
            if c == '(':
                balance += 1
            elif c == ')':
                if balance > 0:
                    balance -= 1
                else:
                    lst[idx] = ' '
        i = len(lst) - 1
        i = len(lst) - 1
        while i >= 0 and balance > 0:
            if lst[i] == '(':
                lst[i] = ' '
                balance -= 1
            i -= 1
        lst = [c for c in lst if c != ' ']
        return "".join(lst)