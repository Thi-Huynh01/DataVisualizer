import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class StatsPanel extends JPanel {
    JTable CCtable;
    JScrollPane scrollPane;
    private final String[] col = {"White count", "Asian count", "Hispanic count", "Black count", "Male count", "Female count"};

    public StatsPanel() throws IOException {
        FileReader f = new FileReader(); // Ensure this class is correctly implemented to get the data
        setPreferredSize(new Dimension(200, 50));
        setBackground(Color.pink);

        Object [][]CCdataArray = getData();

        // Create the JTable with the dataArray and column names
        CCtable = new JTable(CCdataArray, col);

        CCtable.setPreferredSize(new Dimension(250, 20));

        JLabel label = new JLabel("CC ethnicity stats");

        // Create the JScrollPane and set its preferred size
        scrollPane = new JScrollPane(CCtable);
        scrollPane.setPreferredSize(new Dimension(600, 200)); // Set the size of the scroll pane
        scrollPane.add(label);
        add(scrollPane, BorderLayout.NORTH); // Add scrollPane to the panel
    }

    public Object[][] getData() throws IOException {
        FileReader f = new FileReader();
        ArrayList<Long> data = f.getArrayListCC();
        int n = col.length; // Number of columns
        Object[][] dataArray = new Object[1][n];

        for (int j = 0; j < n; j++) {
            if (j < data.size()) {
                dataArray[0][j] = data.get(j);
            } else {
                dataArray[0][j] = "";
            }
        }
        return dataArray;
    }
}
