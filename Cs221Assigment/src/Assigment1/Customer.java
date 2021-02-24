package Assigment1;

public class Customer implements Comparable<Customer> {
    private String firstName;
    private String lastName;
    private String socSecurityNum;
    private Address billingAddress;
    private Address shippingAddress;
    public Customer(String firstName, String lastName, String socSecurityNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socSecurityNum = socSecurityNum;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSocSecurityNum() {
        return socSecurityNum;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public Address getShippingAddress() {
        return shippingAddress;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSocSecurityNum(String socSecurityNum) {
        this.socSecurityNum = socSecurityNum;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    @Override
    public String toString() {
        return " [" + firstName + "," + lastName + "," +"ssn: " +socSecurityNum
                + "]";
    }

    @Override
    public int compareTo(Customer o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }
}
