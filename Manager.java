import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Manager {
    private QueueOfCustomers queue;
    private ParcelMap parcelMap;
    private Worker worker;

    public Manager() {
        queue = new QueueOfCustomers();
        parcelMap = new ParcelMap();
        worker = new Worker("Test worker");
    }

public void loadCustomers(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                Customer customer = new Customer(parts[0], parts[1]);
                queue.addCustomer(customer);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public void loadParcels(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                Parcel parcel = new Parcel(
                        parts[0],
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        Double.parseDouble(parts[5])
                );
                parcelMap.addParcel(parcel);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public void startProcessing() {
        while (!queue.isEmpty()) {
            Customer customer = queue.removeCustomer();
            Parcel parcel = parcelMap.getParcel(customer.getCustomerId());
            if (parcel != null) {
                worker.processCustomer(customer, parcel);
            }
        }
        Log.getInstance().writeLogToFile("log.txt");
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.loadCustomers("Custs.csv");
        manager.loadParcels("Parcels.csv");
        manager.startProcessing();
    }
}
