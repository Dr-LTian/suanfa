package com.lt.sfday03;

import java.util.Scanner;

//HJ33 --整数与IP地址间的转换

/**
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 * 思路1: 借助二进制
 *      IP转10进制：将ip每一位转为8位2进制 不足8位左补0 最后变为32位的2进制数 借助Long.parseLong(num, radix:2)转为10进制
 *      10进制转IP：将10进制数转为2进制字符串 不足32位左补0 每8位一截转10进制数 最后用.拼接
 * 思路2: 不借助2进制  ip地址实际上是256进制下的四位数字 8位2进制对应的256进制的1位,转化位32位2进制等同于转为4位256进制数
 *      IP转10进制：eg:ip--A.B.C.D  A*256^3 + B*256^2 + C*256^1 + D*256^0 Math.pow(256,i)--256的i次方
 *      10进制转IP：10进制数对256求余 取模运算 第一位余数就是IP的最低位 然后除以256继续取模 得到倒数第二位 以此类推
 */
public class HJ33ZSYIPZH {
    /*
     自测输入:
        10.3.3.193
        167969729
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.contains(".")){ //包含"."说明是ip
                //parseXXX(String str, int radix)--指的是将str看作radix进制的数并将其转化为10进制数
                System.out.println("2进制转化:" + ip2Num(str));//将拼接好的字符串转换为10进制
                System.out.println("256进制转化:" + ip2Num2(str));//直接转256进制
            }else{// 10进制数转ip
                System.out.println("2进制转化:" + num2Ip(Long.parseLong(str)));
                System.out.println("256进制转化:" + num2Ip2(Long.parseLong(str)));
            }
        }
    }

    public static String num2Ip(Long num){
        //借助2进制
        StringBuilder binStr = new StringBuilder(Long.toBinaryString(num));
        while(binStr.length() < 32) { //循环补0，补足32位
            binStr.insert(0, "0");
        }

        String[] ipds = new String[4];//定义数组保存4个ip段
        for (int i = 0; i < 4; i++) {
            String ipd = binStr.substring(i * 8, (i + 1) * 8);//每次截取8位字符串
            ipds[i] = String.valueOf(Integer.parseInt(ipd, 2));//将8位2进制字符串转为10进制数,并放在数组中
        }
        return String.join(".", ipds); // 用“.”拼接字符串数组
    }

    public static Long ip2Num(String ip){
        //借助2进制
        String num = "";
        String[] ipds = ip.split("\\.");

        for (String ipd : ipds) {
            String binStr = Integer.toBinaryString(Integer.parseInt(ipd));
            binStr = String.format("%08d", Integer.parseInt(binStr));//借助format左补0，补足8位
//            while(binStr.length() < 8) { //循环补0，补足8位
//                binStr = "0" + binStr;
//            }
            num = num.concat(binStr);//将4个8位2进制字符串拼接
        }
        return  Long.parseLong(num, 2);//将2进制字符串转为10进制数
    }

    //------------------------------------------------------------------------------------------

    public static String num2Ip2(Long num){
        //不借助2进制 --10进制和256进制
        String[] ipds = new String[4];
        for (int i = 0; i < 4; ++i) {
           ipds[3-i]  = String.valueOf(num % 256);
           num = num /256;
        }
//        System.out.println(Arrays.toString(ipds));
        return String.join(".", ipds);
    }

    public static Long ip2Num2(String ip){
        //不借助2进制 --10进制和256进制  2-4-8-16-32-64-128-256
        //ip地址实际上是256进制下的四位数字 8位2进制对应的256进制的1位,转化位32位2进制等同于转为4位256进制数

        String[] ipds = ip.split("\\.");
        long num = 0L;
        for (int i = 3; i >= 0; --i) {
            num += (long)(Math.pow(256,i) * Integer.parseInt(ipds[3-i]));
        }
        return  num;
    }
}
