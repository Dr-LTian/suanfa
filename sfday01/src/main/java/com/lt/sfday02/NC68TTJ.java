package com.lt.sfday02;

//NC68--跳台阶 n阶台阶f(n) = f(n-1) + f(n-2)    f(0) = f(1) = 1
//1-1-2-3-5-8-13-21
public class NC68TTJ {
    public static void main(String[] args) {
        NC68TTJ ttj = new NC68TTJ();
        System.out.println("动态规划:" + ttj.jumpFloor(6));
        System.out.println("递归:" + ttj.jumpFloor2(6));
    }

    public int jumpFloor(int target) {
        //动态规划 f(n) = f(n-1) + f(n-2)
        //定义3个变量，分别对应 f(n)、f(n-1)、f(n-2)
        int fn = 1; //f(0) = f(1) = 1
        int fn_1 = 1;
        int fn_2 = 1;
        //target = 0\1 时，直接返回 1，大于等于2时进入for循环
        for(int i = 2; i <= target; i++){
            //第三项开始是前两项的和,然后保留最新的两项，更新数据相加
            fn = (fn_1 + fn_2);
            fn_1 = fn_2;
            fn_2 = fn;
        }
        return fn;
    }

    public int jumpFloor2(int target) {
        //递归 f(n) = f(n-1) + f(n-2)
        //target = 0\1 时，直接返回 1
       if(target == 0 || target ==1)
           return 1;
        //大于等于2时进入递归
        return jumpFloor2(target-1) + jumpFloor2(target-2);
    }
}
