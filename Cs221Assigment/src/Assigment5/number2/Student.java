package Assigment5.number2;
/*2. Implement Comparable interface to sort the objects of Student
 ArrayList using score field.
Write a constructor to initialize the values.*/
public class Student implements Comparable<Student> {
    private int sid;
    private String sName;
    private int score;

    public Student(int sid, String sName, int score) {
        this.sid = sid;
        this.sName = sName;
        this.score = score;
    }

    public int getSid() {
        return sid;
    }
    public String getsName() {
        return sName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "{Student Id: " + sid +
                ",  Student Name: '" + sName + '\'' +
                ",  score: " + score +
                '}';
    }
    @Override
    public int compareTo(Student stu) {
        return this.score-stu.score;
    }
}
