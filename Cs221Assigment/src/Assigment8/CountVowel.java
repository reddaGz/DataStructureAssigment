package Assigment8;

public class CountVowel {
    public static int numVowel(String str){
        String rgx="[aeiouAEIOU]";
        if(str==null || str.isEmpty())
            return 0;
       if(String.valueOf(str.charAt(0)).matches(rgx))
            return 1+numVowel(str.substring(1));
      else
          return numVowel(str.substring(1));
    }
    public static void main(String[] args) {
        System.out.println(numVowel("Reddaeeuuu"));
    }
}
