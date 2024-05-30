import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PyramidNumberPatternGUI extends JFrame {
    private JTextField rowInput;
    private JButton generateButton;
    private JTextArea outputArea;

    public PyramidNumberPatternGUI() {
        // Set up the frame
        setTitle("Pyramid Number Pattern");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        rowInput = new JTextField(5);
        generateButton = new JButton("Generate");

        inputPanel.add(new JLabel("Rows:"));
        inputPanel.add(rowInput);
        inputPanel.add(generateButton);

        add(inputPanel, BorderLayout.NORTH);

        // Create output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(scrollPane, BorderLayout.CENTER);

        // Add button listener
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rows = Integer.parseInt(rowInput.getText());
                    String pyramidPattern = generatePyramidPattern(rows);
                    outputArea.setText(pyramidPattern);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
    }

    private String generatePyramidPattern(int rows) {
        StringBuilder pyramid = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces
            for (int j = rows - i; j > 0; j--) {
                pyramid.append(" ");
            }
            // Print numbers in ascending order
            for (int k = 1; k <= i; k++) {
                pyramid.append(k).append(" ");
            }
            // Move to the next line
            pyramid.append("\n");
        }
        return pyramid.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PyramidNumberPatternGUI frame = new PyramidNumberPatternGUI();
                frame.setVisible(true);
            }
        });
    }
}

    
