package model;

import controller.ManagerController;
import view.ManagerView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Manager {
    private QueueOfCustomers queue;
    private ParcelMap parcelMap;
    private Worker worker;
    private ManagerView view;
    private ManagerController controller;

    public Manager() {
        queue = new QueueOfCustomers();
        parcelMap = new ParcelMap();
        worker = new Worker("John Doe");
    }

    // Getters
    public QueueOfCustomers getQueue() {
        return queue;
    }

    public ParcelMap getParcelMap() {
        return parcelMap;
    }

    public Worker getWorker() {
        return worker;
    }

    // Load Customers from CSV
    public void loadCustomers(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String customerId = parts[1].trim();
                    Customer customer = new Customer(name, customerId);
                    queue.addCustomer(customer);
                }
            }
            Log.getInstance().logEvent("Loaded customers from " + filename);
        } catch (IOException e) {
            Log.getInstance().logEvent("Error loading customers: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Load Parcels from CSV
    public void loadParcels(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String parcelId = parts[0].trim();
                    int weight = Integer.parseInt(parts[1].trim());
                    int length = Integer.parseInt(parts[2].trim());
                    int width = Integer.parseInt(parts[3].trim());
                    int height = Integer.parseInt(parts[4].trim());
                    double distance = Double.parseDouble(parts[5].trim());

                    Parcel parcel = new Parcel(parcelId, weight, length, width, height, distance);
                    parcelMap.addParcel(parcel);
                }
            }
            Log.getInstance().logEvent("Loaded parcels from " + filename);
        } catch (IOException e) {
            Log.getInstance().logEvent("Error loading parcels: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Initialize GUI and Controller
    public void initializeGUI() {
        // Ensure GUI updates are done on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view = new ManagerView(Manager.this);
                controller = new ManagerController(Manager.this, view);
            }
        });
    }

    // Shutdown Hook to Write Logs
    public void shutdown() {
        Log.getInstance().writeLogToFile("log.txt");
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.loadCustomers("resources/Custs.csv");
        manager.loadParcels("resources/Parcels.csv");
        manager.initializeGUI();

        // Add Shutdown Hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            manager.shutdown();
        }));
    }
}
