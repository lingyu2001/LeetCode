class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        '''
        1. iterate the string, and remove all unmatched )
            balance, left_parethesis_seen
        2. iterate the string, and remove all unmatched (
        '''
        lst = list(s)
        balance = 0
        matched = 0
        first_pass = []
        second_pass = []
        # remove all unmatched )
        for c in lst:
            if c == '(':
                balance += 1
            elif c == ')':
                if balance == 0:
                    continue
                else:
                    balance -= 1
                    matched += 1
            first_pass.append(c)
        # remove all unmatched (
        for c in first_pass:
            if c == '(':
                if matched == 0:
                    continue
                else:
                    matched -= 1
            second_pass.append(c)
        return "".join(second_pass)