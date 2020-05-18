package com.alg;

public class Kmp {
    public static void main(String[] args) {
        //System.out.println("".toCharArray()[0]);
        //System.out.println("a".indexOf(""));
        //System.out.println(kmp("ababababca", "abababca"));
        //System.out.println(kmp("", ""));
        //System.out.println(kmp("a", "a"));
        //System.out.println(kmp("a", "b"));
        //System.out.println(kmp("ab", "b"));

        //System.out.println(rk("abc", "abc"));
        //System.out.println(-2 %(Integer.MAX_VALUE / 33));
        //int mod = Integer.MAX_VALUE / 33;
        //System.out.println((-2 + mod) % mod);

        //System.out.println(rk("abcd", "bcd"));
        //System.out.println(rk("abcd", "cd"));
        //System.out.println(rk("ababababca", "abababca"));


        System.out.println(kmp2("ababababca", "abababca"));
        System.out.println(kmp2("", ""));
        System.out.println(kmp2("a", "a"));
        System.out.println(kmp2("a", "b"));
        System.out.println(kmp2("ab", "b"));
    }

    public static int kmp2(String source, String target) {

        if (source == null || target == null) return -1;
        if (target.length() > source.length()) return -1;
        if (target.length() == 0 && source != null) return 0;
        if (source.length() == 0) return -1;

        int[] next2 = getNext2(target);
        int n = source.length(), m = target.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (j == -1 ||  source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = next2[j];
            }
        }
        if (j == m) {
            return i - m;
        } else {
            return -1;
        }

    }

    public static int[] getNext2(String t) {
        int n = t.length();
        int[] next = new int[n];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < n - 1) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }


    public static int rk(String source, String target) {

        if (source == null || target == null) return -1;
        if (target.length() > source.length()) return -1;
        if (target.length() == 0 && source != null) return 0;
        if (source.length() == 0) return -1;

        int n = source.length();
        int m = target.length();
        int m33 = 33;

        int mod = Integer.MAX_VALUE / 33;
        int target_hash = 0;
        int source_hash = 0;
        int base = 1; //m33的m-1次方
        int i = 0, j = 0;

        for (i = 0; i < m; i++) {
            target_hash = (target_hash * m33 + target.charAt(i) - 'a') % mod;
            if (target_hash < 0) {
                target_hash = (target_hash + mod);
            }
        }

        for (i = 0; i < m - 1; ++i) {
            base = base * m33 % mod;
        }

        for (i = 0; i < n; i++) {
            //m-1
            if (i >= m) {
                source_hash = (source_hash - base * (source.charAt(i - m) - 'a')) % mod;
            }

            source_hash = (source_hash * m33 + (source.charAt(i) - 'a')) % mod;
            if (source_hash < 0) {
                source_hash += mod;
            }

            if (i >= m - 1 && source_hash == target_hash) {
                if (target.equals(source.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
    public static int kmp(String source, String target) {
        if (source == null || target == null) return -1;

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        if (t == null || t.length == 0)
            return 0;

        int[] next = getNext(t);
        int i = 0, j = 0;

        while (i < s.length && j < t.length) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == t.length)
            return i - j;
        else return -1;
    }
    public static int[] getNext(char[] t) {
        int[] next = new int[t.length];
        int i = 0, j = -1;
        next[0] = -1;

        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
