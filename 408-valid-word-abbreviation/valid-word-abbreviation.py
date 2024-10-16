class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        # remove all spaces in word
        word = [w for w in word if w != ' ']
        p = 0
        q = 0
        # compare if word matches abbr
        while p < len(word) and q < len(abbr):
            # assume q is pointing at a letter in abbr 
            if word[p] == abbr[q]:
                q += 1
                p += 1
            # if q is pointing at a digit
            elif abbr[q].isnumeric():
                num = 0
                if abbr[q] == '0':
                    return False
                # convert the str to int
                while q < len(abbr) and abbr[q].isnumeric():
                    num = num * 10 + int(abbr[q])
                    q += 1
                p = p + num
            else:
                # q and p just dont match
                return False
        return p == len(word) and q == len(abbr)