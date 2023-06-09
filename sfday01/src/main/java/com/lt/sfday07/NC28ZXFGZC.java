package com.lt.sfday07;

import java.util.HashMap;
import java.util.Map;

//NC28 --最小覆盖子串

/*
给出两个字符串 s 和 t，要求在 s 中找出最短的包含 t 中所有字符的连续子串。

注意：
如果 s 中没有包含 t 中所有字符的子串，返回空字符串 “”；
满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。

输入：
    "XDOYEZODEYXNZ","XYZ"
返回值：
    "YXNZ"

    思路: S长T短  在S中找T  利用map 把T中所有字符放入map中 key存字符 value存放出现的次数
    设置为负值 eg:"XYZX" -> {{X:-2},{Y:-1},{Z:-1}}

    在S中先截取一个长度等于T的子字符串放入map S中的字符放入map时放正值 如果map中没有负值说明子字符串包含所有T中字符
    将此子串放入最小字串 尝试移动左指针缩小子串 如果不出现负值说明可以缩小 出现负数继续移动右指针 以此遍历完S
 */
public class NC28ZXFGZC {
    public static void main(String[] args) {
        System.out.println(minWindow("XDOYEZODEYXNZ","XYZ")); //13 3
    }

    //滑动窗口--双指针 i j 同步向右移动
    public static String minWindow (String S, String T) {
        if(S.length() < T.length()) return "";
        String minStr = "";
        Map<Character,Integer> map = new HashMap<>();
        for (Character ch : T.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)  -1);
        }
        //第一次截取的字符串为(0, T.length())
        String str = S.substring(0, T.length());

        for (Character ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch ,0) + 1);
        }
        for (int i = 0,j = T.length()-1; i <= S.length() && j < S.length(); i++) {
            //只有第一次将第i~j位字符放进map，之后都只放判断map所有值是否为负数，负数移动j直至为正，正数进入下一次循环即向右移动i
            System.out.println("map--"+map);
            //如果是负数，向右移动j，重复进行判断
            while(map.values().stream().anyMatch(val ->  val < 0)){ //"X0 D O Y E Z5 O D E Y X10 N Z"
                j++;
                if(j >= S.length()) return minStr;
                map.put(S.charAt(j), map.getOrDefault(S.charAt(j), 0) + 1);
            }
            //不是负数则当前sub(i,j+1)满足条件 返回当前子串, 将第i位字符移出 map 再进行下一次循环
            str = S.substring(i, j+1);
            if(minStr.equals("") || minStr.length() > str.length()){
                minStr = str;
            }

            map.put(S.charAt(i), map.getOrDefault(S.charAt(i) ,0) - 1);
        }

        return minStr;
    }

//__________________________________________________________________________________
    //检查是否有小于0的
    static boolean check(int[] hash) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] < 0)
                return false;
        }
        return true;
    }

    public static String minWindow2 (String S, String T) {
        int cnt = S.length() + 1;
        //记录目标字符串T的字符个数
        int[] hash = new int[128];
        for(int i = 0; i < T.length(); i++)
            //初始化哈希表都为负数，找的时候再加为正
            hash[T.charAt(i)] -= 1;
        int slow = 0, fast = 0;
        //记录左右区间
        int left = -1, right = -1;
        for(; fast < S.length(); fast++){
            char c = S.charAt(fast);
            //目标字符匹配+1
            hash[c]++;
            //没有小于0的说明都覆盖了，缩小窗口
            while(check(hash)){
                //取最优解
                if(cnt > fast - slow + 1){
                    cnt = fast - slow + 1;
                    left = slow;
                    right = fast;
                }
                c = S.charAt(slow);
                //缩小窗口的时候减1
                hash[c]--;
                //窗口缩小
                slow++;
            }
        }
        //找不到的情况
        if(left == -1)
            return "";
        return S.substring(left, right + 1);
    }
}
