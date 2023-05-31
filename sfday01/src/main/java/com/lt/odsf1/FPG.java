package com.lt.odsf1;

import java.util.Scanner;

public class FPG {
    /*
    就是 A 和 B分苹果，苹果有好多个， 如果苹果分成两堆后，

    A想用二进制相加不进位（其实这就是 异或）的算法使两堆的值相等，那就算满足A的要求了

    B要在满足A的情况下，分到的最多。如果满足不了A的要求，就输出 -1 。

    思路: 满足A 所有异或结果为0  异或运算符: ^
         B要最大 只需要找出这些苹果中的最小值给A 其余的给B

    输入：
    3
    3 5 6
    输出：
    11

    输入:
        8
        7258 6579 2602 6716 3050 3564 5396 1773
    输出:
        35165
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            int num = Integer.parseInt(sc.nextLine());
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            sc.nextLine();

            int minVal = arr[0];
            int res = arr[0];
            for (int i=1;i<num;++i){
                res = res ^ arr[i];
                if(arr[i]<minVal){
                    minVal = arr[i];
                }
            }
            if(res == 0){//可以满足A

                for(int i: arr){
                    res += i;
                }
                System.out.println(res - minVal);
            }else{ //不能满足A
                System.out.println(-1);
            }
        }
    }
}
