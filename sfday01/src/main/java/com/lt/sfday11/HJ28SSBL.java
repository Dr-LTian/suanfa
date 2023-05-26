package com.lt.sfday11;

import java.util.*;

//HJ28 --素数伴侣

/*
描述
题目描述
若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。

输入:

有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。

输出:

输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。

输入描述：
输入说明
1 输入一个正偶数 n
2 输入 n 个整数

输出描述：
求得的“最佳方案”组成“素数伴侣”的对数。

输入：
    4
    2 5 6 13
输出：
    2

    思路：匈牙利算法
 */
public class HJ28SSBL {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        while (sc.hasNextLine()){
            int num = sc.nextInt(); sc.nextLine();
            //奇数+奇数  偶数+偶数 结果都不可能为素数  只有奇数+偶数有可能为素数
            List<Integer> jsz = new ArrayList<>(); //奇数组
            List<Integer> osz = new ArrayList<>(); //偶数组

            for (int i = 0; i < num; i++) {
                int temp = sc.nextInt();
                if(temp % 2 == 0){ //偶数
                    osz.add(temp);
                }else{
                    jsz.add(temp); //奇数
                }
            }
            sc.nextLine();

            if (jsz.size() == 0 || osz.size() == 0){
                System.out.println(0); return;
            }

            int[] osbl = new int[osz.size()]; //偶数伴侣

            int count = 0;

            for (Integer js : jsz){
                boolean[] used = new boolean[osz.size()];//对应下标的偶数是否找到伴侣
                if(matched(js,osz,osbl,used)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    //判断是否是素数
    public static boolean isPrime(int n){
        for(int i=2; i * i <= n; ++i){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    //
    public static boolean matched(int js,List<Integer> osz, int[] osbl, boolean[] used){
        for (int i = 0; i < osz.size(); i++) { //遍历偶数组
            if(!used[i] && isPrime(js+osz.get(i))){ //当前偶数未匹配 且 可以和传入奇数相加为素数
                used[i] = true;
                //对应下标的偶数没有伴侣 或 对应下标的偶数伴侣(奇数)可以找到新的未匹配偶数作为伴侣
                if(osbl[i] == 0 || matched(osbl[i], osz, osbl, used)){
                    osbl[i] = js;
                    return true;
                }
            }
        }
        return false;
    }
}
