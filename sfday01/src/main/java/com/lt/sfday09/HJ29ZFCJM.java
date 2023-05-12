package com.lt.sfday09;

import java.util.Scanner;

//HJ29 字符串加解密
public class HJ29ZFCJM {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String yjm = sc.nextLine();
//            String jgm = sc.nextLine();
//
//            char[] jiam = new char[yjm.length()];
//            char[] jiem = new char[jgm.length()];
//
//            //加密
//            for(int i = 0 ; i< yjm.length(); ++i){
//                char ch = yjm.charAt(i);
//                if(ch >= 'a' && ch<= 'z'){
//                    if(ch == 'z') {
//                        jiam[i] = 'a';
//                    }else{
//                        jiam[i] = (char) (ch + 1);
//                    }
//                    jiam[i] = String.valueOf(jiam[i]).toUpperCase().charAt(0);
//                }else if(ch >= 'A' && ch<= 'Z'){
//                    if(ch == 'Z') {
//                        jiam[i] = 'A';
//                    }else{
//                        jiam[i] = (char) (ch + 1);
//                    }
//                    jiam[i] = String.valueOf(jiam[i]).toLowerCase().charAt(0);
//                }else if(ch>= '0' && ch<='9'){
//                    if(ch == '9') {
//                        jiam[i] = '0';
//                    }else{
//                        jiam[i] = (char) (ch + 1);
//                    }
//                }else{
//                    jiam[i] = ch;
//                }
//            }
//            //解密
//            for(int i = 0 ; i< jgm.length(); ++i){
//                char ch = jgm.charAt(i);
//
//                if(ch >= 'a' && ch<= 'z'){
//                    if(ch == 'a') {
//                        jiem[i] = 'z';
//                    }else{
//                        jiem[i] = (char) (ch - 1);
//                    }
//                    jiem[i] = String.valueOf(jiem[i]).toUpperCase().charAt(0);
//                }else if(ch >= 'A' && ch<= 'Z'){
//                    if(ch == 'A') {
//                        jiem[i] = 'Z';
//                    }else{
//                        jiem[i] = (char) (ch - 1);
//                    }
//                    jiem[i] = String.valueOf(jiem[i]).toLowerCase().charAt(0);
//                }else if(ch>= '0' && ch<='9'){
//                    if(ch == '0') {
//                        jiem[i] = '9';
//                    }else{
//                        jiem[i] = (char) (ch - 1);
//                    }
//                }else{
//                    jiem[i] = ch;
//                }
//            }
//
//            System.out.println(String.valueOf(jiam));
//            System.out.println(String.valueOf(jiem));
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String yjm = sc.nextLine();
            String jgm = sc.nextLine();

            char[] jiam = new char[yjm.length()];
            char[] jiem = new char[jgm.length()];


            System.out.println(String.valueOf(handleJJM(jiam, yjm, 0)));
            System.out.println(String.valueOf(handleJJM(jiem, jgm, 1)));

        }
    }




    //主函数中代码冗余 抽象出方法进行简化
    public static char handleXZM(char ch, int sign) { //处理小写字母  sign == 0 加密 sign == 1 解密
        if (sign == 0){
            if(ch == 'z') ch = 'a';
            else ch += 1;
        }else{
            if(ch == 'a') ch = 'z';
            else ch -= 1;
        }
        return String.valueOf(ch).toUpperCase().charAt(0);//小写字母转大写 加密加1 解密-1 首尾特殊情况特殊处理
    }

    public static char handleDZM(char ch, int sign) { //处理小写字母sign == 0 加密 sign == 1 解密
        if (sign == 0){
            if(ch == 'Z') ch = 'A';
            else ch += 1;
        }else{
            if(ch == 'A') ch = 'Z';
            else ch -= 1;
        }
        return String.valueOf(ch).toLowerCase().charAt(0);
    }

    public static char handleZM(char ch, int sign) { //处理字母  sign == 0 加密 sign == 1 解密
        if (sign == 0){
            if(ch == 'z') ch = 'a';
            else if(ch == 'Z') ch = 'A';
            else ch += 1;
        }else{
            if(ch == 'a') ch = 'z';
            else if(ch == 'A') ch = 'Z';
            else ch -= 1;

        }
        return ch;//只处理字符 不做大小写判断  ---也是一种思路
    }
    public static char handleSZ(char ch, int sign) { //处理数字 sign == 0 加密 sign == 1 解密
        if (sign == 0){
            if(ch == '9') ch = '0';
            else ch += 1;
        }else{
            if(ch == '0') ch = '9';
            else ch -= 1;
        }
        return ch;
    }

    public static char[] handleJJM(char[] arr, String str, int sign) { //处理加解密 sign == 0 加密 sign == 1 解密
        for(int i= 0; i< str.length(); ++i){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch<= 'z') arr[i] = handleXZM(ch,sign);
            else if(ch >= 'A' && ch<= 'Z') arr[i] = handleDZM(ch,sign);
            else if(ch >= '0' && ch<= '9') arr[i] = handleSZ(ch,sign);
            else arr[i] = ch;
        }
        return arr;
    }
}
