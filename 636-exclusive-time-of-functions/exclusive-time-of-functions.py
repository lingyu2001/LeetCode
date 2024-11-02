class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        ans = [0] * n
        stack = []
        helper = lambda log: (int(log[0]), log[1], int(log[2]))
        logs = [helper(log.split(':')) for log in logs]
        for i, (l1, l2, l3) in enumerate(logs):
            if l2 == "start":
                if stack:
                    ans[stack[-1][0]] += (l3 - stack[-1][1])
                stack.append([l1,l3])
            else:
                id, start = stack.pop()
                ans[id] += (l3 - start + 1)
                if stack:
                    stack[-1][1] = l3 + 1
        return ans