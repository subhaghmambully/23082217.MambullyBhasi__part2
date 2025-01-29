import java.util.LinkedList;
import java.util.Queue;

public class QueueOfCustomers {
    private Queue<Customer> customerQueue;

    public QueueOfCustomers() {
        customerQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
        Log.getInstance().logEvent("Customer added to queue: " + customer.getName());
    }

    public Customer removeCustomer() {
        Customer customer = customerQueue.poll();
        if (customer != null) {
            Log.getInstance().logEvent("Customer removed from queue: " + customer.getName());
        }
        return customer;
    }

    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }

}
