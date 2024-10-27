import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TablePanel extends JPanel{
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> sorter;

    public TablePanel(FileReader fileReader) throws IOException {
        setBackground(Color.pink);
        Object[][] allData = getData(fileReader.getArrayList());
        final String[] col = {"First Name", "Last Name",
                "City/School District", "Year",
                "Ethnicity/Gender"};

        // Create the JTable with the dataArray and column names
        model = new DefaultTableModel(allData, col);
        table = new JTable(allData, col);

        // Create Row sorter to sort by ordinal values
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        //Create the JScrollPane and set its preferred size
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 600));

        // Add scrollPane to the Panel
        add(scrollPane);

    }

    public Object[][] getData(ArrayList<String> data) {

        // Get the length of a single CSV line to pass in as the second index in the 2D array
        int n = data.getFirst().split(",").length; // Number of columns
        Object[][] dataArray = new Object[data.size()][n];

        // Enter row information into the first index
        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i).split(",");
        }

        return dataArray;
    }

}
