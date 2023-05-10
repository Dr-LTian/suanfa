package com.lt.sfday05;

import java.util.*;

//HJ68--成绩排序
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
}
