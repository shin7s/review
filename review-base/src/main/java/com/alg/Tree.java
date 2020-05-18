package com.alg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

    public static void main(String[] args) {
        //char[] cs = {'a', 'b', 'c', 'd', 'f', '#', '#', '#', 'e', 'g'};

        //TreeNode treeNode = new TreeNode(1);
        //treeNode.left = new TreeNode(2);
        //treeNode.right = new TreeNode(3);
        //
        //TreeNode treeNode1 = new TreeNode(1);
        //treeNode1.right = new TreeNode(2);
        //treeNode1.right.left = new TreeNode(3);
        //
        //
        //List<Integer> integers = inorderTraversal(treeNode);
        //System.out.println(integers);
        //
        //System.out.println(inorderTraversal(treeNode1));
        //
        //List<List<Integer>> nodeList = new ArrayList<>();
        //levelOrder1(nodeList, treeNode1);
        //System.out.println(nodeList);
        //
        //System.out.println((-2147483648 & (-2147483648 - 1)) == 0);

        TreeNode treeNode = buildBST_inorder(ListNode.build(new int[] { 10, 6, 4, 8, 14, 12, 16}));
        System.out.println(inorderTraversal(treeNode));

        TreeNode bst2List = convertBST2LIST(treeNode);
        System.out.println();

    }

    public static TreeNode convertBST2LIST(TreeNode root) {
        if (root != null) {
            TreeNode bst2List_recusive = convertBST2List_recusive(root);
            while (bst2List_recusive.right != null) {
                bst2List_recusive = bst2List_recusive.right;
            }
            return bst2List_recusive;
        }
        return null;
    }

    public static TreeNode convertBST2List_recusive(TreeNode root) {
        if (root == null) return null;
        TreeNode leftList = convertBST2List_recusive(root.left);
        TreeNode rightTree = root.right;
        if (leftList != null) {

            TreeNode ptRight = leftList;
            while (ptRight.left != null) {
                ptRight = ptRight.left;
            }
            //ptRight.right = root;
            root.right = ptRight;
            ptRight.left = root;
            root.left = null;
        }

        TreeNode rightList = convertBST2List_recusive(rightTree);
        if (rightList != null) {
            TreeNode ptLeft = rightList;
            while (ptLeft.right != null) {
                ptLeft = ptLeft.right;
            }
            ptLeft.right = root;
            root.left = ptLeft;
        }
        return root;
    }



    //public static void convertBST2List_recusive(TreeNode root, TreeNode holder) {
    //
    //    if (root == null) return;
    //
    //    //遍历左侧
    //    convertBST2List_recusive(root.left, holder);
    //
    //    //设置链表头
    //    if (holder.left == null) {
    //        holder.left = root;
    //    }
    //
    //
    //}


    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        //maxDepth(root, 0);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int depth = left;
        if (left <= 0)
            depth = right;
        else if (right <= 0)
            depth = left;
        else depth = Math.min(left, right);
        return depth + 1;
        //maxDepth(root, 0);
    }
    //public static int maxDepthDFS(TreeNode node, int depth) {
    //    if (node == null) return 0;
    //    else
    //}

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> nodeList = new ArrayList<>();
        inorder(nodeList, root);
        //levelOrder(nodeList, root);
        return nodeList;
    }

    static class Node {
        TreeNode node;
        int level = 0;
        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrder1(List<List<Integer>> nodeList, TreeNode root) {
        int maxLevel = -1;
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(root, 0));
            while (!queue.isEmpty()) {
                Node first = queue.poll();
                if (first.node.left != null) {
                    queue.add(new Node(first.node.left, first.level + 1));
                }
                if (first.node.right != null) {
                    queue.add(new Node(first.node.right, first.level + 1));
                }

                if (first.level > maxLevel) {
                    maxLevel = first.level;
                    nodeList.add(new ArrayList<Integer>());
                }
                nodeList.get(first.level).add(first.node.val);
            }
        }
    }

    //中序遍历非递归
    public static void levelOrder(List<Integer> nodeList, TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode first = queue.poll();
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }

                nodeList.add(first.val);
            }
        }
    }

    //中序遍历
    public static void inorder(List<Integer> nodeList, TreeNode root) {
        if (root != null) {
            inorder(nodeList, root.left);
            nodeList.add(root.val);
            inorder(nodeList, root.right);
        }
    }

    //中序遍历
    public static void preorder(List<Integer> nodeList, TreeNode root) {
        if (root != null) {
            nodeList.add(root.val);
            preorder(nodeList, root.left);
            preorder(nodeList, root.right);
        }
    }

    public static TreeNode buildBST_inorder(ListNode[] nodes) {
        if (nodes == null || nodes.length < 1)
            return null;
        return buildBST_recusive(nodes, 0, nodes.length - 1);
    }
    public static TreeNode buildBST_recusive(ListNode[] nodes, int si, int ei) {
        if (si > ei) return null;

        TreeNode parent = new TreeNode(nodes[si].val);
        int i = si + 1, left = si;
        while (i <= ei) {
            if (nodes[i].val < nodes[si].val) ++left;
            else break;
            i++;
        }

        int right = left;
        while (i <= ei) {
            if (nodes[i].val > nodes[si].val) ++right;
            else break;
            i++;
        }
        if (i <= ei)
            throw new IllegalArgumentException("Invalid Input");

        //System.out.println("si,ei,i,left,right:" + si + "," + ei + "," + i + "," + left + "," + right);

        if (left > si)
            parent.left = buildBST_recusive(nodes, si + 1, left);
        if (right > si) {
            //System.out.println("r");
            parent.right = buildBST_recusive(nodes, left + 1, ei);
        }

        return parent;
    }

    public static void buildBST_recusive(TreeNode head, ListNode[] nodes, int si, int ei) {

        if (si > ei) return;
        int i = si, left = si - 1;
        for (; i <= ei; i++) {
            if (nodes[i].val < head.val) left++;
            else break;
        }
        for (; i <= ei; i++) {
            if (nodes[i].val > head.val) continue;
            else  {
                i++;
                break;
            }
        }
        if (i <= ei)
            throw new IllegalArgumentException("Invalid Input");

        System.out.println("si,ei,i,left:" + si + "," + ei + "," + i + "," + left);

        if (left >= si) {
            head.left = new TreeNode(nodes[si].val);
            buildBST_recusive(head.left, nodes, si + 1, left);
        }
        if (left + 1 <= ei) {
            head.right = new TreeNode(nodes[left + 1].val);
            buildBST_recusive(head.right, nodes, left + 1, ei);
        }
    }



}
