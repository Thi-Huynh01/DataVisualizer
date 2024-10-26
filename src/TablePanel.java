import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TablePanel extends JPanel {
    JTable table;
    JScrollPane scrollPane;
    private final String[] col = {"First Name", "Last Name", "School District", "Year", "Ethnicity/Gender"};

    public TablePanel() throws IOException {
        FileReader f = new FileReader();
        setBackground(Color.pink);

        Object[][] allData = getData(f.getArrayList());

        // Create the JTable with the dataArray and column names
        table = new JTable(allData, col);

        //Create the JScrollPane and set its preferred size
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 600));

        add(scrollPane);

    }

    public Object[][] getData(ArrayList<String> data) {

        int n = data.getFirst().split(",").length; // Number of columns
        Object[][] dataArray = new Object[data.size()][n];

        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i).split(",");
        }

        return dataArray;
    }
}
