package com.lt.sfday06;

import java.util.*;

//NC52--括号序列  借助栈 --先进后出
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
