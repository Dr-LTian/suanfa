package com.lt.sfday08;

import java.util.*;

//JZ25 --合并两个排序的链表

/*
    思路1: 定义一个新的链表result 随便给个头节点 最后返回result.next
    需要3个指针 分别指向 result的当前元素 和其他需要合并的两个链表的头元素
    如果指向需要合并的链表的指针都不为空 用while循环 判断找出比较小的值放入result.next中,并移动相应指针
    最后其中一个会先为空 再把剩下不为空的元素全部加到result之后 最后输出

    思路2：分别遍历两个链表 将所有节点当如list中并排序 之后直接遍历list 将所有节点串联成新的链表
 */
public class JZ25HBLGPXLB {
    public static void main(String[] args) {

    }
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(-1); //定义一个ListNode 给一个头节点 最后返回 list.next
        List<ListNode> arr = new ArrayList<>(); //将两个list中的所有节点存入arr中
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null){
            arr.add(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            arr.add(cur2);
            cur2 = cur2.next;
        }
        arr.sort(Comparator.comparingInt(o -> o.val)); //排序arr

        ListNode cur = list; //定义list的指针cur
        for (ListNode node : arr){
            cur.next = node; //将排好序的节点一次添加进当前指针的下一位
            cur = cur.next; //指针向后移动
        }

        return list.next;
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        //特殊情况判断
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode list = new ListNode(-1); //定义一个ListNode 给一个头节点 最后返回 list.next

        ListNode cur1 = list1; //list1的指针
        ListNode cur2 = list2; //list2的指针
        ListNode cur = list; //定义list的指针cur

        while (cur1 != null && cur2 != null){
            if(cur1.val > cur2.val){
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }else{
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
            }
        }

        if ((cur1 == null)) { //其中一个list已经变为null了 还有剩余的另一个直接添加到cur之后
            cur.next = cur2;
        } else {
            cur.next = cur1;
        }

        return list.next;

    }
}

