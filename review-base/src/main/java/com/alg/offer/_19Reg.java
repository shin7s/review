package com.alg.offer;

public class _19Reg {
    public static void main(String[] args) {

        System.out.println(match("".toCharArray(), ".".toCharArray()));    //false
        System.out.println(match("".toCharArray(), ".*".toCharArray()));    //true
        System.out.println(match("".toCharArray(), "a".toCharArray()));    //false
        System.out.println(match("".toCharArray(), "a*".toCharArray()));    //true

        System.out.println(match("a".toCharArray(), ".".toCharArray()));    //true
        System.out.println(match("a".toCharArray(), "b*a".toCharArray()));    //true
        System.out.println(match("a".toCharArray(), "b*".toCharArray()));    //false

        System.out.println(match("aaa".toCharArray(), "ab*ac*a".toCharArray()));    //true
        System.out.println(match("aaa".toCharArray(), "a*".toCharArray()));         //true
        System.out.println(match("aaa".toCharArray(), ".*".toCharArray()));         //true
        System.out.println(match("aaa".toCharArray(), "aaa".toCharArray()));       //true
        System.out.println(match("aaa".toCharArray(), "aa.a".toCharArray()));       //false
        System.out.println(match("aaa".toCharArray(), "aa..".toCharArray()));       //false
        System.out.println(match("aaa".toCharArray(), "ab*a".toCharArray()));       //false

    }

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchRecursive(str, pattern, 0, 0);

    }

    private static boolean matchRecursive(char[] str, char[] pattern, int si, int pi) {

        if (si == str.length && pi >= pattern.length)
            return true;

        if ((si < str.length && pi >= pattern.length)) {
            return false;
        }

        if (pi < pattern.length - 1 && pattern[pi + 1] == '*') {
            if ((si < str.length && str[si] == pattern[pi]) || (pi < pattern.length && pattern[pi] == '.')) {
                return
                        //模式往后移动2位
                        matchRecursive(str, pattern, si, pi + 2) ||

                                matchRecursive(str, pattern, si + 1, pi + 2) ||
                                matchRecursive(str, pattern, si + 1, pi);
            } else {
                return matchRecursive(str, pattern, si, pi + 2);
            }
        }

        if ((si < str.length && str[si] == pattern[pi]) || (pi < pattern.length && pattern[pi] == '.')) {
            return matchRecursive(str, pattern, si + 1, pi + 1);
        }
        return false;
    }

}
