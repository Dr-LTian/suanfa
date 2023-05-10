package com.lt.sfday05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//NC37 --合并区间
public class NC37HBQJ {

    /**
     * 定义内部类 区间类
     */
     static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    /**
     * 方法: 排序+贪心(推荐使用)
     * 知识点：贪心思想
     *
     * 贪心思想属于动态规划思想中的一种，其基本原理是找出整体当中给的每个局部子结构的最优解，
     * 并且最终将所有的这些局部最优解结合起来形成整体上的一个最优解。
     *
     * step 1：既然要求重叠后的区间按照起点位置升序排列，我们就将所有区间按照起点位置先进行排序。使用sort函数进行排序，重载比较方式为比较interval结构的start变量。
     * step 2：排序后的第一个区间一定是起点值最小的区间，我们将其计入返回数组res，然后遍历后续区间。
     * step 3：后续遍历过程中，如果遇到起点值小于res中最后一个区间的末尾值的情况，那一定是重叠，取二者最大末尾值更新res中最后一个区间即可。
     * step 4：如果遇到起点值大于res中最后一个区间的末尾值的情况，那一定没有重叠，后续也不会有这个末尾的重叠区间了，因为后面的起点只会更大，因此可以将它加入res。
     */
    //[[10,30],[20,60],[80,100],[150,180]]
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(10, 30));
        intervals.add(new Interval(20, 60));
        intervals.add(new Interval(80, 100));
        intervals.add(new Interval(150, 180));
        System.out.println(merge(intervals).toString());
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
         if(intervals.size() <= 0)
             return intervals;
        //找到有交集的区级合并

        //先将所有区间按照每个区间的start排序
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        ArrayList<Interval> list = new ArrayList<>();//保存最后合并完的区间集合

        list.add(intervals.get(0));//将按start排好序的第一个区间放入list中

        for(int i = 1; i < intervals.size(); ++i){
            Interval lastInterval = list.get(list.size()-1);//每次找出list的最后一个元素
            if(lastInterval.end >= intervals.get(i).start){ //有重叠更新end
                lastInterval.end = Math.max(lastInterval.end, intervals.get(i).end);
            }else{ //无重叠将当前元素放入list
                list.add(intervals.get(i));
            }
        }
        return list;
    }
}
