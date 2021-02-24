package PracticeProblemsOnSSL.Recu;

public class SearchAlgorthim {
    public static int linearSearch(int [] arr,int item){//  wrapper method
        return linearSearch(arr,item,0);
    }
    public static int linearSearch(int[]arr,int item,int i){
        if(i==arr.length)
            return -1;
        if(arr[i]==item)
            return i;
        else
            return linearSearch(arr,item,i+1);
    }
    public static int binarySearch(int[]arr,int item){//wrapper method for binary search
        return binarySearch(arr,item,0,arr.length-1);
    }
public static int binarySearch(int[]arr,Comparable item,int first,int last){
        if(first>last)
            return -1;
        int middel=(first+last)/2;
        int res=item.compareTo(arr[middel]);
        if(res==0)
            return middel;
        if(res>0)
            return binarySearch(arr,item,middel+1,last);
        else
            return binarySearch(arr,item,first,middel-1);
}
    public static void main(String[] args) {
        int[]num={1,2,3,4,5,6,7,8,9,10};//already sorted
        System.out.println(linearSearch(num,7));
        System.out.println(binarySearch(num,7));
    }
}
