package Assigment3.Number3;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    private    List<Marketing> list;
    private int size;
    public MainClass(){
        list=new ArrayList<>();
    }
    //a. add() // adding objects to the Marketing
    public void addMarketing( Marketing ma){
        list.add(ma);
    }
    //b. remove() // delete objects from Marketing
    public void removeMarketing(String name){
     for(int i=0;i<list.size();i++){
         if(name.equals(list.get(i).getEmployeeName()))
             list.remove(i);
     }
    }

    //c. set() // Modify some objects using set() method
    public void replaceMarketing( String name){
        for(int i=0;i<list.size();i++){
            if(name.equals(list.get(i).getEmployeeName()))
                list.set(i,new Marketing("Merhawi","MackBook",1200));
        }
    }
    //e. Get the size of the list.
    public int ListSize(){
        size=list.size();
        return size;
    }
    //f. Calculate the total salesAmount and print the same to the console
    public double totalSaleAmount(){
        double sum=0;
        for(int i=0;i<list.size();i++)
            sum+=list.get(i).getSalesAmount();
        return sum;
    }
    public  List<Marketing> getList() {
        return list;
    }

    public static void main(String []args){
  MainClass test=new MainClass();
     test.addMarketing(new Marketing("Merhawi","MackBook",1200));
     test.addMarketing(new Marketing("Redda","Dell",1300));
     test.addMarketing(new Marketing("Zenebe","Apple",1400));
   // test.removeMarketing("Redda");
    for(Marketing m:test.getList())
        System.out.print(m+"\n");
    System.out.print("\n"+test.totalSaleAmount());
     //   g. Use get() method
   System.out.print(test.getList().get(0).getEmployeeName());
      //  h. Use clear() method
     test.getList().clear();
    }
}

