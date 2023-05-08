package com.lt.sfday02;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//HJ17--坐标移动
public class HJ17ZBYD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] zbs = str.split(";");

            //流过滤也可在for循环中用if判断
            List<String> list = Arrays.stream(zbs)
                    .filter(zb -> Pattern.matches("^[AWSD][0-9]{1,2}$",zb))
                    .collect(Collectors.toList());
            System.out.println(Arrays.asList(zbs).toString());

            for (String zb : list) {
                //超过3层if..else可以考虑用switch..case
                if(zb.startsWith("A")){
                    x -= Integer.parseInt(zb.substring(1));
                }else if(zb.startsWith("W")){
                    y += Integer.parseInt(zb.substring(1));
                }else if(zb.startsWith("D")){
                    x += Integer.parseInt(zb.substring(1));
                }else if(zb.startsWith("S")){
                    y -= Integer.parseInt(zb.substring(1));
                }
            }
            System.out.println(list);
//            StringJoiner sj = new StringJoiner(",","(",")");
            System.out.println(new StringJoiner(",").add(String.valueOf(x)).add(String.valueOf(y)));
        }
    }
}
