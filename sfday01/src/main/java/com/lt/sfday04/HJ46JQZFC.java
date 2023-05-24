package com.lt.sfday04;

import java.util.Scanner;

//HJ46 -- 截取字符串

/*
    输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 */
public class HJ46JQZFC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());

            System.out.println(str.substring(0,k));
        }
    }
}
