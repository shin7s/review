package com.alg.offer;

public class _015ReplaceBlank {
    public static void main(String[] args) {
        System.out.println(replaceBlank("We are happy.".toCharArray(), "%20".toCharArray()));
        System.out.println(replaceBlank("We are happy.".toCharArray(), "%".toCharArray()));

        System.out.println(replaceBlank("We are happy.".toCharArray(), "".toCharArray()));
        System.out.println(replaceBlank("We are happy.".toCharArray(), null));
        System.out.println(replaceBlank("Wearehappy.".toCharArray(), null));
        System.out.println(replaceBlank("     ".toCharArray(), "%20".toCharArray()));
        System.out.println(replaceBlank("We are happy.  ".toCharArray(), "%20".toCharArray()));
    }

    public static char[] replaceBlank(char[] temp, char[] replace) {

        if (temp == null || replace == null) {
            return temp;
        }

        int qty = 0;
        for (int i = 0; i < temp.length; i++) {
            if (' ' == temp[i]) {
                ++qty;
            }
        }
        //新字符串长度
        char[] replacedChars = new char[temp.length + (replace.length - 1) * qty];
        int k = replacedChars.length - 1, j = temp.length - 1;
        for (; j >= 0; j--) {
            if (temp[j] == ' ') {
                //替换
                for (int i = replace.length - 1; i >= 0; i--, k--) {
                    replacedChars[k] = replace[i];
                }
            } else {
                replacedChars[k] = temp[j];
                --k;
            }
        }
        return replacedChars;
    }
}
