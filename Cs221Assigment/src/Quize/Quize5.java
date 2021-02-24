package Quize;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Quize5 {

        public static void main(String [] args){
            List<String> list = new ArrayList<>();
            list.add("Dave");
            list.add("John");
            list.add("Khan");
            list.add("Redda");
            list.add("Ezra");
            Iterator<String > it=list.iterator();
            while (it.hasNext())
                System.out.println(it.next());
            for(String s:list)
                System.out.println(s);
        }
}
