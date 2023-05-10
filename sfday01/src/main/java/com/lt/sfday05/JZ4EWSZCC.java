package com.lt.sfday05;

//JZ4 --二维数组中的查找  2分法查找

/**
 * 首先看四个角，左上与右下必定为最小值与最大值，
 * 而左下与右上就有规律了：左下元素大于它上方的元素，小于它右方的元素，右上元素与之相反。
 * 既然左下角元素有这么一种规律，相当于将要查找的部分分成了一个大区间和小区间，
 * 每次与左下角元素比较，我们就知道目标值应该在哪部分中，于是可以利用分治思维来做。
 *
 *
 * step 1：首先获取矩阵的两个边长，判断特殊情况。
 * step 2：首先以左下角为起点，若是它小于目标元素，则往右移动去找大的，若是他大于目标元素，则往上移动去找小的。
 * step 3：若是移动到了矩阵边界也没找到，说明矩阵中不存在目标值。
 */
public class JZ4EWSZCC {
    public static void main(String[] args) {
        //7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int [][] array = new int[4][4];
        array[0] = new int[]{1, 2, 8, 9};
        array[1] = new int[]{2, 4, 9, 12};
        array[2] = new int[]{4, 7, 10, 13};
        array[3] = new int[]{6, 8, 11, 15};
        System.out.println(Find(7,array));
    }

    public static boolean Find(int target, int [][] array) {
        //判断特殊情况 1、外层数组为空 2、内层数组为空
        if(array.length == 0) return false;//外层
        if(array[0].length == 0) return false; //内层

        int wclen = array.length;//外层长度
        int nclen = array[0].length; //内层长度

        //从二维数组左下角开始找，找到边界，没找到就是不存在
        //左下角第一个元素位置 array[wclen-1][0]
        //边界情况 j = nclen-1就算边界，但是是从左下角开始的
        //最坏的情况是找到右上角/右下角
        for(int i = wclen-1, j = 0; i>=0 && j<=nclen -1; ){
            if(target > array[i][j]){
                //目标值大于当前值,向右移动
                j++;
            }else if(target < array[i][j]){
                //目标值小，向上移动
                i--;
            }else {
                //相等返回true
                return true;
            }
        }

        return false;
    }
}
