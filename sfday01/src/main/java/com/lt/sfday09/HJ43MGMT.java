package com.lt.sfday09;

import java.util.*;

//HJ43 迷宫问题
public class HJ43MGMT {
    /**
     * 5 5
     * 0 1 0 0 0
     * 0 1 1 1 0
     * 0 0 0 0 0
     * 0 1 1 1 0
     * 0 0 0 1 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] num = sc.nextLine().split(" ");
            int row = Integer.parseInt(num[0]);
            int col = Integer.parseInt(num[1]);
            String[][] arr = new String[row][col];
            for(int i=0; i< Integer.parseInt(num[0]); ++i){
                arr[i] = sc.nextLine().split(" ");
            }
            int[][] zbArr = new int[row][col];
            for(int i=0; i<row; ++i){
                for(int j=0;j<col;++j){
                    zbArr[i][j] = Integer.parseInt(arr[i][j]);
                }
            }
            //定义一个二位数组长宽与入参相同 记录走过的坐标
            boolean[][] visited = new boolean[row][col];//boolean基础类型 默认值为false
            //定义一个list 记录走过的坐标
            List<ZB> list = new ArrayList<>();

            //递归
            search(zbArr, new ZB(0,0),list, visited);

            System.out.println(list);
        }
    }

    public static void search(int[][] arr,ZB zb,List<ZB> list,boolean[][] visited){

        //当前坐标是目标坐标，记录并直接返回
        int row = arr.length;
        int col = arr[0].length;

        if(zb.x == row-1 && zb.y == col-1){
            list.add(zb);//list 按照添加顺序记录
            return;
        }

        //异常判断
        //越界
        if(zb.x <= -1 || zb.y <= -1 || zb.x > row || zb.y > col) return;
        //撞墙
        if(arr[zb.x][zb.y] == 1){
            return;
        }

        //将当前坐标记为走过  并将当前坐标记入数组
        visited[zb.x][zb.y] = true;
        if(!list.contains(zb)) list.add(zb);
//        System.out.println("list:" + list);

        //判断当前坐标的四个方位是否可行
        //向上
        if(zb.x-1 >= 0 && arr[zb.x - 1][zb.y] != 1 && !visited[zb.x - 1][zb.y]){
            search(arr, new ZB(zb.x-1, zb.y,zb),list, visited);
        }
        //向下
        else if(zb.x+1 <= row-1 && arr[zb.x + 1][zb.y] != 1  && !visited[zb.x + 1][zb.y]){
            search(arr, new ZB(zb.x+1, zb.y,zb),list, visited);
        }
        //向左
        else if(zb.y-1 >= 0 && arr[zb.x][zb.y -1] != 1  && !visited[zb.x ][zb.y-1]){
            search(arr, new ZB(zb.x, zb.y-1,zb),list, visited);
        }
        //向右
        else if(zb.y+1 <= col-1 && arr[zb.x][zb.y+1] != 1  && !visited[zb.x][zb.y+1]){
            search(arr, new ZB(zb.x, zb.y+1,zb),list, visited);
        }else{
            //走到死路 找到上一个坐标再进行判断
            list.remove(zb);
            search(arr, zb.pre ,list, visited);
        }
    }
}

class ZB {
    int x;
    int y;
    ZB pre;//上一个坐标
    ZB(){}
    ZB(int x,int y){
        this.x = x;
        this.y = y;
    }
    ZB(int x,int y,ZB zb){
        this.x = x;
        this.y = y;
        this.pre = zb;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}