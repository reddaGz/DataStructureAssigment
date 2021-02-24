package PracticeProblemsOnSSL.Recu;
import java.util.Scanner;
public class IsPalindrom {
    public static boolean isPalindrom(String w) {//i is current index of the String
        if(!w.substring(0,1).equalsIgnoreCase(w.substring(w.length()-1)))//base case 1
            return false;
        else if(w.isEmpty())
            return false;
        else if(w.length()==1) 	//base case 2
            return true;
        else if(w.substring(0,1).equalsIgnoreCase(w.substring(w.length()-1))&&w.length()==2)//base case for even caracter
            return true;
        else
            return isPalindrom(w.substring(1,w.length()-1));
    }
    public static void main(String[] args) {
        String word;
        Scanner input=new Scanner(System.in);
        System.out.print("enter any text to check palindrom: ");
        word=input.nextLine();
        if(isPalindrom(word))
            System.out.print("this word is palindrom");
        else
            System.out.print("this word is not palindrom");
    }
}
