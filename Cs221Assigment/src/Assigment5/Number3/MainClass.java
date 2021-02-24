package Assigment5.Number3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {
    public static void main(String []args){
        List<Student>stu=new ArrayList<>();
        stu.add(new Student(1112, "Redda",99));
        stu.add(new Student(1113, "kidus",66));
        stu.add(new Student(1114, "Samri",71));
        stu.add(new Student(1115, "Ezra",49));
        for(Student s:stu){
            System.out.println(s);
        }
        System.out.println("After sorting student by score");
        StudentComparator comp=new StudentComparator();
        Collections.sort(stu);
        for(Student s:stu){
            System.out.println(s);
        }
        System.out.println(stu.get(0).equals(stu.get(1)));
    }
}
