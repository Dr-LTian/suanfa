package com.lt.sfday05;

import java.util.*;

//HJ27 --查找兄弟单词

/*
    定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
    兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
    现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
    注意：字典中可能有重复单词。

    输入描述：
        输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k
    输出描述：
        第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。

    输入：
        3 abc bca cab abc 1
    输出：
        2
        bca

     思路: 将字典单词中符合兄弟单词的单词放在一个数组或集合中 调用排序方法--升序排列
     然后判断k是否超出集合或数组长度
 */
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
