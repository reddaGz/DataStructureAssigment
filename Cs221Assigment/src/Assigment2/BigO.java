package Assigment2;
public class BigO {
 /*   6- Write a function for each of the following growth rates:
            methode1- O(n)*/
      int methode1(){
          int a=0;
          int n=100;
          for(int i = 0; i<n; i++){
              a+=i;
          }
       return a;
    }
    /*methode2- O(n log n) */
      int  method2(){
          int x=0;
          int n=100;
          for(int i = 0; i<n; i++){
              for(int j=n;j>0;j=j/2)
                  x+=i*j;
          }
          return x;
      }
           /* methode3- O(n3)*/
           int  method3(){
               int y=0;
               int n=100;
               for(int i = 0; i<n; i++){
                   for(int j=0;j<n;j++)
                       for(int k=0;k<j;k++)
                       y+=i*j;
               }
               return y;
           }
            //what is the time complexity for each methodA,B,C
           int MethodA(){
               int m=0; int n=20;//cosider n is not fixed values
               for(int i=0;i<n;i=i*2)
                   for(int j=0;j<n;j=j*4)
                       m*=4;
               return m;
           }
           int methodB(){
               int m=0; int n=20;
               for(int i=0;i<n;i=i*2)
                    m*=4;
               for(int j=0;j<n;j=j*2)
                       m*=4;
               return m;
           }
           int methodC(){
               int m=0; int n=20;int y=0;
               for(int i=0;i<n;i=i*2)
                   m*=4;
               for(int j=0;j<m;j=j*2)
                   y++;
               return y;
           }
}
