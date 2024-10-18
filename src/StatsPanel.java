import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StatsPanel extends JPanel {
    FileReader fileReader;

    public StatsPanel() throws IOException {
        setPreferredSize(new Dimension(600, 600));
        fileReader = new FileReader();
    }

    public long[] getStats() {

        return new long[]{};
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello World",50,50);
    }
}
