package Assigment3.number1;
import java.util.Random;

public class ArrayList {
    private  int []arr;
    private final int MAX=50;
    //private int size;
    public ArrayList(){
        arr=new int[MAX];
    }
    //a) Insert 50 random numbers. // Random values in the Range of 0 -100
    public  void insert(){
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100);
        }
    }
    //b) Remove duplicate from array and print the list without duplicates.
    public  void removeDuplicates(){
        int size=size();
        for(int i=0;i<size;i++) {
            for(int j=i+1;j<size;j++) {
                if(arr[i]==arr[j]) {
                    arr[j]=arr[size-1];
                    j--;
                    size--;
                }
            }
        }
        shrinkSize(size);
    }
    //when we remove the duplicated elements  reduce the size of the array
    private  void shrinkSize(int n){
        if(n<arr.length) {
            int[]temp=new int[n];
            for(int i=0;i<n;i++){
                temp[i]=arr[i];
            }
            arr=temp;
        }
    }
//c) Remove all the elements from the array. Delete all the entries from the list
    public  void clear(){
        int []temp=new int[0];
        arr=temp;
}
//d) Find the size of the array. Size means how many elements hold by the array.
    public  int size(){

    return arr.length;
}
//e) get the value by passing index. Return the integer value in the given index,
// throw ArrayIndexOutof BoundsException if index < 0 and index >=size
    public int get(int index){
        if(index<0||index>=size())
            throw new ArrayIndexOutOfBoundsException();
        return arr[index];
     }
     /*f) get the sublist by passing start and end index.Return the array
      with the specified range of value,
      include both start and end index. Throw ArrayIndexOutof BoundsException
      if index < 0 and index >=size*/

     public int[] subList(int start, int end){
        int[]output;

        if((start<0||start>=size())||(end<0||end>=size()))
            throw new ArrayIndexOutOfBoundsException();
         int index=0;
         output=new int[(end-start)+1];
        for(int i=start;i<=end;i++){
            output[index]=arr[i];
            index++;
        }
        return output;
     }
     /*g) set the new value using index. Modify the new value with the specified
     index and return the old value. Throw ArrayIndexOutof BoundsException if
     index < 0 and index >=size
     * */
     public int set(int index, int newValue){
         int oldValue;
         if(index<0||index>=size())
             throw new ArrayIndexOutOfBoundsException();

         oldValue=arr[index];
         arr[index]=newValue;
         return  oldValue;
     }
     public static void main(String []args){
        ArrayList arrayList=new ArrayList();
        arrayList.insert();
        int count=0;
       int []a= arrayList.subList(3,14);
       for(int i=0;i<a.length;i++){
           System.out.println(a[i]+" ");
           count++;
       }
           System.out.println("sub list length"+count);
//         int count=0;
//         for(int i=0;i<arrayList.size();i++){
//             count++;
//             System.out.print(arrayList.arr[i]+"\n");
//         }
//         System.out.print("\n"+count+"\n");
//          count=0;
//        arrayList.removeDuplicates();
//
//        for(int i=0;i<arrayList.size();i++){
//            count++;
//            System.out.print(arrayList.arr[i]+"\n");
//        }
//        System.out.print("\n"+count);
//        arrayList.clear();
//System.out.print("\n\n.............");
//count=0;
//        for(int i=0;i<arrayList.size();i++){
//            count++;
//            System.out.print(arrayList.arr[i]+"\n");
//        }
//        System.out.print("\n"+count);
    }
}
