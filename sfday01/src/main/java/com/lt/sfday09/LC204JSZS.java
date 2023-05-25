package com.lt.sfday09;

import java.util.Arrays;

//LC204 --计数质数 埃氏筛 枚举 线性筛

/*
    描述:
    给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。

    思路1:枚举 遍历2-n 判断每个数是否为质数 为质数计数

    思路2:埃氏筛 定义int数组 长度为n 给数组每个元素赋值为1
        遍历 2-n 如果int[i] ==1; count++; 判断i*i是否大于n
        如果不大于 从i*i开始 每次+=i 循环将所有i的倍数在int[]中标记为0
 */
public class LC204JSZS {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) { //埃氏筛
        int count = 0;
        int[] prime = new int[n];
        Arrays.fill(prime,1);

        for(int i=2;i<n;++i){
            if(prime[i] == 1){
                count++;
                if((long) i*i < n){  //从i*i开始 每次加i 将所有i的倍数都过滤
                    for(int j=i*i; j<n;j+=i){
                        prime[j] = 0;
                    }
                }
            }
        }
        return count;
    }
}
