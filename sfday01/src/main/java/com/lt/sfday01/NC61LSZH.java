package com.lt.sfday01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//NC61 --两数之和

/**
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 */
public class NC61LSZH {

    public static void main(String[] args) {
        NC61LSZH lszh = new NC61LSZH();
        int[] res = lszh.twoSum(new int[]{2,3,4,1,5},9);
        int[] res2 = lszh.twoSum2(new int[]{2,3,4,1,5},9);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }

    public int[] twoSum (int[] nums, int target) {
        //定义默认输出
        int [] res = {-1,-1};
        //方式1--暴力枚举
        for(int i = 0; i< nums.length; ++i){
            for(int j=i+1; j<nums.length; ++j){
                if(nums[j] + nums[i] == target){
                    res[0] = i+1;// 返回的数组下标从1开始 所以给实际下标+1
                    res[1] = j+1;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] twoSum2 (int[] nums, int target) {
        //定义默认输出
        int [] res = {-1,-1};
        //方式2--map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; ++i){
            if(map.containsKey(nums[i])){ // 如果不为空，说明当前值等于之前存入的某个差值
                // 说明这一次的值和之前的某个值加起来等于target，可以通过map拿到之前的值的下标
                res[0] = map.get(nums[i]) + 1;//因为要按顺序输出，所以之前的值的下标应该在前
                res[1] = i +1;
                return res;
            }else{
                map.put(target - nums[i], i);//将差值与当前下标放入map
            }
        }
        return res;
    }
}
