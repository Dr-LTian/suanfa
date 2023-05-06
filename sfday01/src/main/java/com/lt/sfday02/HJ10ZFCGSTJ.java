package com.lt.sfday02;

import java.util.*;

//HJ10  字符串个数统计
public class HJ10ZFCGSTJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            String str = sc.nextLine();

            Set<Character> set = new HashSet<>();//借助set去重
            for (int i=0; i<str.length(); ++i){
                set.add(str.charAt(i));
            }
            System.out.println(set.size());
        }
    }
}
