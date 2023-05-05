package com.lt.sfday01;

//进制转换 16-->10

import java.util.Scanner;

public class JZZH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//默认输入合法的16进制数，代码中不做校验

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            //跳出当前循环
            if (str == null || str.length() <= 3){
                continue;
            }
            //结束循环--exit
            if (str.equals("exit")){
                return;
            }
            String num = str.substring(2).toLowerCase();
            //方式1
            System.out.println("方式1:" + Integer.parseInt(num,16));
            //方式2
            int count = 0;
            int len = num.length();
            for (int i = len-1; i >= 0 ; --i) {
                char temp = num.charAt(len-1-i);
                if (temp - '0' >= 0 && temp - '0' <= 9) {
                    count += (temp - '0') * Math.pow(16, i);
                }else {
                    count += (temp - 'a' + 10) * Math.pow(16, i);
                }
            }
            System.out.println("方式2:" + count);
        }
    }
}
