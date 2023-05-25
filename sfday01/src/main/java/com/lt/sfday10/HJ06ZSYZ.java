package com.lt.sfday10;

import java.util.Scanner;

//HJ06 --质数因子

/*
描述
    功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
输入描述：
    输入一个整数

输出描述：
    按照从小到大的顺序输出它的所有质数的因子，以空格隔开。

    输入：
        180
    输出：
        2 2 3 3 5

  思路：从2 遍历到 根号n 大于根号n的质数因子最多只有一个 用短除法
 */
public class HJ06ZSYZ {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 素数就是质数 质数：指在一个大于1的自然数中,除了1和此整数自身外,不能被其他自然数整除的数
        while (sc.hasNextLine()) {
            long num = sc.nextLong();
            StringBuffer sf = new StringBuffer();

            //对于一个正整数n, 最多只有一个大于Math.sqrt(n) 的质因子  Math.sqrt(n) --对n开根号
            //  i<=Math.sqrt(n) 等价与 i*i <= n
            for (long i = 2; i*i <= num; ++i) {
                while (num % i == 0) { //取模运算 == 0 可以整除 while相当于短除法先把2除尽
                    sf.append(i).append(" ");
                    num /= i;
                }
            }
            //num == 1 说明一直可以整除 输入的num是有一系列质数相乘得来的   !=0 说明 最后剩余的num为一个质数
            System.out.println(num == 1 ? sf.toString().trim(): sf.append(num).toString().trim());
        }
    }

    //判断是否是质数
    public static boolean isZS(Long num){ //质数只有1和本身可以被整除
        if(num<=1) return false;

        for(int i=2; i<num; ++i){
            if(num % i == 0){ //取模运算 可以整除 余数为0
                return false;
            }
        }
        return true;
    }
}
