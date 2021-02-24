package Assigment1;

public class Address {
    private String street;
    private String state;
    private String city;
    private String zip;
    public Address(String street, String city,String state, String zip) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }
    public String getStreet() {
        return street;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public String getZip() {
        return zip;
    }
}
