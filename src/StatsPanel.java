import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.LongStream;

public class StatsPanel extends JPanel {
    FileReader fileReader;
    long[] data;

    public StatsPanel() throws IOException {
        setPreferredSize(new Dimension(600, 600));
        fileReader = new FileReader();
        data = fileReader.getAllData();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double[] stats = getStats();
        int spacing = 50;
        String[] labels = {"Percentage of White People: ", "Percentage of Hispanic People: ",
                "Percentage of Black People: ", "Percentage of Asian People: ",
                "Percentage of Males (All Ethnicities): ", "Percentage of Females (All Ethnicities): "
        };

        g.setFont(new Font("Arial", Font.BOLD, 20));

        for (int i = 0; i < stats.length; i++) {
            g.drawString(labels[i] + String.format("%.2f", stats[i]) + "%", 100, 150 + (i * spacing));
        }
    }

    public double[] getStats() {

        long[] ethSlice = Arrays.copyOfRange(data, 0, 4), genSlice = Arrays.copyOfRange(data, 4, 6);
        double ethTotal = LongStream.of(ethSlice).sum(), genTotal = LongStream.of(genSlice).sum();
        double[] stats = new double[data.length];

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
