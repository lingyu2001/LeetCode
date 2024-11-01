class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        paths = path.split("/")
        paths = [p for p in paths if p]
        res = []
        for content in paths:
            if content == '.':
                continue
            elif content == '..':
                if res:
                    res = res[:-1]
            else:
                res.append(content)
        final_str ="/" + "/".join(res)
        return final_str