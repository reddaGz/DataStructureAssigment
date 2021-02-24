package Assigment1;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    private static Customer []custtomer;
    public static void main(String[] args) {

        custtomer = new Customer[3];
        Address cust1BillingAddress=new Address("127 marthin luther","Chicago","Il","01118");
        Address cust1ShippingAddress=new Address("234 Main Street Avenue","FairField","IA","0567");
        Customer cust1=new Customer("Kidus","Miky","4567-234-6789");
        cust1.setBillingAddress(cust1BillingAddress);
        cust1.setShippingAddress(cust1ShippingAddress);

        Address cust2BillingAddress=new Address("127 WestRoxebery","Boston","MA","8888");
        Address cust2ShippingAddress=new Address("234 Brighthon squre","Main","MA","9999");
        Customer cust2=new Customer("Rahwa","Alemu","666-888-9999");
        cust2.setBillingAddress(cust2BillingAddress);
        cust2.setShippingAddress(cust2ShippingAddress);

        Address cust3BillingAddress=new Address("127 marthin luther","NewYork","NY","01118");
        Address cust3ShippingAddress=new Address("234 Main Street Avenue","FairField","IA","05678");
        Customer cust3=new Customer("Redda","Zera","666-888-9999");
        cust3.setBillingAddress(cust3BillingAddress);
        cust3.setShippingAddress(cust2ShippingAddress);
        custtomer[0]=cust1;
        custtomer[1]=cust2;
        custtomer[2]=cust3;
        for (Customer c :custtomer ) {
            if(c.getBillingAddress().getCity() == "Chicago")
           System.out.print(c);
        }
    }
}
