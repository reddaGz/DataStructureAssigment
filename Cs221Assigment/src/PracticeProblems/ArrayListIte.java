package PracticeProblems;
import java.util.Iterator;
import java.util.LinkedList;
public class ArrayListIte {
    public  static void main(String []args){
        LinkedList<Integer> list=new LinkedList<>();
        list.push(34);
        list.push(12);
        list.push(67);
        Iterator<Integer>it=list.iterator();
        System.out.println(it.next());

        list.add(23);
        list.add(56);
        list.add(78);
        list.add(109);
        //Iterator<Integer>it=list.iterator();
        System.out.println(it.next());
    }
}
