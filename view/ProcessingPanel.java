package view;

import javax.swing.*;
import java.awt.*;

public class ProcessingPanel extends JPanel {
    private JLabel processingLabel;

    public ProcessingPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Current Processing"));

        processingLabel = new JLabel("Currently Processing: None");
        processingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        processingLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(processingLabel, BorderLayout.CENTER);
    }

    public void updateProcessing(String info) {
        processingLabel.setText("Currently Processing: " + info);
    }
}
