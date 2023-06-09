package com.lt.sfday05;

import java.util.Scanner;

//HJ65 --查找两个字符串a,b中的最长公共子串  --双指针\滑动窗口\动态规划

/*
查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！

思路： 双指针 定义两个指针, 遍历段字符串,截取短字符串,判断长字符串是否包含截取的子串
  左指针最开始指向第0位 右指针指向left+1 表示截取一位 判断子串是否在长字符串中出现
  如果包含右指针向后移动一位 继续判断
  不包含 左指针向后移动一位 右指针重置为left+1 继续进行判断 遍历完短字符串找出最长子串
 */
public class HJ65CZGGZC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        //确保先短后长 即s1 短   s2 长
        if(s1.length() > s2.length()){
            String temp = s2; //将短的值保存在临时变量中
            s2 = s1; //将长的值赋给s2
            s1 = temp; //短值赋给s1
        }

        //特殊情况判断
        if(s2.contains(s1)) {
            System.out.println(s1);
            return;
        }
        String result = "";
        //找最长公共子串 --双指针
        for (int left = 0; left < s1.length(); ++left) { //从第一位字符开始 找出每个字符开头的最大公共子串

            int right = left + 1; //每次进来保证右指针比左指针大1 即每次刚开始截取的是当前字符

            //当前字符是子串,移动右指针将当前子串变长
            while (s2.contains(s1.substring(left, right))){ //当前子串是公共子串,移动右指针继续进行判断

                if(result.length() == 0 || right - left > result.length()){ //将找到的最大子串赋值
                    result = s1.substring(left, right);
                }

                right ++;

                if (right > s1.length()) {//右指针最大只能到s1.length()
                    System.out.println(result);
                    return;
                }
            }
        }

    }

    public String maxLenStr(String s1, String s2){ //题解中的答案
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
        if (s1.length() > s2.length()) {
            // 确保s1比较短
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        // 存储最长子串
        String result = "";
        // 左指针
        int left = 0;
        // 右指针，从第一个字符开始移动
        int right = left + 1;
        while (right <= s1.length()) {
            String tmp = s1.substring(left, right);
            if (s2.contains(tmp)) {
                if (result.length() < tmp.length()) {
                    result = tmp;
                }
                // 是子串的情况下，只移动右指针
                right++;
            } else {
                // 左指针移动一位
                left++;
                right = left + 1;
            }
        }
//        System.out.println(result);
        return result;
    }
}
