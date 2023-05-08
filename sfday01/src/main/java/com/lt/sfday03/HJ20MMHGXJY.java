package com.lt.sfday03;

//HJ20--密码合格性检验

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *[A-Z]  [a-z] [0-9]
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * 换行：\n
 *
 * >1. *	匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*
 * >2. +	匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+
 * >3. .	匹配除换行符 \n 之外的任何单字符。要匹配 . ，请使用 \.
 */

/**
 * 自测输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 */
public class HJ20MMHGXJY {
    public static void main(String[] args) {
        //考验正则
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if (str.length() < 8 || str.contains(" ") || str.contains("\\n")){
                System.out.println("长度不符合、包含空串或换行--NG");
                System.out.println("NG");
                continue;
            }

            int count = 0; //保存匹配的种类数
            String[] regs = {"[0-9]", "[a-z]", "[A-Z]", "[^0-9a-zA-Z]"};

            //判断条件2  包括大小写字母.数字.其它符号,以上四种至少三种
            for (String reg : regs) {
                Pattern p = Pattern.compile(reg); //定义正则

                if(p.matcher(str).find()){ //看是否匹配
                    count++;
                }
            }
            if (count < 3){
                System.out.println("包含种类少于3种--NG");
                System.out.println("NG");
                continue;
            }

            boolean flag = true;//默认不包含公共子串
            //判断条件3  不能有长度大于2的包含公共元素的子串重复
            //str.substring(str.length()-3)截取出来的就是最后3位,保证str.substring(i+3)有3位即 i+3 <= str.length()-3  i <= str.length()-6
            for (int i = 0; i <= str.length()-3; i++) {
                if(str.substring(i+3).contains(str.substring(i,i+3))){
                    System.out.println("包含长度大于2的公共字串--NG");
                    System.out.println("NG");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("OK");
            }

        }
    }
}
