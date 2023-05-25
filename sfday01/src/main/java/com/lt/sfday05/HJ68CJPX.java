package com.lt.sfday05;

import java.util.*;

//HJ68 --成绩排序

/*
给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩

都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高

smith     67
jack      70
Tom       70
peter     96

注：0代表从高到低，1代表从低到高

输入描述：
第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开

输出描述：
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

   输入:
        3
        0
        fang 90
        yang 50
        ning 70
   输出:
        fang 90
        ning 70
        yang 50

    思路1:定义学生类 放name和grade两个属性 用treeSet放student对象 自定义排序规则 按成绩排序 成绩一致按输出顺序
    思路2:treeMap kay存放顺序索引 value 存放student 将map.entry放入list中 调用collections集合工具类排序list
    先按成绩再按顺序
 */
public class HJ68CJPX {
    static class Student {
        String name;
        int grade;
        Student(String name, int grade) { this.name = name; this.grade = grade; }

        @Override
        public String toString() {
//            return "Student{" +
//                    "name='" + name + '\'' +
//                    ", grade=" + grade +
//                    '}';
            return name + " " + grade;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            int sortWay = Integer.parseInt(sc.nextLine());//0--降序  1--升序

            //treeSet 根据比较规则去重，如果比较规则返回0 认为这两个元素相同，则覆盖添加
            TreeSet<Student> set = new TreeSet<>((o1, o2) -> {
                if(o1.grade == o2.grade){ //相同成绩都按先录入排列在前的规则处理
                    return 1;
                } else if(sortWay == 1){ //升序
                    return o1.grade - o2.grade;
                } else {
                    return o2.grade - o1.grade;
                }
            });

            for(int i=0; i<num; ++i){
                String[] stu = sc.nextLine().split(" ");
                set.add(new Student(stu[0], Integer.parseInt(stu[1])));
            }
//            Iterator<Student> iterator = set.iterator();
//            while(iterator.hasNext()){
//                System.out.println(iterator.next());
//            }
            for (Student student : set) {
                System.out.println(student);
            }
        }
    }

    public static void sortStudent(){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            int sortWay = Integer.parseInt(sc.nextLine());//0--降序  1--升序
            TreeMap<Integer, Student> map = new TreeMap<>();
            for (int i = 0; i < num; i++) {
                String[] temp = sc.nextLine().split(" ");
                map.put(i+1,new Student(temp[0], Integer.parseInt(temp[1])));
            }
            List<Map.Entry<Integer,Student>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list,((o1, o2) -> {
                if(o1.getValue().grade == o2.getValue().grade){
                    return o1.getKey() - o2.getKey(); //按顺序索引升序
                }else if(sortWay == 0){
                    return o2.getValue().grade - o1.getValue().grade;//降序
                }else{
                    return o1.getValue().grade - o2.getValue().grade;//升序
                }
            }));
            for (Map.Entry<Integer,Student> entry : list){
                System.out.println(entry.getValue().toString());
            }
        }
    }
}
