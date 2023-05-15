package com.lt.sfday05;

//NC149 --kmp算法

import java.util.Arrays;

public class NC149KMPSF {
    public static void main(String[] args) {
        System.out.println(kmp("ababab","abababab"));
        System.out.println(fkmp("ababab","abababab"));
        System.out.println(Arrays.toString(getNext("ababab")));
    }

    public static int kmp (String S, String T) {
        //特殊情况判断
        if(T.length() == 0 || T.length() < S.length()) return 0;
        if(T.length() == S.length() && S.equals(T)) return 1;
        //定义出现子串总数
        int count = 0;
        //获取next数组
        int[] next = getNext(S);

        //遍历S、T字符串  以T为for循环的长度  i --代表T的索引  j--代表S的索引
        for (int i = 0, j = 0; i < T.length(); i++) {
            //不相等时 将j的索引改为next数组中的前一位 即每次找出不匹配之前的最长匹配位置
            while(j>0 && T.charAt(i) != S.charAt(j)){
                j = next[j-1];
            }

            //相等时 j++   i++
            if(T.charAt(i) == S.charAt(j)){
                j++;
            }
            //如果全部匹配 匹配次数+1 同时改变j的位置
            if(j == S.length()){
                count ++;
                j = next[j-1];
            }
        }

        return count;
    }

    public static int[] getNext(String S) {
        int[] next = new int[S.length()]; //int[] 默认值都为0

        for (int i = 1,j = 0; i < S.length(); ++i) { //i=1开始 next[0] = 0
            //不相等
            while(j>0 && S.charAt(i) != S.charAt(j)){
                j = next[j-1];
            }
            //相等
            if(S.charAt(i) == S.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static int fkmp (String S, String T) {// 非kmp算法 --直接截取计算  用时过长
         if(T.length() == 0 || S.length() > T.length()){
             return 0;
         }
         int count = 0;
         for(int i=0;i<=T.length() - S.length();++i){
             String str = T.substring(i, i+S.length());
             if(str.equals(S)) count++;
         }
         return count;
    }
}
