/**
20. Valid Parentheses

Note: use stack to solve it. peek() is read but not remove. 
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
        char c;
        for (int i = 0; i < s.length(); i ++) {
            c = s.charAt(i);
            // 遇到左括号
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号 return false
            // 第二种情况：遍历字符串匹配的过程中，发现栈里没有我们要匹配的字符。所以return false
            } else if (stack.empty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        // 第一种情况：此时我们已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false，否则就return true
        return stack.empty();
    }
}





/**
1047. Remove All Adjacent Duplicates In String

Note: use deque to solve
这道题主要是用栈来写。我们可以用deque来模拟栈。在遍历S中的字符的时候，如果栈里面没有数或者跟栈里面的数字不一样那么我们就直接push进去，如果我们发现遍历的字符跟栈里面的字符一样，则用pop弹出来。最后在栈里面的就是答案。但是我们需要转化为String的形式。
*/
class Solution {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        
        char c;
        for (int i = 0; i < s.length(); i ++) {
            c = s.charAt(i);
            if (deque.isEmpty() || deque.peek()!= c) {
                deque.push(c);
            } else {
                deque.pop();
            }
        }
        
        String str = "";
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }
}





/**
150. Evaluate Reverse Polish Notation

Note： 这道题用stack做。需要注意的是除法算法的时候需要pop出来的第二数除以第一个数字。还有就是减法需要注意
*/
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}