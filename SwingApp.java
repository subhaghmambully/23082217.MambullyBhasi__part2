import javax.swing.*;

public class SwingApp {
    public static void main(String[] args) {
        // Ensure the UI updates on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create a frame (window)
            JFrame frame = new JFrame("Swing UI Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a label
            JLabel label = new JLabel("Hello, Swing!", SwingConstants.CENTER);
            frame.add(label);

            // Make the window visible
            frame.setVisible(true);
        });
    }
}
