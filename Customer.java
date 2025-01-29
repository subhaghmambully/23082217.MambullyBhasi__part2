public class Customer {
    private String name;
    private String customerId;

  
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

   
    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return name + " (" + customerId + ")";
    }
}
