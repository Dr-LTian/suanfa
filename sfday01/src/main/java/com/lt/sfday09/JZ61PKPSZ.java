package com.lt.sfday09;

import java.util.*;

//JZ61 --扑克牌中的顺子(类比 德州扑克问题)

/*
描述
    现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
    有如下规则：
    1. A为1，J为11，Q为12，K为13，A不能视为14
    2. 大、小王为 0，0可以看作任意牌
    3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
    4.数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
输入描述：
    输入五张扑克牌的值
返回值描述：
    五张扑克牌能否组成顺子。

    思路： 2副牌 大小王为0 0可以看作任意牌 0最多有4个
    判断0的数量 0有4个肯定为顺子 非0值进行排序  不能有重复元素 有则不是顺子
    最大值和最小值之间的最大差值为4 超过4则不是顺子 eg : 1,0,0,0,5 如果最后一个元素为6 差值为5则不是顺子
 */
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
