package com.lt.sfday09;

import java.util.LinkedList;
import java.util.Queue;

//leetcode 994.腐烂的橘子  多源广度优先算法BFS
public class LC994FLDJZ {
    static Queue<Point> queue = new LinkedList<>(); //广度优先算法需借助队列  先进先出
    static int count = 0; //新鲜橘子数
    static int depth = 0; //层数
    public static void main(String[] args) {
        int[][] grid = new int[3][]; //[[2,1,1],[1,1,0],[0,1,1]]
        grid[0] = new int[]{2,1,1};
        grid[1] = new int[]{1,1,0};
        grid[2] = new int[]{0,1,1};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        //定义一个二维数组 表示当前腐烂橘子的坐标 默认值为0
        int row = grid.length;
        int col = grid[0].length;

        //遍历grid 找出最开始的 新鲜橘子数 count  将最开始的腐烂橘子坐标放入队列 作为第0分钟第0层时的data
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
                else if(grid[i][j] == 2){
                    queue.add(new Point(i,j));
                }
            }
        }
        //广度优先算法
        bfs(grid, row, col);

        return count >0 ? -1 : depth; //如果BFS结束后新鲜橘子数仍大于0, 说明有新鲜橘子无法被污染返回-1 如果等于0 depth即分钟数（传播层数）
    }

    public static void bfs(int[][] grid, int row, int col) {
        //如果队列不为空继续下一层
        while (count>0 && !queue.isEmpty()){
            depth++; // 层数(分钟)+1
            int n = queue.size(); //记录当前层的数量

            for (int i = 0; i < n; i++) { //当前层有n个数据
                Point cur = queue.poll();
                //向4个方向传播 可以传播将 新鲜橘子数-1 将传播的位置改为2 并将传播的坐标计入queue作为下一层的数据
                //向上 边界值判断 及 目标坐标是否为新鲜橘子
                if(cur.x-1 >= 0 && grid[cur.x-1][cur.y] == 1){
                    count--; //可以污染时 新鲜橘子数-1
                    grid[cur.x-1][cur.y] = 2; //将目标坐标改为2
                    queue.offer(new Point(cur.x-1,cur.y)); //将目标坐标放入queue 作为下一轮的数据
                }
                //向下
                if(cur.x+1 < row && grid[cur.x+1][cur.y] == 1){
                    count--;
                    grid[cur.x+1][cur.y] = 2;
                    queue.offer(new Point(cur.x+1,cur.y));
                }
                //向左
                if(cur.y-1 >= 0 && grid[cur.x][cur.y-1] == 1){
                    count--;
                    grid[cur.x][cur.y-1] = 2;
                    queue.offer(new Point(cur.x,cur.y-1));
                }
                //向右
                if(cur.y+1 < col && grid[cur.x][cur.y+1] == 1){
                    count--;
                    grid[cur.x][cur.y+1] = 2;
                    queue.offer(new Point(cur.x,cur.y+1));
                }
            }
        }
    }
}
