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

        TablePanel tablePanel = new TablePanel();
        ChartPanel chartPanel = new ChartPanel();
        StatsPanel statsPanel = new StatsPanel();

        JFrame frame = new JFrame("Data Visualizer");
        frame.setPreferredSize(new Dimension(1920, 900));
        frame.setBackground(Color.pink);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        tablePanel.add(chartPanel);
        tablePanel.add(statsPanel);
        frame.getContentPane().add(tablePanel);
        frame.setVisible(true);


    }



}
