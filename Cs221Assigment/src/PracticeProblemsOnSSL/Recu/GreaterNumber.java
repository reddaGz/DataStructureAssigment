package PracticeProblemsOnSSL.Recu;

public class GreaterNumber {
    public static int recNumPass(int[] arr,int i){
        if(i==arr.length)
            return 0;
        if(arr[i]>60)
            return 1+ recNumPass(arr,i+1);
        else
            return recNumPass(arr,i+1);
    }

    public static void main(String[] args) {
       int []arr={45,78,12,23,98};

    }
}
