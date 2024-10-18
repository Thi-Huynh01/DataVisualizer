import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.Arrays;

public class ChartPanel extends JPanel {
    private long[] values;
    private final Color[] colors = {Color.RED, Color.GREEN, Color.ORANGE, Color.CYAN};
    private final Color[] colorsGen = {Color.BLUE, Color.MAGENTA};

    public ChartPanel() throws IOException {
        FileReader fr = new FileReader();
        values = fr.getCCData();
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int total = 0;
        long [] moddedCC = Arrays.copyOfRange(values, 0, 4);

        for (long value : moddedCC)
            total += (int) value;

        int startAngle = 0;

        for (int i = 0; i < moddedCC.length; i++) {
            int angle = (int) Math.round(360.0 * moddedCC[i] / total);
            g2d.setColor(colors[i]);
            g2d.fill(new Arc2D.Double(20, 20, 200, 200, startAngle, angle, Arc2D.PIE));
            startAngle += angle;
        }
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.RED);
        g2d.drawString("RED: Caucasian Count",265,50);
        g.setColor(Color.GREEN);
        g2d.drawString("GREEN: Hispanic Count",265,70);
        g.setColor(Color.ORANGE);
        g2d.drawString("ORANGE: Black Count",265,90);
        g.setColor(Color.CYAN);
        g2d.drawString("CYAN: Asian Count",265,110);

        moddedCC = Arrays.copyOfRange(values, 4, 6);

        for (int i = 0; i < moddedCC.length; i++) {
            int angle = (int) Math.round(360.0 * moddedCC[i] / total);
            g2d.setColor(colorsGen[i]);
            g2d.fill(new Arc2D.Double(20, 350, 200, 200, startAngle, angle, Arc2D.PIE));
            startAngle += angle;
        }

        g.setColor(Color.BLUE);
        g2d.drawString("BLUE: Male Count",265,400);
        g.setColor(Color.MAGENTA);
        g2d.drawString("MAGENTA: Female Count",265,420);

    }
}
