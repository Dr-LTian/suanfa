package com.lt.sfday05;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//HJ8 --合并表记录
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
