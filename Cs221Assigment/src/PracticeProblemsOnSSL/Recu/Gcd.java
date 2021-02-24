package PracticeProblemsOnSSL.Recu;

public class Gcd {
    public static double gcd(int m,int n){
        if(m%n==0)
            return n;
        else if(n>m)
            return gcd(n,m);
        else
            return gcd(n,m%n);//(16,80)
    }
    public static void main(String[] args) {
        System.out.println(gcd(1205,985));
    }
}
