package PracticeProblemsOnSSL.Recu;

public class Factorial {
    public static double fact(int n){
        if(n==1||n==0)
            return 1;
        else
            return n*fact(n-1);
    }

    public static void main(String[] args) {
        System.out.println(fact(45));
    }
}
