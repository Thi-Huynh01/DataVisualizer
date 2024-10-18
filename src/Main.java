import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

// The CSV files are downloaded from this link
// https://dataverse.harvard.edu/dataset.xhtml?persistentId=doi:10.7910/DVN/MSPV1Y

public class Main {
    public static void main(String[] args) throws IOException {

        TablePanel statsPanel = new TablePanel();
        ChartPanel chartPanel = new ChartPanel();

        JFrame frame = new JFrame("Data Visualizer");
        frame.setPreferredSize(new Dimension(1280, 720));
        frame.setBackground(Color.pink);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        statsPanel.add(chartPanel);
        frame.getContentPane().add(statsPanel);
        frame.setVisible(true);


    }



}
