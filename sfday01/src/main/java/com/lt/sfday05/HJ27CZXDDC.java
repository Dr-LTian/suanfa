package com.lt.sfday05;

import java.util.*;

//HJ27--查找兄弟单词
public class HJ27CZXDDC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split(" ");
            int num = Integer.parseInt(arr[0]);//单词字典数
            String target = arr[num + 1];//目标单词
            int k = Integer.parseInt(arr[num + 2]);//在单词字典中第几个单词， k从1开始

            List<String> xdList = new ArrayList<>();//保存兄弟单词list

            char[] sortTarget = target.toCharArray();//将目标单词转字符数组排序
            //-- 如果与单词字典中的单词排序后一致说明是兄弟单词
            Arrays.sort(sortTarget);

            for(int i = 1; i<=num; ++i){ //arr[1]~arr[num] 是单词字典
                if(arr[i].equals(target) || arr[i].length() != target.length()){//如果等于目标单词或长度不一致直接跳过
                    continue;
                }
                char[] temp = arr[i].toCharArray();//将字典中的单词转字符数组排序
                Arrays.sort(temp);

                if(String.valueOf(temp).equals(String.valueOf(sortTarget))){//排序后一致为兄弟单词，保存进xdList
                    xdList.add(arr[i]);
                }
            }

            Collections.sort(xdList);//将兄弟单词字典排序

            System.out.println(xdList.size());

            if(k <= xdList.size()) //k从1开始，如果k从0开始下面不需要-1 当前判断不能=
                System.out.println(xdList.get(k-1));
        }
    }
}
