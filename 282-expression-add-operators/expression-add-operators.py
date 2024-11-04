class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.string = []
        self.res = []
        self.helper(num, target, 0, 0, 0, 0)
        return self.res
    def helper(self, num, target, idx, prev_op, cur_op, val):
        if idx == len(num):
            if val == target and cur_op == 0:
                self.res += ["".join(self.string[1:])]
            return 
        cur_op = cur_op * 10 + int(num[idx])
        # check to avoid 1*05
        if cur_op > 0:
            self.helper(num, target, idx + 1, prev_op, cur_op, val)
        # addition
        self.string += ['+']
        str_ops = str(cur_op)
        self.string += [str_ops]
        self.helper(num, target, idx + 1, cur_op, 0, val + cur_op)
        self.string.pop()
        self.string.pop()
        # substraction
        if self.string:
            self.string += ['-']
            self.string += [str_ops]
            self.helper(num, target, idx + 1, -cur_op, 0, val - cur_op)
            self.string.pop()
            self.string.pop()
            # multiply
            self.string += ['*']
            self.string += [str_ops]
            self.helper(num, target, idx + 1, prev_op * cur_op, 0, val - prev_op + prev_op * cur_op)
            self.string.pop()
            self.string.pop()
