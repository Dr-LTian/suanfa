package com.lt.sfday06;

import java.util.Stack;

//leetcode 1614--括号的最大嵌套深度
public class LC1614KHZDQTSD {
    public static void main(String[] args) {
        //"(1+(2*3)+((8)/4))+1"
        //"(1)+((2))+(((3)))"
        System.out.println(maxDepth2("(1+(2*3)+((8)/4))+1"));//
    }

    public static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(ch == '(' || ch == ')'){
                stack.push(ch);
            }
        }

        int depth = 0;
        int maxDepth = 0;
        while (!stack.empty()){ //栈先进后出，碰到一个右括号深度加1，碰到左括号深度-1
            if(!stack.contains(')')) break;

            if(stack.pop() == ')'){
                depth ++;
            }else{
                depth--;
            }
            maxDepth = Math.max(depth,maxDepth);
        }
        return maxDepth;
    }

    public static int maxDepth2(String s) {
        int depth = 0;
        int maxDepth = 0;
        for(Character ch : s.toCharArray()){
            if(ch == '(' ){
                depth ++;
                maxDepth = Math.max(depth,maxDepth);
            }else if(ch == ')'){
                depth--;
            }
        }
        return maxDepth;
    }
}
