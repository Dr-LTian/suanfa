package com.lt.sfday09;

import java.util.*;

//火锅问题 csdn搜索
public class CSDNHGWT {
    /**
     * 和朋友一起吃火锅，有m个菜品，你的手速是n（即吃完一道菜，要经过时间n才能再去夹菜）
     * 任一菜品下锅后，都需要经过对应时间才能熟，过时就不可口了。怎样可以吃到最多的可口的菜。
     *
     * 输入：
     * 第1行：菜品数量m，手速n
     *
     * 之后有m行：每行两个数字，第一个数字代表下某菜的时间，第二个数字代表该菜下锅后到煮好需要的时间。
     *
     * 输出：
     *
     * 最多可以吃多少道菜
     *
     * 2 1
     * 1 2
     * 2 1
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //
            String[] arr = sc.nextLine().split(" ");
            int m = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);

            Food[] fds = new Food[m]; //foods
            for (int i = 0; i < m; i++) {
                fds[i] = new Food(sc.nextInt(), sc.nextInt()); //用nextInt当前行会有’回车‘还未读取处理 可用nextLine跳过此回车符
                sc.nextLine();
            }
            //定义一个数组 存放所有菜品被煮熟的时间 并排序
            int[] fgt = new int[m]; //food good time
            for (int i = 0; i < m; i++) {
                fgt[i] = fds[i].xct + fds[i].zst;
            }
            Arrays.sort(fgt);

            //fgt 排好序之后就是每个食物最可口对应的时间 即每样菜品能吃的时间

            //定义一个list保存 我从开始吃到下一次可以吃的时间 即吃的食物煮好的时间 fgt[i]+n
            List<Integer> list = new ArrayList<>();

            //要想吃到的菜品最多 那第一个煮好的菜品一定是要吃的
            list.add(fgt[0] + n);

            for (int i = 1; i < m; i++) {
                //每次取出list末尾的值 即 已经吃完上一道菜品并可以开始吃下一道菜品的时间
                if(list.get(list.size()-1) <= fgt[i]){
                    //如果这个时间小于等于下一道菜品煮好的时间 说明下一道菜品也可吃
                    list.add(fgt[i] + n);
                }
            }

            System.out.println(list.size());
        }
    }


}

class Food{
    int xct; //下菜时间
    int zst; //煮熟时间
    Food(){}
    Food(int xct, int zst){this.xct=xct;this.zst=zst;}
}
