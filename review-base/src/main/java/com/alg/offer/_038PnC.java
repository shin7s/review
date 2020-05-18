package com.alg.offer;

import java.util.Arrays;

public class _038PnC {
    public static void main(String[] args) {
        //p("abcdef".toCharArray());
        //c("abc".toCharArray());
        //c_plus("abc".toCharArray());

        eightQueen();
    }

    public static void eightQueen() {
        int[] columns = new int[8];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = i;
        }

        p_8queen(columns, 0);

        System.out.println(count);
    }
    static int count = 0;

    public static void p_8queen(int[] columns, int index) {

        if (index == columns.length) {
            //判断对角线是否重复
            for (int i = 0; i < columns.length; i++) {
                for (int j = i + 1; j < columns.length; j++) {
                    if (i - j == columns[i] - columns[j] || j - i == columns[i] - columns[j]) {
                        return;
                    }
                }
            }

            ++count;
            System.out.println(Arrays.toString(columns));
            return;
        }

        int temp;
        for (int i = index; i < columns.length; i++) {

            temp = columns[i];
            columns[i] = columns[index];
            columns[index] = temp;

            p_8queen(columns, index + 1);

            temp = columns[i];
            columns[i] = columns[index];
            columns[index] = temp;
        }

    }

    /**
     *
     * @param strs
     */
    public static void c(char[] strs) {
        if (strs == null || strs.length == 0) return;
        for (int i = 1; i <= strs.length; i++) {
            c_re(strs, 0, strs.length, i, '\0', new StringBuilder());
        }
    }

    /**
     *
     * @param strs
     */
    public static void c_plus(char[] strs) {
        if (strs == null || strs.length == 0) return;
        for (int i = 1; i <= strs.length; i++) {
            c_re_plus(strs, 0, i, new StringBuilder());
        }
    }

    /**
     *
     * @param strs
     * @param next
     * @param m
     * @param sb
     */
    public static void c_re_plus(char[] strs, int next, int m, StringBuilder sb) {

        //int n = strs.length - next
        //注意结束条件判断
        if (strs.length - next < m)
            return;

        if (m <= 0) {
            System.out.println(sb.toString());
            return;
        }

        sb.append(strs[next]);
        c_re_plus(strs, next + 1, m - 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        c_re_plus(strs, next + 1, m, sb);
    }

    /**
     * 是否包含
     * @param strs
     * @param begin
     * @param m
     */
    private static void c_re(char[] strs, int begin, int n, int m, char c, StringBuilder sb) {

        //对于n选m个字符
        //存在strs[begin]
        //System.out.print(strs[begin]);

        if (c != '\0') {
            //System.out.print(c);
            sb.append(c);

            if (m <= 0) {
                System.out.println(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        if (m <= 0 || n < m)
            return;
        //System.out.println("\n          (n, m) char:" + "(" + n + "," + m + ") " + strs[begin]);
        //存在分支
        c_re(strs, begin + 1, n - 1, m - 1, strs[begin], sb);

        //不存在的分支
        c_re(strs, begin + 1, n - 1, m, '\0', sb);

    }

    public static void p(char[] strs) {
        if (strs == null || strs.length == 0) return;
        p_re(strs, 0);
    }
    public static void p_re(char[] strs, int idx) {
        if (idx == strs.length - 1) {
            System.out.println(new String(strs));
        }

        for (int i = idx; i < strs.length; i++) {
            char temp = strs[i];
            strs[i] = strs[idx];
            strs[idx] = temp;

            p_re(strs, idx + 1);

            temp = strs[i];
            strs[i] = strs[idx];
            strs[idx] = temp;
        }
    }
}
