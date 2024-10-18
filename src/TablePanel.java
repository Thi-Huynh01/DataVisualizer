import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TablePanel extends JPanel {
    JTable table;
    JScrollPane scrollPane;
    private final String[] col = {"White count", "Hispanic count", "Black count", "Asian count", "Male count", "Female count"};

    public TablePanel() throws IOException {
        FileReader f = new FileReader();
        setPreferredSize(new Dimension(200, 50));
        setBackground(Color.pink);

        Object[][]CCdataArray = getData(f.getArrayList());

        // Create the JTable with the dataArray and column names
        table = new JTable(CCdataArray, col);

        table.setPreferredSize(new Dimension(250, 20));

        // Create the JScrollPane and set its preferred size
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 100));
        add(scrollPane, BorderLayout.NORTH);

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Above shows a chart that holds the predictions" +
                " for the City Council and the", 50,400);
        g.drawString("School Board in all of California. This data was generated via data received", 50, 420);
        g.drawString("from 2010-2023 given by the CEDA.", 50, 440);

    }

    public Object[][] getData(ArrayList<Long> data) {

        int n = col.length; // Number of columns
        Object[][] dataArray = new Object[1][n];

        for (int j = 0; j < n; j++) {
            if (j < data.size()) {
                dataArray[0][j] = data.get(j);
           }
        }
        return dataArray;
    }
}
