package com.lt.sfday08;

import java.util.ArrayList;
import java.util.List;

//LC160 --相交链表

/*
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

 思路：找到相交节点  双指针 分别指向A、B两个链表的头节点 如果指针A不等于指针B 则while循环
  指针A走完变为null继续从B的头节点开始走 指针B走完从A的头节点走 直至两指针相遇 相遇的节点要么是相交节点要么就是null

分析:
  A的长度记为m B的长度记为n 双指针同时移动 当指针A为空  将指针A移动至B的头节点  当指针B为空  将指针B移动至A的头节点

  1>假设A与B相交  将A中不相交的长度记为a  将B中不相交的部分记为b  将A与B相交的长度记为c
      m(A) = a+c  n(B) = b+c 若 =ab 双指针同时到达相交节点 返回该节点
      若a ！= b 指针A =a+c+b  指针B =b+c+a 时同时到达相交节点

  2>假设A与B不相交
      m = n 双指针遍历自身同时到达尾部 ==null 跳出循环并返回null
      m != n 指针A = m+n 指针B = n+m 时 双指针同时到达尾部 ==null 跳出循环并返回null
 */
public class LC160XJLB {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

         while(curA != null){  //相当于双重for循环
             while(curB != null){
                 if(curA == curB){ //相交节点指向同一内存地址 不仅仅是指值一致
                     return curA;
                 }else{
                     curB = curB.next; //内层循环 相当于j++
                 }
             }
             curA = curA.next; //外层循环 相当于 i++
             curB = headB; //重置内层循环起点 相当于j=0
         }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

         List<ListNode> list = new ArrayList<>();
         while(curA != null){  //存储A中所有节点
             list.add(curA);
             curA = curA.next;
         }
          while(curB != null){ //遍历B中节点  判断B中是否有节点等于A中的节点
             if(list.contains(curB)){ //contains方法 本质也是遍历取出进行判断 与方法一性质差不多
                 return curB;
             }
             curB = curB.next;
         }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA ==null || headB==null) return null; //有任意一个为null 则不可能相交

        //双指针
        ListNode curA = headA;
        ListNode curB = headB;

        //A的长度记为m B的长度记为n 双指针同时移动 当指针A为空  将指针A移动至B的头节点  当指针B为空  将指针B移动至A的头节点

        //1>假设A与B相交  将A中不相交的长度记为a  将B中不相交的部分记为b  将A与B相交的长度记为c
        //m(A) = a+c  n(B) = b+c 若 a=b 双指针同时到达相交节点 返回该节点
        //若a ！= b 指针A =a+c+b  指针B =b+c+a 时同时到达相交节点

        //2>假设A与B不相交
        //m = n 双指针遍历自身同时到达尾部 ==null 跳出循环并返回null
        //m != n 指针A = m+n 指针B = n+m 时 双指针同时到达尾部 ==null 跳出循环并返回null
        while(curA != curB){
            curA = (curA==null) ? headB : curA.next;
            curB = (curB==null) ? headA : curB.next;
        }
        return curA;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
