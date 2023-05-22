package com.lt.sfday11;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.Stack;

//HJ54 --表达式计算
public class HJ54BDSJS {
    public static void main(String[] args) throws ScriptException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();//表达式字符串
            //调用js脚本引擎
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");// nashorn || js || javascript
            //将字符串表达式作为js脚本进行运算
            System.out.println(engine.eval(str));

            //常规解法
            System.out.println(cal(str));
        }
    }

    //常规思路

    //不调用api 计算字符串表达式思路 将字符串数字转int存入栈中
    //加号直接入栈
    //减号 乘-1入栈
    //乘除 弹出栈一个元素与下一个元素计算后重新入栈
    //最后累加栈中元素
    //碰到括号用递归计算

    public static int cal(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        char[] chs = s.toCharArray();
        int index = 0;
        //初始化符号为'+'
        char sign = '+';
        //记录数字
        int number = 0;
        for (int i = 0; i < n; i++) {
            char ch = chs[i];
            //当前字符是空格，跳过
            if (ch == ' ')continue;
            //当前字符是数字，拼数字
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
            }
            //如果当前字符是小括号
            if (ch == '(') {
                //移到小括号后一位字符
                int j = i + 1; //左括号里的第一个字符下标
                //统计括号的数量
                int count = 1;
                while (count > 0) {
                    //遇到右括号，括号数-1
                    if (chs[j] == ')')count--;
                    //遇到左括号，括号数+1
                    if (chs[j] == '(')count++;

                    j++;//指针后移
                }
                //递归，解小括号中的表达式
                number = cal(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            //遇到符号，将数字处理后放进栈
            if (!Character.isDigit(ch) || i == n - 1) {
                //如果是'+',直接入栈
                if (sign == '+') {
                    stack.push(number);
                }
                //如果是'-',数字取相反数在入栈
                else if (sign == '-') {
                    stack.push(-1 * number);
                }
                //如果是'*',弹出一个数字乘后放入栈
                else if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                //如果是'/',弹出一个数字/后放入栈
                else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                //更新符号
                sign = ch;
                //刷新数字
                number = 0;
            }
        }
        //栈中数字求和得到结果
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
