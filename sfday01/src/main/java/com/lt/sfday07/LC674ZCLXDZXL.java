package com.lt.sfday07;

//leetcode 674.最长连续递增序列
public class LC674ZCLXDZXL {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) { //双指针
        int left = 0;
        int right = left+1;
        int maxLen = 1; //最大长度

        while(right < nums.length){
            if(nums[right] > nums[right-1]){ //比较right指针元素及前一位元素 大于说明满足递增
                maxLen = Math.max(maxLen, right-left+1); //统计最大长度
            }else{
                left = right; //不满足条件将左指针移动至右指针处 即第一个不满足条件的位置
            }
            right++; //不论满足与否，每一次右指针移动一位
        }
        return maxLen;
    }
}
