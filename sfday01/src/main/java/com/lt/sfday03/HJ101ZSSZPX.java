package com.lt.sfday03;

//HJ101--输入整型数组和排序标识，对其元素按照升序或降序进行排序

import java.util.*;

/**
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 输出描述：
 * 输出排好序的数字
 */
public class HJ101ZSSZPX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int count = Integer.parseInt(sc.nextLine());
            String[] arr = sc.nextLine().split(" ");
            int order = Integer.parseInt(sc.nextLine());// 0--升序  1--降序
            if (arr.length != count){
                continue;//输入数组长度不正确，跳出循环
            }
            System.out.println("集合工具类:" + JH(arr, order, count));
            System.out.println("集合工具类+自定义排序接口:" + JH2(arr, order));
            System.out.println("数组工具类+自定义排序接口:"  + SZ(arr, order));
        }
    }

    public static String JH(String[] arr,Integer order,Integer count) {
        //将String数组转为Integer的list集合
        List<Integer> list = new ArrayList<>(count);
        for (String s : arr) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);//集合类排序

        //转为String类型的list
        List<String> strList = new ArrayList<>(count);
        for (Integer i : list) {
            strList.add(String.valueOf(i));
        }
        //标志位为1降序输出,将集合反转即逆序，也可自定义实现Comparator接口
        if(order == 1){
            Collections.reverse(strList);//逆序
        }
        return String.join(" ", strList);
    }

    public static String JH2(String[] arr,Integer order) {

//        Collections.sort(Arrays.asList(arr), (o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
        Collections.sort(Arrays.asList(arr), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });//集合类排序
        //标志位为1降序输出,将集合反转即逆序，也可自定义实现Comparator接口
        if(order == 1){
            Collections.reverse(Arrays.asList(arr));//逆序
        }
        return String.join(" ", Arrays.asList(arr));
    }

    public static String SZ(String[] arr,Integer order) {
        if(order == 0) {
            //升序
//            Arrays.sort(arr, (o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));//lambda表达式
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                }
            });
        } else if(order == 1) {
            //降序
//            Arrays.sort(arr, (o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1));
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                }
            });
        }
        return String.join(" ", arr);
    }
}
