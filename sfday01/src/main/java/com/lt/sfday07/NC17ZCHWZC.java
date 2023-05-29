package com.lt.sfday07;

//NC17 --最长回文子串

/*
    对于长度为n的一个字符串A（仅包含数字，大小写英文字母），请设计一个高效算法，计算其中最长回文子串的长度。

    思路1:暴力破解 双重for循环 外层从0遍历到最后 内层从最后往前遍历 找出字符串中每个字符开头的最长回文串长度

    思路2:中心扩散法 两种情况 一种以当前字符为中心扩散 另一种以当前字符和下一个字符共同作为中心扩散 比较两边的元素是否相同
 */
public class NC17ZCHWZC {
    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("ababc"));
        System.out.println(getLongestPalindrome2("ababc"));
        System.out.println(getLongestPalindrome3("ababc"));
        System.out.println(getLongestPalindrome4("ababc"));
    }

    public static int getLongestPalindrome4(String A) {
        if(A.length() == 0) return 0;
        int maxlen = 1; //单个字符相当于回文 长度为1

        for(int i=0; i<A.length();++i){
            //ABA型
            int len1 = getMaxLen(i,i,A);
            //ABBA型
            int len2 = getMaxLen(i,i+1,A);
            maxlen = Math.max(maxlen, Math.max(len1, len2));
        }

        return maxlen;
    }

    public static int getMaxLen(int left, int right, String str){
        while(left>=0 && right<str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right -left +1-2;
    }

    public static int getLongestPalindrome (String A) {
        if(A.length() == 0) return 0; //长度为0直接返回0

        int maxLen = 1; //单个字符相当于回文 默认长度为1

        //中心扩展法
        //找到所有与第i位元素相同的元素
        //将其当作中心、再向两边扩散
        for(int i = 0; i<A.length();i++){
            int len = 1; //当前回文串长度,单个字符相当于回文 默认长度为1
            int left = i - 1;  //中心元素的左元素
            int right = i + 1; //右元素

            //先找左边相同元素，left--
            while(left >= 0 && A.charAt(i) == A.charAt(left)){
                left--;
                len = left >= 0 ? right - left -1 : right;
            }

            //右边元素相同， right++
            while(right < A.length() && A.charAt(i) == A.charAt(right)){//右边字符串相同
                right++;
                len++;
            }
            //相同元素找完之后，判断两边是否相等
            while(left >= 0 && right< A.length() && A.charAt(left) == A.charAt(right)){
                left--;
                right++;
                len +=  2; //b0 a1 a2 a3 b4 c5 c6 c7
            }
            maxLen = Math.max(maxLen,len); //将当前循环的找到的回文串长度与之前的做比较，找出最大的长度
        }

        return maxLen;
    }

    public static int getLongestPalindrome2 (String A) {
        if(A.length() == 0) return 0; //长度为0直接返回0

        int maxLen = 1; //单个字符相当于回文 默认长度为1

        //中心扩展法
        //找到所有与第i位元素相同的元素
        //将其当作中心、再向两边扩散
        for(int i = 0; i<A.length();i++){
            int len = 1; //当前回文串长度,单个字符相当于回文 默认长度为1
            int left = i - 1;  //中心元素的左元素
            int right = i + 1; //右元素

            int flag;//如果右边有相同元素，则下一次循环直接跳到 next非相同元素

            //右边元素相同， right++
            while(right < A.length() && A.charAt(i) == A.charAt(right)){//右边字符串相同
                right++;
                len++;
            }

            flag = right;//如果有相同元素，则right - flag >=2;如果没有 right = i+1 = flag+1

            //相同元素找完之后，判断两边是否相等
            while(left >= 0 && right< A.length() && A.charAt(left) == A.charAt(right)){
                left--;
                right++;
                len +=  2; //b0 a1 a2 a3 b4 c5 c6 c7
            }
            maxLen = Math.max(maxLen,len); //将当前循环的找到的回文串长度与之前的做比较，找出最大的长度

            if(flag - 1 > i) i = flag; //满足条件相等于有相同元素
        }

        return maxLen;
    }

    //暴力破解
    public static int getLongestPalindrome3(String A) {
        if(A.length() == 0) return 0;
        int maxlen = 1; //单个字符相当于回文 长度为1
        StringBuffer sf = new StringBuffer();
        //找出每个字符开头的最长回文子串 最后找出最长的放在maxlen中返回
        for(int i=0;i<A.length();++i){
            for(int j=A.length(); j>i; j--){
                String temp = A.substring(i,j);
                if(sf.append(temp).reverse().toString().equals(temp)){
                    maxlen = Math.max(maxlen, j-i);
                }
                sf.setLength(0);
            }
        }
        return maxlen;
    }
}
