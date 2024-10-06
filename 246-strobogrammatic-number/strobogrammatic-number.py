class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        sbg = ["0","1", "8"]
        i = 0
        j = len(num) -1
        num = list(num)
        while i <= j:
            if num[i] == num[j] :
                if num[i] in sbg:
                    i += 1
                    j -= 1
                    continue
                else:
                    return False
            else:
                if (num[i] == "6" and num[j] == "9") or (num[i] == "9" and num[j] == "6"):
                    i += 1
                    j -= 1
                    continue
                else:
                    return False
        return True
            
        