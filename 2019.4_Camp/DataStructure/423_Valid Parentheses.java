public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        char[] jwj = new char[]{'(', '{', '[', ')', '}', ']'};
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            for (int i = 0; i < 6; i++) {
                if (c == jwj[i] && i < 3) {
                    stack.push(c);
                } else if (c == jwj[i]) {
                    if (stack.isEmpty() || stack.pop() != jwj[i - 3]) {
                    return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
}


public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
