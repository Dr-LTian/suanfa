package com.lt.sfday11;

import java.util.ArrayList;
import java.util.List;

//二叉树遍历 前序 中序 后序
public class ECSBL {
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    //前序: “根左右"  即先遍历根节点，再遍历左子树节点，再遍历右子树节点。
    List<Integer> preOrder(TreeNode node) {
        if (node == null) {
            return list;
        }
        list.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
        return list;
    }

    //中序：”左根右“
    public void inorder(List<Integer> list, TreeNode root){
        //遇到空节点则返回
        if(root == null)
            return;
        //先去左子树
        inorder(list, root.left);
        //再访问根节点
        list.add(root.val);
        //最后去右子树
        inorder(list, root.right);
    }

    //后序：”左右根“
    public void postorder(List<Integer> list, TreeNode root){
        //遇到空节点则返回
        if(root == null)
            return;
        //先去左子树
        postorder(list, root.left);
        //再去右子树
        postorder(list, root.right);
        //最后访问根节点
        list.add(root.val);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
      this.val = val;
    }
  }


