package com.lt.sfday06;

import java.util.*;

//leetcode 面试题08.08.有重复字符串的排列组合
public class LC0808CFZFCPLZH {

    static  Set<String> set = new HashSet<>();//存放每一次排好序的字符串
    static char[] chars;//字符串转字符数组
    static int len; //字符数组长度
    static boolean[] used; //标记对应索引位置的字母是否被使用
    static StringBuffer sf = new StringBuffer();//将字符拼接成字符串 当长度等于字符数组长度时 输出

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("qqe")));
    }

    public static String[] permutation(String S) {
        chars = S.toCharArray();
        Arrays.sort(chars);
        len = chars.length;
        if (len == 0) return new String[0];//特殊情况判断
        used = new boolean[len];
        sf = new StringBuffer();

        dfs(0);//从第0个字符开始

        return set.toArray(new String[0]); //将set转字符串数组
    }

    public static void dfs(int depth){//每次添加一个字符进StringBuffer sf 并将这个字符标记为已使用过
        if(depth == len){ //当前字符串已经是一个排好序的结果了
            set.add(sf.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            //当前字符使用过  或  当前字符和上一个字符相同并且上一个字符还未被使用
            if(used[i] || i>0 && chars[i] == chars[i-1] && !used[i-1]){
                continue;
            }

            sf.append(chars[i]); //将当前字符拼接到sf中  depth+1
            used[i] = true; //将当前字符标记为已使用
            dfs(depth+1); //递归

            //想要执行到这一句 1、set中添加了新字符串 2、后续递归for循环中不存在满足条件的字符串
            sf.deleteCharAt(depth); 

            used[i] = false;
        }

    }
}
