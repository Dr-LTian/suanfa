package com.lt.odsf1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//栈中元素的合并 当前入栈元素小于栈顶元素 直接入栈
// 等于栈顶元素 乘以2倍在入栈
// 大于栈顶元素 判断是否可以右栈顶元素相加等于此元素 有则将栈中累计为此元素的值全出栈 再将此值乘以2放入栈中
/*
        eg:arr [6,1,2,3] =>栈向将数组第一个元素入栈:[6]  1比栈顶元素6小 直接入栈：[6,1]
        2比栈顶元素1大 6+1>2 所以不满足, 2入栈：[6,1,2]
        3大于栈顶元素2 但有1+2=3 所以1、2出栈 [6]  3*2即将入栈
        6等于6 所以6出栈[] 将2*6 入栈[12]
 */
public class ZYSHB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] strArr = sc.nextLine().split(" ");
            int[] arr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            Stack<Integer> sk = new Stack<>();
            sk.push(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                getStack(arr[i], sk, list);
            }

            while (!sk.isEmpty()){
                System.out.print(sk.pop()+" ");
            }
            System.out.println();
        }
    }

    public static void getStack(int cur, Stack<Integer> sk, List<Integer> list){
        if(sk.isEmpty()) return;
        if(cur < sk.peek()){
            sk.push(cur);
            list.add(cur);
            return;
        }else if(cur == sk.peek()){

            sk.pop();
            list.remove(list.size()-1);

            cur = 2 * cur;
            if(sk.isEmpty()){
                sk.push(cur);
                list.add(cur);
                return;
            }else{
                getStack(cur, sk, list);
            }

        }else{
            int t = 0;
            int count = 0;
            for (int i = list.size() -1; i >= 0; --i) {
                t += list.get(i);
                if(t>cur || t<cur && i==0){
                    count = 0;
                    break;
                }
                count++;
                if(cur == t) break;
            }
            if(count == 0) {
                sk.push(cur);
                list.add(cur);
                return;
            }else{
                for (int i = 0; i < count; i++) {
                    sk.pop();
                    list.remove(list.size()-1);
                }
                cur = 2 * cur;
                if(sk.isEmpty()){
                    sk.push(cur);
                    list.add(cur);
                    return;
                }else{
                    getStack(cur,sk,list);
                }
            }
        }
    }
}
