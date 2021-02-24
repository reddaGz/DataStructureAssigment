package PracticeProblems;
import java.util.Random;
public class ArrayTest {
    private static int []arr={2,2,2,2,2,2,2,2,3,4,5,6,2,2,5};
//        public static  void insert(){
//            arr= new int[]{2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 2, 2, 5};
//        Random random=new Random();
//        //arr=new int[50];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=random.nextInt(100);
//        }
//    }
    public static void removeDuplicates(){
        int n=arr.length;
        for(int i=0;i<n;i++) {
            //arr[i]=34;
            for(int j=i+1;j<n;j++) {
                if(arr[i]==arr[j]) {
                    arr[j]=arr[n-1];
                    j--;
                    n--;
                }
            }
        }
        shrinkSize(n);
    }
    public static void shrinkSize(int n){
        if(n<arr.length) {
            int[]temp=new int[n];
            for(int i=0;i<n;i++)
                temp[i]=arr[i];
            arr=new int[n];
            arr=temp;
        }
    }
    public static void main(String []args){
        //insert();

        removeDuplicates();

        int count=0;
        for(int i=0;i<arr.length;i++){
            count++;
            System.out.print(arr[i]+"\n");
        }
        System.out.print("\n"+count);
    }
}
