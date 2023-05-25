package com.lt.sfday07;

//LC674 --最长连续递增序列

/*
给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，
如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

思路: 判断下一个元素是否比当前元素大 大的话递增子串长度+1
     将最大子串长度与当前长度比较 找出大的赋值给最长递增子串长度
     如果后一个比当前的小 将指针移向后一个元素 重置当前长度 重新寻找
 */
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
