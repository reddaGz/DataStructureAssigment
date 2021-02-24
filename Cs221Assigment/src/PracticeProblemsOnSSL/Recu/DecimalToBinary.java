package PracticeProblemsOnSSL.Recu;

public class DecimalToBinary {
    public static int findBinary(int decimal){
        if (decimal == 0)
           return 0;
          return  decimal % 2 + 10 * (findBinary(decimal / 2));
    }
    public static String binary(int num){
        if(num==0)
            return "";
        return binary(num/2)+num%2;
    }
public static int revNumber(int num){//reverse number using while loop
    int reversed = 0;
    while(num != 0) {
        int digit = num % 10;
        reversed = reversed * 10 + digit;
        num /= 10;
    }
return reversed;
}

public static int reverseNumber(int n){
        return reverseNumber(n,0);
}
    private static int reverseNumber(int n,int reverse){//reverse number using recurtion
        if(n==0)
            return reverse;
        else
            return reverseNumber(n/10,reverse*10+n%10);
    }
    public static void main(String[] args) {
        System.out.println(findBinary(897));
        System.out.println(revNumber(123456789));
        System.out.println(reverseNumber(123456789));
    }

}
