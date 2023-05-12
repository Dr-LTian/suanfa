package com.lt.sfday07;

import java.util.*;

//HJ41.称砝码
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
