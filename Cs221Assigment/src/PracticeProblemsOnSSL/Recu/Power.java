package PracticeProblemsOnSSL.Recu;
import java.util.Scanner;
public class Power {
    public static double  powerMethod(double a,int n) {
        if(n<0)
            return 1/powerMethod(a,-n);
        if(n==0)
            return 1;
        if(n==1)
            return a;
        else
            return a*powerMethod(a,n-1);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("enter the number: ");
        double num=input.nextDouble();
        System.out.print("enter the power value: ");
        int  p=input.nextInt();
       System.out.print(powerMethod(num,p));
    }
}
