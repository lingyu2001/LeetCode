class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        map = {
            1:"",2:"abc",3:"def",4:"ghi",
            5:"jkl",6:"mno",7:"pqrs",8:"tuv",9:"wxyz"
        }
        dlist = list(digits)
        res = []
        path = ""
        self.helper(map, dlist, 0, res, path)
        return res
    def helper(self, map, dlist, start, res, path):
        if start >= len(dlist):
            if path != "":
                res.append(path)
            return;
        options = map[int(dlist[start])]
        for c in options:
            path += c
            self.helper(map, dlist, start + 1, res, path)
            path = path[:len(path) - 1]
