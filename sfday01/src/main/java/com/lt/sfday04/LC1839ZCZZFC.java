package com.lt.sfday04;

import java.util.Scanner;

//LC1839 --最长子字符串

/**
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 *
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 *
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 *
 * 子字符串 是字符串中一个连续的字符序列。
 *
 * 思路：遍历字符串 记录出现的元音字母种类 定义3个变量 最长美丽字串长度maxLen=0 当前美丽子串长度len=1 种类数type=1
 *      如果后一个字符 大于等于 前一个字符 (charAt(i) >= charAt(i-1))当前长度+1 (len++)
 *      如果后一个字符 大于 前一个字符 (charAt(i) > charAt(i-1))种类+1 (type++)
 *      如果后一个字符 小于 前一个字符 (charAt(i) < charAt(i-1))重置种类为1 当前长度为1 (len=1;type=1;)
 *      如果种类 等于 5 (type=5) 说明元音字母全部出现 更新最长美丽子串长度 (Math.max(maxLen, len))
 */
public class LC1839ZCZZFC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println("copy来的方法:" + longestBeautifulSubstring(str));
            System.out.println("自己改的方法:" + longestBeautifulSubstring2(str));
        }
    }

    public static int longestBeautifulSubstring(String word) {
        int ans = 0, type = 1, len = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) >= word.charAt(i-1)) len++; //更新当前字符串长度
            if(word.charAt(i) > word.charAt(i-1)) type++; //更新当前字符种类
            if(word.charAt(i) < word.charAt(i-1)) { type = 1; len = 1;} //当前字符串不美丽，从当前字符重新开始
            if(type == 5) ans = Math.max(ans, len);  //更新最大字符串
        }
        return ans;
    }

    //'a' ，'e' ，'i' ，'o' ，'u'---升序、统计种类数 =5即全部出现  'a' --最小  'u' --最大
    public static int longestBeautifulSubstring2(String word) {

        if(word.length() <5 || word.indexOf('a') == -1){ //长度不符合或者不包含'a'
            return 0;
        }

        int len = 0, type = 1, aIdx  = word.indexOf('a'); //长度通过a和u的下标计算 len = uIdx - aIdx + 1

        for(int i = word.indexOf('a') + 1; i < word.length(); i++){ //从第一个a元素的下一个字符开始,所以默认type为1

            if(word.charAt(i) > word.charAt(i-1)) type++; //当前字符大于前一个字符,更新当前字符种类 type+1
            else if(word.charAt(i) < word.charAt(i-1)) {
                // a 最小 u 最大 当出现小于的情况时，当前元素是相对小的，让第i个元素做基础元素 给type=1，
                // 在这基础上加，如当前元素不是a，type不可能加到5，就会再次碰到小于的情况，进行循环，只有第i个元素为a 才会type =5
                type = 1; //默认后续子串中还可能包含美丽子串，如不包含type值不可能到达5
                aIdx = word.substring(i).indexOf('a') + i;//重新计算a的下标
                continue;
            }

            if(type == 5) { //只有种类为5时才会修改美丽子串长度,type=5,代表当前元素为'u'
                //uIdx(uIdx = i) - aIdx + 1 为长度
                len = Math.max(len, i - aIdx + 1);  //更新最大字符串
            }
        }
        return len;
    }
}
