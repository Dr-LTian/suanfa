package com.lt.sfday08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//leetcode 剑指offer 77 — 之字打印二叉树 同层级打印借助队列
public class LCJZ77ZZDYECS {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Queue<TreeNode> queue = new LinkedList<>();
    static int depth;
    public static void main(String[] args) {
        //{1,2,3,#,#,4,5}
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(Print(root));

    }

    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot ==null) return list; //异常判断

        queue.offer(pRoot); //根节点入队列
        depth += 1; //层数加1
        while (!queue.isEmpty()) { //队列不为空
            depth++;
            ArrayList<Integer> arr = new ArrayList<>(); //保存每层所有的节点数据
            int size = queue.size(); //每层的节点数
            for (int i = 0; i < size; i++) { //将当前层数据全部出队列
                TreeNode cur = queue.poll();
                arr.add(cur.val);

                //对于每个节点都是先加左子树后加右子树  在队列中每层每次出队列 可保证每层的顺序正序
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (depth % 2 == 0) { //奇数层从左向右遍历 保存每层每个节点的正序输出
                list.add(arr);
            } else { //偶数层从右向左遍历
                Collections.reverse(arr);//逆序输出
                list.add(arr);
            }
        }
        return list;
    }
}

