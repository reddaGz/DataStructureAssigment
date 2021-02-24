package Quize;
import java.util.HashSet;
import java.util.Stack;
import java.util.Set;
public class ClassTest extends  Stack {
    //we can not implements Stack b.c stack is not interface it is  a class
    //we can can extend it but not implments
  public static String binry(int num){
      if(num==0)
          return "";
      return binry(num/2)+num%2;
  }
    public static void main(String[] args) {
     System.out.println(binry(7));
         Set<String> m=new HashSet<>();
        String y=null;
        if(y==null)
            y="";
        System.out.println(y.hashCode());//what is the hashCode for null
         m.add(y);//added succfully

        String q= new String("hello");
        String z=new String("hello");
        Person p1=new Person("Gre","Redda");
        Person p2=new Person("Gre","Redda");
        Person p3=p1;
        System.out.println(p1.equals(p2));//true
//        System.out.println(p1.equals(p3));
//        System.out.println(p1.hashCode()==p3.hashCode());
        //System.out.println(p1==p2);
        System.out.println(p1.hashCode()==p2.hashCode());//false
        System.out.println(p1.hashCode());//false
        System.out.println(p2.hashCode());//false

        System.out.println((int)(Math.log(16)/Math.log(2))-1);
    }
}
