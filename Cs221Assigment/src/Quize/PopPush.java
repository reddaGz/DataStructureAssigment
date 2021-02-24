package Quize;



import java.util.LinkedList;

public class PopPush {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList();
        list.push("hello");
        list.push("redda");
        list.push("world");
        System.out.println(list.pop());
        System.out.println(list.peek());

    }
}
