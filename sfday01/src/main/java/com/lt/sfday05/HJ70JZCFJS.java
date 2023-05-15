package com.lt.sfday05;

//HJ70 --矩阵乘法计算量估算

import java.util.*;

/**
 * 我们用一个栈记录代表矩阵的字符，遍历运算法则字符串，遇到右括号则弹出栈中前两个矩阵，
 * 计算测试，并更新前面个矩阵的行列为运算后的矩阵的行列，遇到左括号不做任何事，
 * 遇到其他字符就加入栈中。 这里是默认了一个左括号匹配一个右括号，运算式不会有问题，题目也是这样安排的。
 */
public class HJ70JZCFJS {

    //矩阵乘法次数计算公式 A * B =  A行 * B列 * A列 最终结果结果为A行B列

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            //矩阵乘法次数计算公式 A * B =  A行 * B列 * A列 最终结果结果为A行B列
            int num = Integer.parseInt(sc.nextLine()); //总共有多少个矩阵
            Map<Character, String[]> map = new HashMap<>();//存放矩阵字母及对应的行列信息   还有两个矩阵相乘后 代表结果的行列信息

            for(int i = 0; i<num; ++i){ //将字母及对应的行列信息存放进map
                String[] str = sc.nextLine().split(" ");//str[0]--行 str[1]--列
                map.put((char)('A'+i), str); //字母从大写A开始 每次循环顺序加1 eg：A-》B-》C...
            }
            String rule = sc.nextLine();//最后一行为计算规则

            int count = 0;//记录总数

            Stack<Character> sk = new Stack<>();//定义栈来存放规则中的字母(A~Z) 及 临时矩阵代表的字母(a开始...)
            //将每次的经过计算的结果看作一个矩阵 从小写a开始 记录 这个临时矩阵的行列信息 将临时矩阵的行列信息及代表字母存进map 将字母入栈

            for(int i=0; i<rule.length();++i){
                //遇到左括号什么也不做
                if(rule.charAt(i) == '(') continue;
                //遇到字母直接入栈
                if(rule.charAt(i) >= 'A' && rule.charAt(i) <= 'Z') {
                    sk.add(rule.charAt(i));

                }
                //遇到右括号弹出两个字母计算 并将结果重新压入栈中 直至栈为空
                if(rule.charAt(i) == ')') {
                    String[] arr2 = map.get(sk.pop()); //栈 --后进先出 先弹出来的是后面的元素
                    // eg：栈[A,B,C] 第1次pop()拿到C 第2次pop()拿到B 计算B*C = B行 * C列 * B列
                    String[] arr1 = map.get(sk.pop());

                    //存放的是字符串数组 所以需要转换成int 再进行计算  arr[0]--行   arr[1]--列
                    count += Integer.parseInt(arr1[0]) * Integer.parseInt(arr2[1]) * Integer.parseInt(arr1[1]);

                    if(sk.isEmpty()){ //每次出栈两个元素 ，出栈后元素为空 说明已计算结束
                        System.out.println(count);
                        return;
                    }else{ //不为空 将临时结果分别存进map和栈 map存放字母及行列信息 栈存放字母
                        //之所以字母用 (char)('a'+i) 表示 为了保证字母唯一 避免map中出现值覆盖的情况
                        map.put((char)('a'+i), new String[]{arr1[0],arr2[1]});//第一个矩阵的行 和第二个矩阵的列 就是临时矩阵的行列信息
                        sk.add((char)('a'+i));
                    }
                }
            }

        }
    }
}
