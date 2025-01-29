package view;

import model.Manager;
import model.ParcelMap;
import model.QueueOfCustomers;

import javax.swing.*;
import java.awt.*;


public class ManagerView {
    private JFrame frame;
    private ParcelPanel parcelPanel;
    private CustomerQueuePanel customerQueuePanel;
    private ProcessingPanel processingPanel;
    private JButton processButton;


    public ManagerView(Manager manager) {
        frame = new JFrame("Depot Worker Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

       
        parcelPanel = new ParcelPanel(manager.getParcelMap());
        customerQueuePanel = new CustomerQueuePanel(manager.getQueue());
        processingPanel = new ProcessingPanel();
        processButton = new JButton("Process Next Customer");

        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(processButton);

       
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(parcelPanel);
        centerPanel.add(customerQueuePanel);

        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(processingPanel, BorderLayout.CENTER);

        // Add Panels to Frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    // Getters for Controller Access
    public JFrame getFrame() {
        return frame;
    }

    public ParcelPanel getParcelPanel() {
        return parcelPanel;
    }

    public CustomerQueuePanel getCustomerQueuePanel() {
        return customerQueuePanel;
    }

    public ProcessingPanel getProcessingPanel() {
        return processingPanel;
    }

    public JButton getProcessButton() {
        return processButton;
    }
}
