package com.lt.sfday06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//LC77 --组合

/*
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    你可以按 任何顺序 返回答案。

    1 <= n <= 20  1 <= k <= n

    思路:  范围 [1, n] k个数量的全排列  不重复的排列 递归dfs  --深度优先算法
    是否使用过boolean[] used 深度depth 或者说找到组合的长度 长度一致符合预期 集合类copy值 最后放入最终list
    使用过字符或字符比target数组末尾小跳出循环
    找到符合预期最后删除target末尾元素 并将末尾元素标记为未使用 继续寻找
 */
public class LC77ZH {

    boolean[] used;
    List<List<Integer>> list = new ArrayList<>(); //存放最终的结果
    int[] arr;
    List<Integer> target;
    public static void main(String[] args) {

    }
    public List<List<Integer>> combine(int n, int k) {
        //n个整数 k个数量的全排列 1 <= n <= 20  1 <= k <= n 不重复的排列
        arr = new int[n];
        for(int i=0; i<n;++i){
            arr[i] = i+1;
        }
        //记录当前元素是否被使用过
        used = new boolean[n];
        target = new ArrayList<>(k);
        //从arr数组中选取两个元素全排列
        dfs(target,0,n,k);
        return list;
    }

    public void dfs(List<Integer> target,int depth,int n,int k) {
        if(depth == k){ //长度相等 表示当前的target已经是一个符合预期的list了
            List<Integer> temp = Arrays.asList(new Integer[k]); //要调用集合工具类的copy方法，要求目标集合长度必须和源集合长度一致 有初值且不为null
            Collections.copy(temp, target);//将target的值copy进临时集合temp中
            list.add(temp); //将结果放进list中
            return;
        }

        for(int i=0;i<n;++i){
            //如果当前元素被使用 或 即将加入target的元素大于target中最后一个元素 跳出
            if(used[i] || target.size()>0 && arr[i]<target.get(target.size()-1) ){
                continue;
            }

            target.add(arr[i]);//加入集合
            used[i] = true; //标记当前元素被使用
            dfs(target,depth+1,n,k); //递归 直至找到预期值加入list 并 return跳出
            target.remove(depth); //删除当前已符合预期的target的尾部元素
            used[i] = false; //将当前已符合预期的target的尾部元素标记为未使用  下一次循环将使用next i
        }

    }
}
