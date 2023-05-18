package com.lt.sfday10;


import java.util.*;

//HJ16 --购物单
public class HJ16GWD {
    /*
    1000 5
    800 2 0
    400 5 1
    300 5 1
    400 3 0
    500 2 0

    1000 5
    300 5 0
    400 2 0
    300 5 2
    300 4 2
    600 4 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().trim().split(" ");
            int N = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);

            Good[] gds = new Good[m +
                    1]; //gds[0] 不使用 从gds[1]开始 因为编号从1开始 直观一些
            for (int i = 1; i <= m; i++) { //初始化gds
                gds[i] = new Good(i);
            }
            for (int i = 1; i <= m; i++) { //赋值v p q 及 附件
                String[] temp = sc.nextLine().trim().split(" ");
                int v = Integer.parseInt(temp[0]);
                int p = Integer.parseInt(temp[1]);
                int q = Integer.parseInt(temp[2]);
                gds[i].setVPQ(v, p, q);
                if (q != 0) {
                    gds[q].setG(gds[i]);
                }

            }

            //二维数组 动态规划 01背包问题
            int[][] dp = new int[m + 1][N + 1];
            getDP2(dp,gds,m,N);

            //一维数组 动态规划 01背包问题
            int[] dp1 = new int[N + 1];
            getDP1(dp1,gds,m,N);

        }
    }

    public static void getDP2(int[][] dp, Good[] gds,int m, int N){
        for (int i = 1; i <= m; i++) {
            //主件  //只买主件
            int v = gds[i].v;
            int val = gds[i].val;
            //附件1
            int fv1 = gds[i].g1 != null ? gds[i].g1.v : 0;
            int fval1 = gds[i].g1 != null ? gds[i].g1.val : 0;
            //附件2
            int fv2 = gds[i].g2 != null ? gds[i].g2.v : 0;
            int fval2 = gds[i].g2 != null ? gds[i].g2.val : 0;
            //五种选择 1、不买主件 2、只买主件 3、主件+附件1 4、主件+附件2 5、主件+附件1+附件2

            for (int j = 1; j <= N; ++j) { // N 金额
                dp[i][j] = dp[i - 1][j]; //不买主件
                if (gds[i].q != 0) continue;//只考虑主件 附件跳过
                getMaxDp2(dp,i,j, v, val); //只买主件
                getMaxDp2(dp,i,j, v + fv1, val + fval1); //主件+附件1
                getMaxDp2(dp,i,j, v + fv2, val + fval2); //主件+附件2
                getMaxDp2(dp,i,j, v + fv1 + fv2, val + fval1 + fval2); //主件+附件1+附件2
            }
        }
        System.out.println(dp[m][N]);
    }

    public static void getMaxDp2(int[][] dp, int i, int j,int v,int val){
        if(j >= v) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + val);
    }

    public static void getDP1(int[] dp, Good[] gds, int m, int N){
        for (int i = 1; i <= m; i++) {
            //只考虑主件 附件跳过
            if (gds[i].q != 0) continue;

            //主件  //只买主件
            int v = gds[i].v;
            int val = gds[i].val;
            //附件1
            int fv1 = gds[i].g1 != null ? gds[i].g1.v : 0;
            int fval1 = gds[i].g1 != null ? gds[i].g1.val : 0;
            //附件2
            int fv2 = gds[i].g2 != null ? gds[i].g2.v : 0;
            int fval2 = gds[i].g2 != null ? gds[i].g2.val : 0;
            //五种选择 1、不买主件 2、只买主件 3、主件+附件1 4、主件+附件2 5、主件+附件1+附件2

            //主件+附件1
            int v1 = v + fv1;
            int val1 = val + fval1;
            //主件+附件2
            int v2 = v + fv2;
            int val2 = val + fval2;
            //主件+附件1+附件2
            int v12 = v + fv1 + fv2;
            int val12 = val + fval1 + fval2;

            for (int j = N; j >= v; --j) {
                getMaxDp1(dp,i,j,v,val);
                getMaxDp1(dp,i,j,v1,val1);
                getMaxDp1(dp,i,j,v2,val2);
                getMaxDp1(dp,i,j,v12,val12);
            }
        }
        System.out.println(dp[N]);
    }

    public static void getMaxDp1(int[] dp, int i, int j,int v,int val){
        if(j >= v) dp[j] = Math.max(dp[j], dp[j - v] + val);
    }
}

class Good {
    int i; //编号 从1开始
    int v; //价格
    int p; //满意度
    int q; //为0是主件  不为0是主件编号
    int val;

    Good g1;
    Good g2;

    Good() {}

    Good(int i) {
        this.i = i;
    }
    public void setVPQ(int v, int p, int q) {
        this.v = v;
        this.p = p;
        this.q = q;
        this.val = v * p;
    }
    public void setG(Good g) {
        if (g1 == null)
            this.g1 = g;
        else
            this.g2 = g;
    }

    @Override
    public String toString() {
        return "Good{" +
                "i=" + i +
                ", v=" + v +
                ", p=" + p +
                ", q=" + q +
                ", val=" + val +
                ", g1=" + g1 +
                ", g2=" + g2 +
                '}';
    }
}
