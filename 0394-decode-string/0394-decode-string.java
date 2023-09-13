class Solution {
    Stack<StringBuilder> stackSB = new Stack<>();
    Stack<Integer> stackNum = new Stack<>();
    StringBuilder str = new StringBuilder();
    int num = 0;
    public String decodeString(String s) {
        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') num = num * 10 + c - '0';
            else if (c == '[') {
                stackSB.push(str);
                str = new StringBuilder();
                stackNum.push(num);
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = str;
                str = stackSB.pop();
                int cnt = stackNum.pop();
                for (int i = 0; i < cnt; i++) {
                    str.append(temp);
                }
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}