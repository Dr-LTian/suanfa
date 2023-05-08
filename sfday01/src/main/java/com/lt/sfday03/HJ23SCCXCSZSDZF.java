package com.lt.sfday03;

//HJ23--删除出现次数最少的字符

import java.util.*;

public class HJ23SCCXCSZSDZF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            Map<Character,Integer> map = new HashMap<>();//存放每个字符及其出现的次数
            for(Character ch : str.toCharArray()){
//                if(map.containsKey(ch)){
//                    map.put(ch, map.get(ch)+1);//如果不是第一次出现,给出现的次数加1
//                }else{
//                    map.put(ch, 1);
//                }
                map.put(ch, map.getOrDefault(ch,0) + 1);
            }
            Collection<Integer> values = map.values();//拿到所有的出现次数集合
            Integer minVal = Collections.min(values);//借助集合工具类找到最小值
            Set<Character> chars = map.keySet();//拿到map中所有的key
            for (Character ch : chars) {
                if(minVal == map.get(ch)){//如果对应key的value为最小值
                    str = str.replaceAll(ch.toString(), "");//将该字符替换为"",即删除该字符
                }
            }
            System.out.println(str);
        }
    }
}
