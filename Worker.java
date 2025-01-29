public class Worker {
    private String workerName;

    public Worker(String workerName) {
        this.workerName = workerName;
    }

    public double calculateFee(Parcel parcel) {
        // test calc
        return parcel.getWeight() * 0.5 + parcel.getDistance() * 0.2;
    }

    public void processCustomer(Customer customer, Parcel parcel) {
        double fee = calculateFee(parcel);
        Log.getInstance().logEvent("Worker " + workerName + " processed customer " + customer.getName() +
                " for parcel " + parcel.getParcelId() + ". Fee: $" + fee);
        
    }
}
