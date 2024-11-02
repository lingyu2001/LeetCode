class Solution:
    def isNumber(self, s: str) -> bool:
        # +，-只出现在idx=0，或者e的后面
        # e， E只能出现一次， 并且必须要前面要有数字，后面也要有数字，后面不能有.
        # . 只能出现1次
        seen_exp = seen_digit = seen_dot = False
        for i, c in enumerate(s):
            if s[i].isdigit():
                seen_digit = True
            elif s[i] in ['e', 'E']:
                if seen_exp or not seen_digit:
                    return False
                seen_exp = True
                seen_digit = False
            elif s[i] in ['+', '-']:
                if i > 0 and s[i - 1] not in ['e', 'E']:
                    return False
            elif s[i] == '.':
                if seen_exp or seen_dot:
                    return False
                seen_dot = True
            else:
                return False
        return seen_digit