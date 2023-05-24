package com.lt.sfday04;

//NC100 --字符串转整数

/*
写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。传入的字符串可能有以下部分组成:
1.若干空格
2.（可选）一个符号字符（'+' 或 '-'）
3. 数字，字母，符号，空格组成的字符串表达式
4. 若干空格

转换算法如下:
1.去掉无用的前导空格
2.第一个非空字符为+或者-号时，作为该整数的正负号，如果没有符号，默认为正数
3.判断整数的有效部分：
3.1 确定符号位之后，与之后面尽可能多的连续数字组合起来成为有效整数数字，如果没有有效的整数部分，那么直接返回0
3.2 将字符串前面的整数部分取出，后面可能会存在存在多余的字符(字母，符号，空格等)，这些字符可以被忽略，它们对于函数不应该造成影响
3.3  整数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231的整数应该被调整为 −231 ，大于 231 − 1 的整数应该被调整为 231 − 1
4.去掉无用的后导空格

    思路: 去除字符串前后空格 取第一位字符进行判断 记录数字正负号 第一位不为正负号 默认为正 第一位非数字返回0 是数字循环记值 同时判断边界值
    最后碰到非数字字符结束循环 输出最终结果
 */
public class NC100ZFCZZS {
    public static void main(String[] args) {
        System.out.println(StrToInt("82"));
    }

    public static int StrToInt (String s) {
        s = s.trim();//去除前后空格
        if(s.length() == 0 || s.matches("^[^0-9]+$")){ //长度为0或不包含数字 返回0
            return 0;
        }
        int sign = 1;//定义符号位，默认为正

        if(s.substring(0,1).equals("-")){ //正常的可以转化的第一位是符号位
            sign = -1;
        }
        if(s.substring(0,1).equals("+") || s.substring(0,1).equals("-")){ //有符号位就将符号位截取掉
            s = s.substring(1);
            if(s.length() == 0) return 0; //去除符号位后长度为0 返回0
        }

        if(s.substring(0,1).matches("^[^0-9]+$")){return 0;} //去除符号位第一位不是数字  返回0

        while(s.substring(0,1).equals("0")){ //去除数字开头的0
            s = s.substring(1);
            if(s.length() == 0) return 0;
        }

//        int index = -1;//定义下标，如果剩余字符串中存在非数字字符，找到第一个出现的非数字字符的下标
        int res = 0;
        for(Character ch : s.toCharArray()){
            if(ch < '0' || ch > '9'){
//                index = s.indexOf(ch);
                break;
            }
            //越界 如果上一个字符串对应的值大于Integer.MAX_VALUE / 10  || 等于并且最后一位的值大于Integer.MAX_VALUE % 10
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (ch - '0') > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (ch - '0') > -(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;

            res = (ch - '0') * sign + res * 10; //相当于右补0，第一次进来是10的0次方，以此类推
        }

        return res;

//        if(index != -1){ //不等于-1 index对应第一个非数字字符下标，截取出数字字符
//            s = s.substring(0,index);
//        }
//        if(s.length()>10 && sign == -1){ //int最大长度为10
//            return Integer.MIN_VALUE;
//        }
//        if(s.length()>10 && sign == 1){
//            return Integer.MAX_VALUE;
//        }
//        if(sign == -1 &&  Long.parseLong(s) * sign < Integer.MIN_VALUE) { //小于最小 输出最小
//            return Integer.MIN_VALUE;
//        }else if(sign == 1 &&   Long.parseLong(s) * sign > Integer.MAX_VALUE){//大于最大 输出最大
//            return Integer.MAX_VALUE;
//        }else{ //正常输出
//            return Integer.parseInt(s) * sign;
//        }
    }

    public static int StrToInt2 (String s) {
        s = s.trim();//去除前后空格
        if(s.length() == 0) return 0;//长度为0 返回0

        int sign = 1;//定义符号位，默认为正

        //截取第一位字符进行判断
        String n0 = s.substring(0,1);

        if(n0.equals("-") || n0.equals("+")){//有符号位就将符号位截取掉
            if(n0.equals("-")) sign = -1;
            s = s.substring(1);
            if(s.length() == 0) return 0;//长度为0 返回0
            n0 = s.substring(0,1);//长度不为0 继续截取第一位字符 赋值给n0
        }

        char ch = n0.toCharArray()[0];//首位字符 把字符串形式转为字符形式
        if(!Character.isDigit(ch)) return 0; //去除符号位后第一位不为数字返回0

        int res = 0;//定义最终输出的值
        for(Character c: s.toCharArray()){
            if(res == 0 && c == '0') continue;//去除无效的0
            if(!Character.isDigit(c)) break; //碰到非数字字符结束循环
            //越界 如果上一个字符串对应的值大于Integer.MAX_VALUE / 10  || 等于Integer.MAX_VALUE/10并且最后一位的值大于Integer.MAX_VALUE % 10
            if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && (c-'0')>Integer.MAX_VALUE%10){
                return Integer.MAX_VALUE;
            }
            if(res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && (c-'0') > Math.abs(Integer.MIN_VALUE%10)){
                return Integer.MIN_VALUE;
            }
            res = (c-'0') * sign + res * 10;//相当于右补0，第一次进来是10的0次方，以此类推
        }
        return res;
    }
}
