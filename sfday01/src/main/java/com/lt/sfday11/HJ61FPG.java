package com.lt.sfday11;

import java.util.*;

//HJ61 --放苹果
public class HJ61FPG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int m = sc.nextInt();//苹果数
            int n = sc.nextInt();//盘子数
            sc.nextLine();

            if(m ==1 || n==1 || m==0){ //盘子数为1 1种分法  苹果数为0为1 均为1种分法
                System.out.println(1);
                return;
            }

            //对于盘子来说 只有两个状态 放苹果 和 不放苹果
            //对于苹果来说 只有两个状态 放入盘子 和 不放入盘子

            //状态转移方程: f(m,n)  = f(m,n-1) + f(m-n,n)
            //最终的分法f(m,n) = 有盘子为空的分法f(m,n-1) + 所有盘子不为空的分法f(m-n,n)
            //f(m,n-1) : 一个盘子不放苹果 相当于（盘子数-1）的分法
            //f(m-n,n) : 每个盘子至少放了一个苹果 n个盘子相当于至少放了n个苹果
            //等价于剩余的m-n个苹果放在n个盘子中的分法
            int[][] dp = new int[m+1][n+1];

            //边界值 m=1 m=0 n=1
            Arrays.fill(dp[0],1); //m==0
            Arrays.fill(dp[1],1); //m==1

            for(int i=2;i<=m;++i){
                for(int j=1;j<=n;++j){
                    if(j==1){dp[i][j] = 1;} //n==1
                    else {
                        if(i>=j){
                            dp[i][j] = dp[i][j-1] + dp[i-j][j];
                        }else{
                            dp[i][j] = dp[i][j-1];
                        }

                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }
}
