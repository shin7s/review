package com.leetcode.solution;

import java.util.Arrays;

public class _0032Par {
    public static void main(String[] args) {

        //System.out.println(longestValidParentheses(")()())"));
        //System.out.println(longestValidParentheses("("));
        //System.out.println(longestValidParentheses("(()"));
        //System.out.println(longestValidParentheses(")()"));
        //System.out.println(longestValidParentheses("(()))"));
        System.out.println(longestValidParentheses("(()()"));
        System.out.println(longestValidParentheses("(()()((())))"));
    }
    final static int L = -1, R = -2;

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int len = s.length(), m = 0, i, j = 0, k = len;
        int[][] dp = new int[len][len];
        int[] cv = new int[len], next = new int[len];
        for (i = 0; i < len; i++) next[i] = cv[i] = (s.charAt(i) == '(' ? L : R);//conve
        while (true) {
            len = k;
            k = 0;
            cv = next;//init
            System.out.println(Arrays.toString(Arrays.copyOfRange(cv,0,len)));
            for (i = 0; i < len; ) {
                if (cv[i] == L) {
                    int sum = 0;
                    for (j = i + 1; j < len; j++) {
                        if (cv[j] == R) {
                            sum += 1;
                            next[k] = sum;
                            k++;
                            i = j + 1;
                            break;
                        } else if (cv[j] == L) {
                            for (int h = i; h < j; h++, k++) {
                                next[k] = cv[h];
                            }
                            i = j;
                            break;
                        } else if (cv[j] > 0) {
                            sum += cv[j];
                        }
                    }
                    if(j==len) {

                        break;
                    } else if (i < j) {
                        for (int h = i; h < j; h++, k++) {
                            next[k] = cv[h];
                        }
                        i = j;
                    }
                } else if(cv[i]>0){
                    int sum=cv[i];
                    for (j = i+1; j < len; j++) {
                        if(cv[j]>0){
                            sum+=cv[j];
                        }else{
                            next[k]=sum;
                            k++;
                            i=j;
                            break;
                        }
                    }
                    if(i<j){
                        next[k]=sum;
                        k++;
                        i=j;
                    }
                } else {
                    next[k++] = cv[i++];
                }
            }
            if (k == len) break;
        }
        for (i = 0; i < len; i++) m = Math.max(m, cv[i]);
        return m < 0 ? 0 : m*2;
    }
}
