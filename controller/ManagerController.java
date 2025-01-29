package controller;

import model.Customer;
import model.Manager;
import model.Parcel;
import view.ManagerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerController {
    private Manager model;
    private ManagerView view;

    public ManagerController(Manager model, ManagerView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        view.getProcessButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processNextCustomer();
            }
        });
    }

    private void processNextCustomer() {
        if (!model.getQueue().isEmpty()) {
            Customer customer = model.getQueue().removeCustomer();
            Parcel parcel = model.getParcelMap().getParcel(customer.getCustomerId());

            if (parcel != null) {
                double fee = model.getWorker().calculateFee(parcel);
                model.getWorker().processCustomer(customer, parcel, fee);

                // Update Processing Panel
                String processingInfo = "Customer: " + customer.getName() +
                        ", Parcel ID: " + parcel.getParcelId() +
                        ", Fee: $" + String.format("%.2f", fee);
                view.getProcessingPanel().updateProcessing(processingInfo);

                // Remove processed parcel from ParcelMap
                model.getParcelMap().removeParcel(parcel.getParcelId());

                // Update GUI Panels
                view.getParcelPanel().updateParcels(model.getParcelMap());
                view.getCustomerQueuePanel().updateCustomers(model.getQueue());
            } else {
                JOptionPane.showMessageDialog(view.getFrame(),
                        "No parcel found for Customer ID: " + customer.getCustomerId(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(view.getFrame(),
                    "No more customers in queue.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
