package com.lt.sfday08;

import java.util.*;

//HJ48 从单向链表中删除指定值的节点 --借助Arraylist来处理
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
