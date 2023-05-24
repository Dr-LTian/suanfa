package com.lt.sfday05;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//HJ8 --合并表记录
/*
    数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，
    即将相同索引的数值进行求和运算，输出按照index值升序进行输出。

    先输入键值对的个数n（1 <= n <= 500）
    接下来n行每行输入成对的index和value值，以空格隔开

    eg:输入：
        4
        0 1
        0 2
        1 2
        3 4

    输出：
        0 3
        1 2
        3 4

    思路:借助treeMap key存索引 value 存值 treeMap 默认按key升序
 */
public class HJ8HBBJL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            Map<String, Integer> map = new TreeMap<>((o1, o2) -> {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            });// new Comparable<>()接口用lambda表达式简化

            for (int i = 0; i < num; ++i) {
                String[] arr = sc.nextLine().split(" ");
                if (map.containsKey(arr[0])) {
                    int val = map.get(arr[0]) + Integer.parseInt(arr[1]);
                    map.put(arr[0], val);
                } else {
                    map.put(arr[0], Integer.parseInt(arr[1]));
                }
                // map.put(arr[0], map.getOrDefault(arr[0],0) + Integer.parseInt(arr[1]));
            }

            for (String key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
