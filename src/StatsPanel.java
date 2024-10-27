import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.LongStream;

public class StatsPanel extends JPanel {
    long[] data;

    public StatsPanel(FileReader fileReader) throws IOException {
        // Set size of Stats Panel
        setPreferredSize(new Dimension(600, 600));

        // Get the data from the parameter
        data = fileReader.getAllData();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Get stats from getStats function
        double[] stats = getStats();

        // Set spacing for later drawing
        int spacing = 50;

        // Set labels to be drawn
        String[] labels = {"Percentage of White People: ", "Percentage of Hispanic People: ",
                "Percentage of Black People: ", "Percentage of Asian People: ",
                "Percentage of Males (All Ethnicities): ", "Percentage of Females (All Ethnicities): "
        };

        g.setFont(new Font("Arial", Font.BOLD, 20));

        // Print stats to panel
        for (int i = 0; i < stats.length; i++) {
            g.drawString(labels[i] + String.format("%.2f", stats[i]) + "%", 100, 150 + (i * spacing));
        }
    }

    public double[] getStats() {

        // All stats are stored in one array, so slice at passed in index
        long[] ethSlice = Arrays.copyOfRange(data, 0, 4), genSlice = Arrays.copyOfRange(data, 4, 6);
        double ethTotal = LongStream.of(ethSlice).sum(), genTotal = LongStream.of(genSlice).sum();
        double[] stats = new double[data.length];

        // Get the percentage of ethnicity for total number of people
        for (int i = 0; i < data.length; i++) {
            if (i <= ethSlice.length - 1)
                stats[i] = data[i]/ethTotal;
            else
                stats[i] = data[i]/genTotal;
            stats[i] *= 100;
        }

        return stats;

    }
}
