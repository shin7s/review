package com.alg.offer;

public class _VerifySequenceOfBST {
    public static void main(String[] args) {
        //System.out.println(verifySequenceOfBST(new int[] {5, 7, 6, 9, 11, 10, 8}));
        //System.out.println(verifySequenceOfBST(new int[] { 7, 4, 6, 5}));
        System.out.println(verifySequenceOfBST(new int[] { 7, 10, 8, 5}));

        System.out.println(verifySequenceOfBST(new int[] { 10, 8, 6, 4, 2}));



    }

    public static boolean verifySequenceOfBST(int[] bst) {
        if (bst == null || bst.length == 0)
            return false;
        return verifySequenceOfBST_recursive(bst, 0, bst.length - 1);
    }

    public static boolean verifySequenceOfBST_recursive(int[] bst, int si, int ei) {
        if (si == ei) return true;

        boolean flag = true;

        int i = si, left = i - 1;
        while (i < ei) {
            if (bst[i] < bst[ei]) {
                ++left;
            } else {
                break;
            }
            ++i;
        }

        while (i < ei) {
            if (bst[i] > bst[ei]) {
            } else {
                break;
            }
            ++i;
        }

        System.out.println("si,ei,left：" + si + "," + ei + " | " + left);

        if (i < ei) return false;

        if (left > si - 1) {
            //有左子树
            flag &= verifySequenceOfBST_recursive(bst, si, left);
        }

        if (left + 1 != ei) {
            flag &= verifySequenceOfBST_recursive(bst, left + 1, ei - 1);
        }

        return flag;
    }
}
