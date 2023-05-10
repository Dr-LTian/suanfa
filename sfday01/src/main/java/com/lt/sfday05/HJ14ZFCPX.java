package com.lt.sfday05;

import java.util.Arrays;
import java.util.Scanner;

//HJ14 --字符串排序
public class HJ14ZFCPX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());//输入总数
            String[] arr = new String[num];
            for(int i=0; i<num; ++i){
                arr[i] = sc.nextLine();
            }
            Arrays.sort(arr);
            for(String str : arr){
                System.out.println(str);
            }
        }
    }
}
