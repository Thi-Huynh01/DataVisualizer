import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

// The CSV files are downloaded from this link
// https://dataverse.harvard.edu/dataset.xhtml?persistentId=doi:10.7910/DVN/MSPV1Y

public class Main {
    public static void main(String[] args) throws IOException {

        // Create the File Reader, which is where all the CSV data is.
        FileReader file = new FileReader();

        // Create all the panels
        TablePanel tablePanel = new TablePanel(file);
        ChartPanel chartPanel = new ChartPanel(file);
        StatsPanel statsPanel = new StatsPanel(file);

        //Create JFrame
        JFrame frame = new JFrame("Data Visualizer");
        frame.setPreferredSize(new Dimension(1920, 900));
        frame.setBackground(Color.pink);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        //Add panels and display
        tablePanel.add(chartPanel);
        tablePanel.add(statsPanel);
        frame.getContentPane().add(tablePanel);
        frame.setVisible(true);


    }



}
