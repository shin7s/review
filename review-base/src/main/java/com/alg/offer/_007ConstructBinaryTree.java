package com.alg.offer;

import com.alg.Tree;
import com.alg.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _007ConstructBinaryTree {

    public static void main(String[] args) {
        TreeNode construct = construct(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        Tree.preorder(preorderList, construct);
        Tree.inorder(inorderList, construct);
        System.out.println(preorderList);
        System.out.println(inorderList);
        System.out.println("k");
    }

    /**
     * 重建二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode construct(int[] preorder, int[] inorder) {
        return constructRecursive(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode constructRecursive(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {

        if (preorder == null || inorder == null || preorder.length <= 0)
            return null;

        if (ps == pe) {
            if (is == ie && preorder[ps] == inorder[is]) {
                return new TreeNode(inorder[is]);
            } else {
                throw new IllegalArgumentException("Invalid Input");
            }
        }

        //确定根节点
        TreeNode root = new TreeNode(preorder[ps]);
        //通过中序寻找左右子树
        int i = 0, j = 0, k = 0;
        for (i = is; i <= ie; ++i) {
            if (inorder[i] == preorder[ps]) {
                break;
            }
        }

        int leftLen = i - is;
        int rightLen = ie - i;

        if (leftLen < 0 || rightLen < 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        //建立左子树
        if (leftLen > 0) {
            root.left = constructRecursive(preorder, inorder, ps + 1, ps + leftLen, is, i - 1);
        }
        if (rightLen > 0) {
            root.right = constructRecursive(preorder, inorder, pe - rightLen + 1, pe, i + 1, ie);
        }
        return root;
    }



}
