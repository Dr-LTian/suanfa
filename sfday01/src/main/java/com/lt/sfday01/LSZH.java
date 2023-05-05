package com.lt.sfday01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两数之和
public class LSZH {

    public static void main(String[] args) {
        LSZH lszh = new LSZH();
        int[] res = lszh.twoSum(new int[]{2,3,4,1,5},9);
        int[] res2 = lszh.twoSum2(new int[]{2,3,4,1,5},9);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }

    /**
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] nums, int target) {
        //定义默认输出
        int [] res = {-1,-1};
        //方式1--暴力枚举
        for(int i = 0; i< nums.length; ++i){
            for(int j=i+1; j<nums.length; ++j){
                if(nums[j] + nums[i] == target){
                    res[0] = i+1;
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
