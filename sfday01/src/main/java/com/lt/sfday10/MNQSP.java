package com.lt.sfday10;

import java.util.Scanner;

// 模拟试题 --汽水瓶
public class MNQSP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int num = Integer.parseInt(sc.nextLine());//输入空瓶数
            if(num == 0) return;
            int count = 0;
            while(num >= 3){
                count += num / 3; //是3的多少倍 就可以换多少瓶水继续喝至空瓶
                if(num % 3 == 0){ // 如果刚好是3的倍数 剩余空瓶数为num/3
                    num = num / 3;
                }else{ //有余数 剩余空瓶数则为 3的倍数(num/3) + 余数(num % 3)
                    num = num / 3 + num % 3;
                }
            }
            if(num == 2) count += 1;//最后余两空瓶 借一空瓶 总数加1

            System.out.println(count);
        }
    }
}
