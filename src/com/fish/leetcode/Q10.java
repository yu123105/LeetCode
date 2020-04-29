package com.fish.leetcode;

import java.util.Objects;

/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2020/4/28
 * Stay curious, stay childlike.
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
public class Q10 {


    /*



    public static boolean isMatch1(String s, String p) {
        char DOT = '.';
        char STAR = '*';
        if (Objects.equals(p, ".*")) {
            return true;
        }
        if (s == null || Objects.equals(s, "")) {
            return p == null || Objects.equals(p, "");
        }
        //特殊情况，空，单个字符
        char[] pChar = p.toCharArray();
        char[] sChar = s.toCharArray();
        //碰到*时开启标志
        int i = 0, j = 0, pl = pChar.length, sl = sChar.length, markPIndex = -1;
        while (j < sl) {
            char[] op = readP(pChar, i);
            if(op == null){
                if (markPIndex > 0) {
                    // 回到原来的位置
                    j++;
                    i = markPIndex;
                    continue;
                } else {
                    return false;
                }
            }
            i += op.length;
            char currentSChar = sChar[j];
            if (op.length == 1) {
                char currentPChar = op[0];
                // 单个字母的情况
                if (currentPChar == currentSChar || currentPChar == DOT) {
                    j++;
                } else {
                    if (markPIndex > 0) {
                        j++;
                        // 回到原来的位置
                        i = markPIndex;
                    } else {
                        return false;
                    }
                }
            } else {
                if (op[0] != '.') {
                    // [a-z]*的情况,可能为[a-z]{n,}的情况
                    int minSCount = 0;
                    int temp;
                    while ( (temp = readSameOp(pChar, i, op[0]) )!= 0){
                        i += temp;
                        if(temp == 1){
                            minSCount++;
                        }
                    }
                    while (j < sChar.length && sChar[j] == op[0]) {j++; minSCount--;}
                    if(minSCount > 0){
                        if (markPIndex > 0) {
                            // 回到原来的位置
                            i = markPIndex;
                        } else {
                            return false;
                        }
                    }
                } else {
                    //记录位置，匹配错误可以重新匹配
                    markPIndex = i;
                }
            }
        }
        return i == pl && j == sl || pl - i == 2 && pChar[pl - 2] == DOT && pChar[pl - 1] == STAR;
    }

    public static int readSameOp(char[] pChar, int startIndex, char sample){
        if(startIndex < pChar.length && pChar[startIndex] == sample){
            if(startIndex + 1 < pChar.length && pChar[startIndex + 1] == '*'){
                return 2;
            } else {
                return 1;
            }
        }
        return 0;
    }*/
    public static boolean isMatch(String s, String p){
        //特殊情况，空，单个字符
        char[] pChar = p.toCharArray();
        char[] sChar = s.toCharArray();
        return subMatch(sChar, pChar, 0, 0);
    }

    public static boolean subMatch(char[]sChar, char[]pChar, int startS, int startP){
        char[] op = readP(pChar, startP);
        if(op == null){
            return startS == sChar.length;
        }
        startP += op.length;
        if(startS >= sChar.length && op.length == 1){
            return false;
        }
        boolean match;
        if (op.length == 1) {
            match = startS < sChar.length && (op[0] == sChar[startS] || op[0] == '.') && subMatch(sChar, pChar, ++startS, startP);
        } else {
            if (op[0] != '.') {
                while (!(match = subMatch(sChar, pChar, startS, startP))) {
                    if(startS >=  sChar.length || op[0] != sChar[startS]){
                        break;
                    }
                    startS++;
                }
            } else {
                while (!(match = subMatch(sChar, pChar, startS, startP)) && startS < sChar.length) startS++;
            }
        }
        return match;
    }

    public static char[] readP(char[] pChar, int startIndex){
        if(startIndex + 1 < pChar.length){
            if(pChar[startIndex + 1] == '*'){
                return new char[]{pChar[startIndex], pChar[startIndex + 1]};
            } else {
                return new char[]{pChar[startIndex]};
            }
        } else if(startIndex < pChar.length){
            return new char[]{pChar[startIndex]};
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        /*System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("adedefghd", "a.*efg.*d*"));
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("aaa", ".*a*a.*a"));*/
        System.out.println(isMatch("", "c*"));
        System.out.println(isMatch("", ""));
        System.out.println(isMatch("", ".*"));
        //System.out.println(isMatch("mississippi", "mis*is*ip*."));

    }

}