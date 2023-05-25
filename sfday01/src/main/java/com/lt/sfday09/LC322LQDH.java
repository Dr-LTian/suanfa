package com.lt.sfday09;

import java.util.*;

//LC322 --零钱兑换 ，也可搜索 动态规划相关题型 （技术面试高频考点）

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1


    思路: 动态规划 定义int[] dp 给其中每个元素填充amount+1 等价于填充Integer.MAX_VALUE 因为dp[i]实际最大只能到amount
    dp[0] = 0;
    从1开始for循环 dp[i] = Math.min(dp[i], 1+dp[i-选择的硬币面值])
    最后判断 dp[amount] == amount+1 等于说明不能组成合适的组合 返回-1 不等于就直接输出
 */
public class LC322LQDH {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount +1);
        dp[0] = 0;//总数为0时 需要的硬币数为0

        for (int i = 1; i <= amount; i++) { //每一次的状态
            for (int coin : coins) { //每一次的选择
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
