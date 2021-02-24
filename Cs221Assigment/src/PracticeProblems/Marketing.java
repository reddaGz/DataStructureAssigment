package PracticeProblems;

public class Marketing {
    private String employeeName;
    private  String productName;
    private double salesAmount;

    public Marketing(String employeeName, String productName, double salesAmount) {
        this.employeeName = employeeName;
        this.productName = productName;
        this.salesAmount = salesAmount;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public String getProductName() {
        return productName;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

}
