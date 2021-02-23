package com.fish.leetcode;

import java.util.Stack;

/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2021/2/23
 * Stay curious, stay childlike.
 *
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
 

提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
public class Q20 {

    public static void main(String[] args) {
        System.out.println(Q20.isValid("{[]}"));
    }


    public static boolean isValid(String s) {
        char[] charArrays = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0, l = charArrays.length; i < l; i++){
            char a = charArrays[i];
            if(a == '(' || a == '[' || a == '{'){
                stack.push(a);
            } else {
                if(stack.isEmpty()){
                    return false;
                } else {
                    char b = stack.pop();
                    if(a == ')' && b != '('){
                        return false;
                    }
                    if(a == '}' && b != '{'){
                        return false;
                    }
                    if(a == ']' && b != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}