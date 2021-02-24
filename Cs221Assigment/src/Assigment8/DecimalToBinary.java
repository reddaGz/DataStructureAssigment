package Assigment8;

import java.util.PriorityQueue;

public class DecimalToBinary {
    public static int DecimalToBinary(int dec){
         int bin;
        if (dec == 0)
           return bin = 0;
        else//0+10*(0+10(0+10(0+10(0)))
          return   bin = dec % 2 + 10 * (DecimalToBinary(dec / 2));//digit shfit;
    }
    public static void main(String[] args) {
        System.out.println(DecimalToBinary(15));
//        PriorityQueue<String> pq=new PriorityQueue<>();
//        pq.add("G");
//        pq.add("B");
//        pq.add("C");
//        pq.add("A");
//        for(String p:pq)
//        System.out.println(p);
    }
}
