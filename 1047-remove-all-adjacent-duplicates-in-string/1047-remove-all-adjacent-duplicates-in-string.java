class Solution {
    public String removeDuplicates(String s) {
        // iterate each character in string s
        // if the stack is empty, add char c
        // else 
            // compare the top element to char c
            // if ==, then pop the top element, c = next character
            // if !=, add char c to the stack
        // end iteration
        // turn the string in stack into string
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else{
                char top = stack.peek();
                if (top == chars[i]) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        String ret = "";
        while (!stack.isEmpty()) {
            ret = stack.pop() + ret;
        }
        return ret;
    }
}