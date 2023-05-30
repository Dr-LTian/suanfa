package com.lt.sfday11;

import java.util.Arrays;
import java.util.Scanner;

//HJ24 --合唱团
public class HJ24HCT {
    /*
    描述
N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。

设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T1,T2,...Tk,
若存在i(1<=i<=k)使得T1<T2<...<Ti-1<Ti 且 Ti>Ti+1>...Tk,则称这K名同学排成了合唱队列。

通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
例子：
123 124 125 123 121 是一个合唱队形
123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。

你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。

注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等

输入描述：
用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开

输出描述：
最少需要几位同学出列

输入：
8
186 186 150 200 160 130 197 200
输出：
4
说明：
由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num = sc.nextInt();//总人数
            sc.nextLine();

            int[] arr = new int[num];//每个人的身高
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            sc.nextLine();

            int[] dpl = new int[num];//每个人左边比他低的人数
            Arrays.fill(dpl, 1);
            int[] dpr = new int[num];//每个人右边比他低的人数
            Arrays.fill(dpr, 1);

            for (int i = 0; i < num; i++) {
                for (int j = 0; j < i; j++) { //找在i左边比arr[i]小的元素
                    if (arr[i] > arr[j]){
                        dpl[i] = Math.max(dpl[i], dpl[j]+1);
                    }
                }
            }

            for (int i = num-1; i >= 0; --i) {
                for (int j = num-1; j > i; --j) {//找在i右边比arr[i]小的元素
                    if(arr[i]>arr[j]){
                        dpr[i] = Math.max(dpr[i], dpr[j]+1);
                    }
                }
            }

            int maxLen = 1;
            for (int i = 0; i < num; i++) {
                maxLen = Math.max(maxLen, dpl[i] + dpr[i]);
            }
            System.out.println(num - maxLen);
        }
    }
}
