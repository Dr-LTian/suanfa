package com.lt.sfday01;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

//HJ3明明的随机数
public class HJ3MMDSJS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            //第一个int值为传入int的总数
            int count = sc.nextInt();
            //创建treeSet去重并排序，默认升序
            TreeSet<Integer> tset = new TreeSet<>();

            for (int i = 0; i < count; ++i) {
                tset.add(sc.nextInt());
            }
            System.out.println("treeSet:" + tset);
            for (Integer integer : tset) { //顺序输出
                System.out.println(integer);
            }
            System.out.println("----------------------------------------------------");
            for (Iterator iterator = tset.descendingIterator(); iterator.hasNext() ; ) { //逆序输出
                System.out.println(iterator.next());
            }
        }
    }
}
