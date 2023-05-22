package com.lt.sfday11;

import java.util.Scanner;

//HJ53 --杨辉三角的变形
public class HJ53YHSJBX {

    //如果是第一行和第二行，直接输出-1。
    //可以看出规律，奇数行的的第二位数值都是偶数。
    //另外，可以发现4的倍数行，第三位数值都是偶数。
    //其余，第四位数值都是偶数。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());


        if(row ==1 || row==2) { //第一行 或 第二行
            System.out.println(-1);
        }

        else if(row % 2 ==1){ //奇数行    奇数+奇数 = 偶数  奇数+偶数 = 奇数
            System.out.println(2);
        }

        else{ //偶数行  判断是否为4的倍数行 是4的倍数行输出3 不是输出4
            System.out.println(row %4 ==0?3:4);
        }
    }

    public static void ty(){ //通用解法  计算出第n行的所有值 遍历第n行找出是否存在偶数 存在返回第几位 不存在返回-1
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int row = Integer.parseInt(sc.nextLine());
            //状态转移方程 f[i][j] = f[i-1][j] + f[i-1][j-1] +f[i-1][j+1]
            int[][] dp = new int[row + 1][];

            for (int i = 1; i <= row; ++i) {
                dp[i] = new int[2 * i];
                for (int j = 1; j <= 2*i-1; j++) {
                    if (i == 1 && j == 1) {
                        dp[i][j] = 1;
                        continue;
                    }
                    //dp[i][j]正上方是dp[i-1][j-1] 左上角dp[i-1][j-2] 右上角dp[i-1][j]
                    if(j-1<=2*(i-1)-1){//存在正上方元素
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                    if (j - 2 >= 0) { //存在左上角元素
                        dp[i][j] += dp[i - 1][j - 2];
                    }
                    if (j <= 2*(i-1)-1) { //存在右上角元素
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
            int res = -1;
            int idx = -1;
            for (int i : dp[row]) {
                idx++;
                if (i != 0 && i % 2 == 0) {
                    res = idx;
                    break;
                }

            }

            System.out.println(res);
        }
    }
}
