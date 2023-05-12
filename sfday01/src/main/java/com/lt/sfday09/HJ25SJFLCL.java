package com.lt.sfday09;

import java.util.*;

//HJ25. 数据分类处理
public class HJ25SJFLCL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String[] I = sc.nextLine().split(" ");//整数数组 输出需记录下标
            int iNum = Integer.parseInt(I[0]);

            String[] R = sc.nextLine().split(" ");//去重排序 treeSet
            int rNum = Integer.parseInt(R[0]);

            //存放I[1,I.length-1] 第一位为数量
            List<String> list = new ArrayList<>(Arrays.asList(I).subList(1, I.length));

            Set<Integer> set = new TreeSet<>();//存放R[1,R.length-1]
            for(int i =1;i<R.length;++i){
                set.add(Integer.parseInt(R[i]));
            }

            int count = 0;//输出中 字符总数

            StringBuffer sb = new StringBuffer();//除了总数count 外的所有输出字符

            StringBuffer sf = new StringBuffer();//每次符合R的输出字符
            for(Integer r : set){ //外层R --匹配规则
                int sum = 0; //每次符合总数
                for(int i = 0; i< list.size();++i){ //遍历I 去匹配R
                    if(list.get(i).contains(r.toString())){ //借助字符串的contains方法 所以list中放字符串而不转成int
                        sf.append(" ").append(i).append(" ").append(list.get(i));
                        sum++;
                    }
                }
                if(sum>0){//sum>0 代表当前R有匹配的I sf有值 拼接进sb
                    count += (sum + 1) * 2;
                    sb.append(" ").append(r).append(" ").append(sum).append(sf);
                    sf.setLength(0); //将sf置空
                }

            }
            System.out.println(count+sb.toString());
        }
    }
}
