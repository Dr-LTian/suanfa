package com.lt.sfday06;

import java.util.*;

//NC52--有效括号序列  借助栈 --先进后出

/*
给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

输入：
    "["
返回值：
    false

    思路：借助栈先进后出，遇到左括号将对应的右括号放入栈中，遇到右括号时出栈与当前括号匹配 如果合法是可以匹配的
    匹配失败返回false 遍历完字符串返回栈是否为空 如果字符串合法 入栈出栈数量一致 最终为空
 */
public class NC52KHXL {
    public static void main(String[] args) {
        System.out.println(isValid("([]{}(()[]))"));
    }

    public static boolean isValid (String s) {

        Stack<Character> stack = new Stack<>();
        //将字符串拆分成字符数组放入栈中
        for (Character ch : s.toCharArray()){
            if(ch == '('){ //预期匹配')'
                stack.push(')');
            }else if(ch == '['){ //预期匹配']'
                stack.push(']');
            }else if(ch == '{'){ //预期匹配'}'
                stack.push('}');
            }else if(stack.empty() || stack.pop() != ch){ //如果栈为空说明第一个字符为右括号
                //栈不为空说明前一个字符为左括号,走到这个if必然是右括号，将之前压入栈的栈顶元素取出并匹配，不相等返回false
                //如果合法遇到的第一个右括号的前一个字符必然是对应的左括号
                return false;
            }
        }
        return stack.empty();// 如果合法栈应该出栈变为空
    }
}
