class Solution:
    def ipToCIDR(self, ip: str, n: int) -> List[str]:
        def ip_to_bin(ip):
            return "".join(["{:08b}".format(i) for i in map(int, ip.split("."))])
        def bin_to_ip(b):
            return ".".join([str(int(b[i:i+8],2)) for i in range(0, 32, 8)])

        ans = []
        cur_ip = ip_to_bin(ip)

        while n > 0:
            last_one = 31
            while last_one >= 0 and cur_ip[last_one] == '0':
                last_one -= 1
            trail_zero = 31 - last_one
            # fix trail_zero
            while n < 2 ** trail_zero:
                trail_zero -= 1
            # update cur_ip, ans, n
            ans.append(f"{bin_to_ip(cur_ip)}/{32-trail_zero}")
            n -= 2 ** trail_zero
            cur_ip = "{:032b}".format(int(cur_ip,2) + 2 ** trail_zero)
        return ans

            #ans.append(f"{bin_to_ip(cur_ip)}/{32 - trailing_zero}")
            # n -= 2 ** trailing_zero
            # cur_ip = "{:032b}".format(int(cur_ip, 2) + 2 ** trailing_zero)