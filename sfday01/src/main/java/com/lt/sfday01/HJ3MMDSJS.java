package com.lt.sfday01;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

//HJ3 --明明的随机数

/**
 * 明明生成了N个1到500之间的随机整数。
 * 请你删去其中重复的数字，即相同的数字只保留一个，
 * 把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 */
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
