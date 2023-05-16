package com.lt.sfday08;

import java.util.*;

//leetcode 剑指offer 32 — II.从上到下打印二叉树 II
public class LCJZ32CSDXDYECS {
    public static void main(String[] args) {
        //{8,6,10,#,#,2,1}
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);

        System.out.println(PrintFromTopToBottom(root));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        // StringJoiner sj = new StringJoiner(",","[","]");
        ArrayList<Integer> list = new ArrayList<>();//保存最终输出的结果
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();//队列先进先出

        TreeNode curNode = root;

        queue.offer(curNode);//加入队列

        while (!queue.isEmpty()) {
            curNode = queue.poll(); //退出队列且返回该元素
            list.add(curNode.val); //将节点的值加入list
            if (curNode.left != null) queue.offer(curNode.left);//左子树入队
            if (curNode.right != null) queue.offer(curNode.right);//右子树入队
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
