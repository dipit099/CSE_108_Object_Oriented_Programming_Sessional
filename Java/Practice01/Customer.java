public class Customer {
    private int id;
    private String name;
    private int discount;

    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }
	
	// write set and get methods
    public int getDiscount() {
        return discount;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
