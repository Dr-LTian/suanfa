package com.lt.sfday09;

//岛屿问题 leetcode 200 （技术面试高频考点）
public class LC200DYWT {
    public static void main(String[] args) {
        char[][] grid = new char[4][];
        grid[0] = new char[]{'1','1','1','1','0'};
        grid[1] = new char[]{'1','1','0','1','0'};
        grid[2] = new char[]{'1','1','0','0','0'};
        grid[3] = new char[]{'0','0','0','0','0'};

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];//记录遍历过的坐标

        int count = 0;

        //从grid[0][0]开始遍历grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != '0' && !visited[i][j]){ //只有遇到’1‘并且当前值还未被标记过  才进行搜索
                    count++;
                    //目的是将与当前为1的坐标相连的所有1的坐标标记为走过 这些相连的1整体看作一个岛屿
                    bl(new Point(i,j) , grid, visited);
                }
            }
        }

        return count;
    }

    //碰到1时进行搜索 默认传进来的坐标值都为1
    public static void bl(Point p, char[][] grid, boolean[][] visited) { //能传进来的值都为未走过的陆地值
        int row = grid.length;
        int col = grid[0].length;

        //将当前坐标标记为走过
        visited[p.x][p.y] = true;

        //向四个方向遍历 只要不越界 && 下一个坐标对应的值不为'0' && 下一个坐标值还未被标记为走过 就继续搜索标记

        //向上
        if(p.x-1 >= 0 && grid[p.x-1][p.y] != '0' && !visited[p.x-1][p.y]){
            bl(new Point(p.x-1, p.y), grid, visited);
        }
        //向下
        if(p.x+1 < row && grid[p.x+1][p.y] != '0' && !visited[p.x+1][p.y]){
            bl(new Point(p.x+1, p.y), grid, visited);
        }
        //向左
        if(p.y-1 >= 0 && grid[p.x][p.y-1] != '0' && !visited[p.x][p.y-1]){
            bl(new Point(p.x, p.y-1), grid, visited);
        }
        //向右
        if(p.y+1 < col && grid[p.x][p.y+1] != '0' && !visited[p.x][p.y+1]){
            bl(new Point(p.x, p.y+1), grid, visited);
        }
    }
}

class Point{
    Integer x;
    Integer y;

    Point(){}
    Point(Integer x,Integer y){this.x = x;this.y=y;}
}
