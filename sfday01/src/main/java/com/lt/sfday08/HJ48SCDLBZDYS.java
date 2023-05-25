package com.lt.sfday08;

import java.util.*;

//HJ48 --从单向链表中删除指定值的节点 --借助Arraylist来处理

/*
输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。

链表的值不能重复。

构造过程，例如输入一行数据为:
6 2 1 2 3 2 5 1 4 5 7 2 2
则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
1 2 表示为
2->1
链表为2->1

3 2表示为
2->3
链表为2->3->1

5 1表示为
1->5
链表为2->3->1->5

4 5表示为
5->4
链表为2->3->1->5->4

7 2表示为
2->7
链表为2->7->3->1->5->4

最后的链表的顺序为 2 7 3 1 5 4

最后一个参数为2，表示要删掉节点为2的值
删除 结点 2

则结果为 7 3 1 5 4

输入描述：
    输入一行，有以下4个部分：
    1 输入链表结点个数
    2 输入头结点的值
    3 按照格式插入各个结点
    4 输入要删除的结点的值

输出描述：
    输出一行
    输出删除结点后的序列，每个数后都要加空格

    输入：
        5 2 3 2 4 3 5 2 1 4 3
    输出：
        2 5 4 1
    说明：
        形成的链表为2->5->3->4->1
        删掉节点3，返回的就是2->5->4->1

   思路:借助arraylist 将头元素放入list 每次取两个元素 第一个为第二个元素的上一个元素
   找到第一个元素的下标 将第二个元素放入第一个元素下标+1的位置
   最后找到要删除元素的下标 根据下标删除该元素 因为元素无重复 所以也可直接remove(obj)删除指定元素
 */
public class HJ48SCDLBZDYS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            int len = Integer.parseInt(str[0]); //最终长度
            //节点元素不重复，不然会出现插入歧义
            int n0 = Integer.parseInt(str[1]); //头元素
            int delVal = Integer.parseInt(str[str.length-1]); //需要删除的元素

            List<Integer> list = new ArrayList<>(); //存放所有的数据
            // list.add(index,val)指定索引添加元素不会覆盖指定索引之前的数据，之前的数据会自动向后移动
            list.add(n0);

            for(int i= 2; i< str.length -1;i = i+2){ //从字符串数组的索引为2的值(相等于链表的第二个元素)开始，每次取两个元素
                int curVal = Integer.parseInt(str[i+1]); //应该放在数组中此元素之后
                int nextVal = Integer.parseInt(str[i]); //需要放进数组中的数据

                list.add(list.indexOf(curVal) + 1,nextVal); //找到元素的下标，新元素应放在下标+1的位置
            }
            if(list.contains(delVal)){ //如果元素输入合法，不需要此判断
                list.remove(list.indexOf(delVal));
            }
            StringBuffer res = new StringBuffer();
            for(Integer i : list){
                res.append(i).append(" ");
            }
            System.out.println(res.toString());
        }
    }
}
