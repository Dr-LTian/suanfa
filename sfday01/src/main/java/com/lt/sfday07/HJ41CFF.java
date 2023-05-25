package com.lt.sfday07;

import java.util.*;

//HJ41 --称砝码

/*
现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。

注：称重重量包括 0

输入描述：
    对于每组测试数据：
    第一行：n --- 砝码的种数(范围[1,10])
    第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
    第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
输出描述：
    利用给定的砝码可以称出的不同的重量数
输入：
    2
    1 2
    2 1
输出：
    5
说明：
    可以表示出0，1，2，3，4五种重量。

    思路1: 用set存放所有的可能性 初始化时先放0 每次拿一个砝码 与set中的元素相加 就是当前砝码加入后的所有可能性
    利用set去重特性找出所有不重复的可能
    思路2:同样利用set去重存放所有可能 初始放0 区别于思路1 对于每种质量的砝码 都有对应质量种放法 放一个...放n个
    把一种质量的砝码的所有可能结果与set种所有元素相加 去重放回 再一次放置下一个质量的砝码
 */
public class HJ41CFF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNextLine()) { // 注意 while 处理多个 case
            int num = Integer.parseInt(sc.nextLine());
            String[] zl = sc.nextLine().split(" ");
            String[] sl = sc.nextLine().split(" ");
            if(num== 0 || zl.length != num || zl.length != sl.length) System.out.println(0);

            // 将所有砝码放在list数组中并排序
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i< num; ++i){
                for(int j=1; j <= Integer.parseInt(sl[i]); ++j){
                    list.add(Integer.parseInt(zl[i]));
                }
            }
            Collections.sort(list);

            Set<Integer> set = new TreeSet<>();//最终结果的set
            set.add(0);
            Set<Integer> temp = new TreeSet<>();//每次取出一个砝码，可能需要添加的重量
            for(Integer i : list){ //遍历砝码集合
                temp.clear();
                for(Integer j: set){ //将第i个砝码放进set，可能出现的重量=当前砝码质量+set中出现的所有质量
                    temp.add(i+j);
                }
                //将可能出现的结果放回set中
                set.addAll(temp);

            }
            System.out.println(set.size());

        }
    }
}
