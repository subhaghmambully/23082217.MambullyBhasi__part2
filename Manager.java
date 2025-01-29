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
        
    }

    public void loadParcels(String filename) {
        
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
