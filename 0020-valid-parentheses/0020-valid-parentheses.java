class Solution {
    public boolean isValid(String s) {
        // str --> char[] arr
        // stack
        // iterate the array
            // if arr[i] = ( or [ or {
                 // s.add(arr[i])
            // else
                // char c = s.poll();
                // see if c and arr[i] are match, if not, return false
        // return s.isEmpty()
        char[] arr = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            } else {
                // ) or ] or }
                char c = '1';
                if (stack.size() != 0)
                    c = stack.pop();
                else 
                    return false;
                // see if they are match
                if ((c == '(' && arr[i] == ')') ||(c == '[' && arr[i] == ']') || (c == '{' && arr[i] == '}'))
                    continue;
                else 
                    return false;
            }
        }
        return stack.isEmpty();
    }
}