package com.lt.sfday09;

import java.util.*;

//leetcode 322. 零钱兑换 ，也可搜索 动态规划相关题型 （技术面试高频考点）
public class LC322LQDH {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount +1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) { //每一次的状态
            for (int coin : coins) { //每一次的选择
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
