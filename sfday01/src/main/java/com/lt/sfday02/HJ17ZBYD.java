package com.lt.sfday02;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//HJ17 --坐标移动

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 */
public class HJ17ZBYD {
    //测试用例: A10;S20;W10;D30;X;A1A;B10A11;;A10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while (sc.hasNextLine()){
            String[] zbs = sc.nextLine().split(";");//一系列坐标

            //流过滤也可在for循环中用if判断
            List<String> list = new ArrayList<>();
            for(String str : zbs){
                if(Pattern.matches("^[AWSD][0-9]{1,2}$",str)){
                    list.add(str);
                }
            }
//            List<String> list = Arrays.stream(zbs)
//                    .filter(zb -> Pattern.matches("^[AWSD][0-9]{1,2}$",zb))
//                    .collect(Collectors.toList());
//            System.out.println(Arrays.asList(zbs).toString());

            for (String zb : list) {
                //超过3层if..else可以考虑用switch..case
                int temp = Integer.parseInt(zb.substring(1));
                switch (zb.charAt(0)){
                    case 'A':
                        x -= temp;
                        break;
                    case 'W':
                        y += temp;
                        break;
                    case 'D':
                        x += temp;
                        break;
                    case 'S':
                        y -= temp;
                        break;
                }
//                if(zb.startsWith("A")){
//                    x -= Integer.parseInt(zb.substring(1));
//                }else if(zb.startsWith("W")){
//                    y += Integer.parseInt(zb.substring(1));
//                }else if(zb.startsWith("D")){
//                    x += Integer.parseInt(zb.substring(1));
//                }else if(zb.startsWith("S")){
//                    y -= Integer.parseInt(zb.substring(1));
//                }
            }
            System.out.println(list);
//            StringJoiner sj = new StringJoiner(",","(",")");
//            System.out.println(new StringJoiner(",").add(String.valueOf(x)).add(String.valueOf(y)));
            System.out.println(String.join(",",String.valueOf(x),String.valueOf(y)));
        }
    }
}
