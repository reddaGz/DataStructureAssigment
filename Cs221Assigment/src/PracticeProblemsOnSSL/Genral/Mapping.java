package PracticeProblemsOnSSL.Genral;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
public class Mapping {
    public static void main(String[] args) {
        Map<Integer,String> hashMap=new HashMap<>();
        Map<Integer,String> hashTable=new Hashtable<>();
        Map<Integer,String> treeMap=new TreeMap<>();


        hashTable.put(123,"Redda");
        hashTable.put(124,"Ezra");
        hashTable.put(125,"Kaleb");
        hashTable.put(126,"Samri");
        System.out.println("Print both key and values ");
        System.out.println(hashTable.entrySet());
        System.out.println("============================= ");
  for(Map.Entry p:hashTable.entrySet())
      System.out.println(p);
        System.out.println("============================= ");
        System.out.println("Print  values only ");
  for(String p:hashTable.values())
      System.out.println(p);
        System.out.println("============================= ");
        System.out.println("Print  key only ");
        for(Integer p:hashTable.keySet())
            System.out.println(p);
//        Set<String>hashSet= (Set<String>) new HashMap<String, String >();
//        Set<Long>hashSet1= (Set<Long>) new HashMap<String ,Integer >();
//        hashSet1.add((long) 455);
//        hashSet.add("redda");
//        hashSet.add("Samri");
//        hashSet.add("Ezra");
//        for(String p:hashSet)
//            System.out.println(p);

    }
}

