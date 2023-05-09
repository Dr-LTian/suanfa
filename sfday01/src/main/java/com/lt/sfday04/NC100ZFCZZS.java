package com.lt.sfday04;

//NC100 --字符串转整数
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
}
