package com.lt.sfday09;

import java.util.Arrays;

//leetcode 204.计数质数 埃氏筛 枚举 线性筛
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
