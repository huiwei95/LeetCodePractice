/**
344. Reverse String

Note: using two pointers(a left pointer and a right pointers) and swap them.
*/
class Solution {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left ++, right --) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}





/**
541. Reverse String II

Note: The difficult this is that how to reverse in correct positon.
*/
class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        
        for (int i = 0; i < a.length; i += 2 * k) {
            int start = i;
            int end = Math.min(start + k - 1, a.length - 1); // 这里是判断尾数够不够k个来取决end指针的位置
            while (start < end) {
                char temp = a[start];
                a[start++] = a[end];
                a[end--] = temp;
            }
        }
        return new String(a);
    }
}





/**
剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20


示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
*/
public static String replaceSpace(String s) {
    if (s == null)
        return null;
    
    // String不能被修改，打算修改字符串，使用StringBuilder
    StringBuilder sb = new StringBuilder();
    // 使用 sb 逐个复制 s ，碰到空格则替换，否则直接复制
    for (int i = 0; i < s.length(); i ++) {
        if (s.charAt(i) == ' ') {
            sb.append("%20");  
        } else {
            sb.append(s.charAt(i));
        }
    }
    return sb.toString();
}





/**
151. Reverse Words in a String

Note: Using two pointers
*/
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int right = s.length() - 1; right >= 0; right --) {
            if (s.charAt(right) != ' ') {
                int left = right;
                while (left - 1 >= 0 && s.charAt(left - 1) != ' ') {
                    left --;
                }
                sb.append(s.substring(left, right + 1));
                sb.append(' ');
                right = left;
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}





/**
题目：剑指Offer58-II.左旋转字符串

*/
class Solution {
    public String reverseLeftWords(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }
     public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
            }
        }
}

//解法二：空间复杂度：O(1)。用原始数组来进行反转操作
//思路为：先整个字符串反转，再反转前面的，最后反转后面 n 个
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, chars.length - 1 - n);
        reverse(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }
}