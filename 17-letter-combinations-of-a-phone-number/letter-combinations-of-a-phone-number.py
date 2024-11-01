class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        num_to_chars = {'2':"abc", '3':"def",'4':"ghi", '5':"jkl",'6':"mno",'7':"pqrs", '8':"tuv", '9':"wxyz"}
        res = []
        if len(digits) == 0:
            return res
        path = ""
        self.helper(digits, 0, path, res, num_to_chars)
        return res
    
    def helper(self, digits, idx, path, res, num_to_chars):
        if idx >= len(digits):
            res.append(path)
            return
        for c in num_to_chars[digits[idx]]:
            path += c
            self.helper(digits, idx + 1, path, res, num_to_chars)
            path = path[:-1]
        
