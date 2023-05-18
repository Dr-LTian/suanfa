package com.lt.sfday09;

import java.util.*;

//剑指 Offer JZ61. 扑克牌中的顺子(类比 德州扑克问题)
public class JZ61PKPSZ {
    public static void main(String[] args) {
        int[] nums = new int[]{6,0,2,0,4};
        System.out.println(IsContinuous(nums));
    }

    public static boolean IsContinuous(int[] numbers) {
        Arrays.sort(numbers); //排序
        Set<Integer> set = new HashSet<>(); //存放非0参数
        int sum0 = 0; // 统计0的个数
        for(int i: numbers){
            if(i==0)sum0++;
            else set.add(i);
        }

        switch (sum0){ //0可以代表任意值 想表示顺子 1、不能有重复元素(用set去重) 2、除0外最大值和最小值差值必须小于等于4
            case 4: return true;
            case 3:
            case 2:
            case 1:
            case 0:
                if( numbers[4] - numbers[sum0]> 4 || set.size()+sum0 < 5){
                return false;
                }
            default: return true;
        }

    }
}
