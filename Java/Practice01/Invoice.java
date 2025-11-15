public class Invoice {
    int id;
    Customer customer;
    double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }
	
	// write set and get methods 
	
	// write other methods to successfully run TestMain 
    public double getAmount() {
        return amount;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getId() {
        return id;
    }
    public int getCustomerId() {
        return customer.getId();
    }
    public String getCustomerName(){
        return customer.getName();

    }
    public int getCustomerDiscount()
    {
        int n= customer.getDiscount();
        amount = amount-n;
        return n;
    }
    public double getAmountAfterDiscount()
    {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setId(int id) {
        this.id = id;
    }
}
