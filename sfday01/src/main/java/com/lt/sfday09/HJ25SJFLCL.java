package com.lt.sfday09;

import java.util.*;

//HJ25 --数据分类处理

/*
描述
信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。

输入描述：
﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~(2^31)-1，序列个数不限

输出描述：
﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：

I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。

按R<i>从小到大的顺序:

(1)先输出R<i>；

(2)再输出满足条件的I的个数；

(3)然后输出满足条件的I在I序列中的位置索引(从0开始)；

(4)最后再输出I。

附加条件：

(1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉

(2)如果没有满足条件的I，对应的R<i>不用输出

(3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)

序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）

序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）

输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786

说明：

30----后续有30个整数

3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3

6--- 存在6个包含3的I

0--- 123所在的原序号为0

123--- 123包含3，满足条件

输入:
    15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
    5 6 3 6 3 0
输出:
    30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786

说明：
    将序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）排序去重后，可得0,3,6。
    序列I没有包含0的元素。
    序列I中包含3的元素有：I[0]的值为123、I[3]的值为453、I[7]的值为3、I[9]的值为453456、I[13]的值为453、I[14]的值为123。
    序列I中包含6的元素有：I[1]的值为456、I[2]的值为786、I[4]的值为46、I[8]的值为665、I[9]的值为453456、I[11]的值为456、I[12]的值为786。
    最后按题目要求的格式进行输出即可。

    思路: 先将序列R 去重并排序 借助treeSet 双重循环 外层 去重排序后的R 内层I 遍历I中时候包含R[i]
    包含累计计数 并输出对应下标及元素
 */
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
