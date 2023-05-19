package com.lt.sfday11;

import java.util.Scanner;

//HJ35 --蛇形矩阵
public class HJ35SXJZ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        method1(num);
        method3(num);
    }

    //方法1  观察横向 纵向的规律 第一行第一列为1 每次先找出每行的第一个元素 再将这一行的其他元素 按规律计算得出

    //初始化：int[][] dp = [num+][]; dp[1][1] =1;
    //行首规律（不同行行首、第一行第一列直接指定为1） ：dp[row][1] = dp[row-1][1] + row -1
    //行内规律（除行首元素外） ：if(col != 1) dp[row][col] = dp[row][col-1] + row +col-1;
    public static void method1(int num){

        int[][] dp = new int[num+1][num+1];

        for(int row = 1; row<=num;++row){// 总共有num行数据

            if(row != 1) dp[row][1] = dp[row-1][1] + row -1;//行首元素之间的规律

            for(int col = 1; col<=num-row+1;++col){ //每行有 num-row+1个数据
                if(row ==1 && col==1) {
                    dp[1][1] = 1; //初始值
                    continue;
                }
                if(col != 1) dp[row][col] = dp[row][col-1] + row +col-1;//每行除了行首以外的元素规律
            }
        }

        StringBuffer sf = new StringBuffer();//保存每行的元素

        for(int i=1;i<=num;++i){ //遍历dp
            for(int j=1;j<=num-i+1;++j){
                sf.append(dp[i][j]).append(" ");
            }
            System.out.println(sf.toString().trim());
            sf.setLength(0); //清空sf
        }
    }

    /**
     *  num = 4
     *  1 3 6 10
     *  2 5 9
     *  4 8
     *  7
     */

    //方法2 先计算出第一行数据  第二行数据为第一行数据除去行首元素外 再减1得来的
    //eg：第一行 1 3 6 10 第二行为 去掉 1  [(3-1) (6-1) (10-1)] 以此类推
    public void method2(){

    }

    //对角线思想
    public static void method3(int num){
        int[][] dp = new int[num+1][];

        int cur = 1;//类似于指针 沿对角线移动 表示在当前位置的值 范围 ：从1 到 num的阶乘

        for (int i = 1; i <= num; i++) {
            //最大长度为num+1   第i行长度:(num+1-i)+1  [i从1开始所以多 +1]
            dp[i] = new int[num +2 -i];
            for (int j = 1; j <= i; j++) { //表示第i次遍历 对角线上有几个元素
                //这一行最为精妙 相当于每次 从下往上给每一行的末尾放值   [形似对角线 '/' 自下往上赋值]
                dp[i-j+1][j] = cur;
                cur++;
            }
        }

        StringBuffer sf = new StringBuffer();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num-i+1; j++) {
                sf.append(dp[i][j]).append(" ");
            }
            System.out.println(sf.toString().trim());
            sf.setLength(0);
        }
    }
}
