package Assigment5.Number3;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student stu1, Student stu2) {
        if(stu1.equals(stu2))
            return 0;
       else if(stu1.getScore()>stu2.getScore())
           return 1;
       else
           return -1;
    }

}
