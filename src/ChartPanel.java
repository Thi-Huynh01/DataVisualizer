import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.LongStream;

public class ChartPanel extends JPanel {
    private long[] values;
    private final Color[] colorsEth = {Color.RED, Color.GREEN, Color.ORANGE, Color.CYAN};
    private final Color[] colorsGen = {Color.BLUE, Color.MAGENTA};
    final String[] genKey = {"Male count", "Female count"};
    final String[] ethKey = {"Caucasian count", "Hispanic count", "Black count", "Asian count"};

    public ChartPanel() throws IOException {

        // Instantiate FileReader to get the data
        FileReader fr = new FileReader();
        values = fr.getAllData();

        // Set size of panel
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw Pie Chart reflecting Ethnicity
        long[] ethnicityData = Arrays.copyOfRange(values, 0, 4);
        drawChart(g2d, ethnicityData, colorsEth, 20, 20, 265, 50, ethKey);

        // Draw Pie Chart reflecting Gender
        long[] genderData = Arrays.copyOfRange(values, 4, 6);
        drawChart(g2d, genderData, colorsGen, 20, 350, 265, 400, genKey);

    }

    // Function to draw Pie Chart and key
    public void drawChart(Graphics2D g2d, long[] moddedData, Color[] colors, int x, int y, int starting_x, int starting_y, String[] key) {

        // Spacing and key_spacing modifies the amount of space between each item
        int total = (int)LongStream.of(moddedData).sum(), // Set the total, which is the sum of the array
                startAngle = 0, // Set the starting point to be 0 degrees
                spacing = 25,   // Spacing and key spacing are the amount of pixels between each item
                key_spacing = 16;

        // Set font
        g2d.setFont(new Font("Arial", Font.BOLD, 15));

        for (int i = 0; i < moddedData.length; i++) {

            // Draw Pie Chart
            int angle = (int) Math.round(360.0 * moddedData[i] / total);
            g2d.setColor(colors[i]);
            g2d.fill(new Arc2D.Double(x, y, 200, 200, startAngle, angle, Arc2D.PIE));

            // Draw the key
            g2d.fill(new Arc2D.Double(starting_x, starting_y + (i * spacing), 20, 20, startAngle, 360, Arc2D.PIE));
            g2d.setColor(Color.BLACK);
            g2d.drawString(key[i], starting_x + spacing, starting_y + (i * spacing) + key_spacing);
            startAngle += angle;
        }
    }
}
