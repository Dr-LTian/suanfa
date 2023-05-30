package com.lt.odsf1;

//https://exam.nowcoder.com/cts/17275616/summary?id=EA9F3C5241E742CE5D2B1AAD67C4DCC3

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZXJHCS {
    public static void main(String[] args) {
        /*
        样例1:
        nums=[1,3,1,4,0], k=2
        输出：1 ，解析：交换第一个1和4
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int k = Integer.parseInt(sc.nextLine());

            int[] arr = new int[str.length];
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
                if(arr[i] < k){
                    list.add(arr[i]);
                }
            }

            if(list.size() == 0 || list.size() == str.length){
                System.out.println(0);
                return;
            }

            //滑动窗口 长度为list.size()
            int n = list.size();
            int left = 0;
            int right = left + n - 1;//left+n-1<arr.len
            int minCount = Integer.MAX_VALUE;
            while(right<arr.length){
                int count = 0;
                for (int j = left; j <= right; j++) {
                    if(arr[j] > k){
                        count++;
                    }
                }
                minCount = Math.min(minCount, count);
                left++;
                right = left+n-1;
            }

            System.out.println(minCount);
        }
    }
}
