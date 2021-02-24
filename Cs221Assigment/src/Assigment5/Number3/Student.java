package Assigment5.Number3;

import java.util.Objects;

/*3. Override the equals() method for the Student class in the
previous question. Create a Comparator implementation which
consists with equals. Write a test class with the sample data and
 print the result in a sorted order using your comparator.
 */
public class Student  implements Comparable<Student> {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return this.score == student.score ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( score);
    }

    @Override
    public int compareTo(Student o) {
        return this.getScore()-o.getScore();
    }
}
