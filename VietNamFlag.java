// package CodeJ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VietNamFlag extends JPanel implements ActionListener {

    private int angle = 0;

    public VietNamFlag() {
        setBackground(Color.RED);
        setPreferredSize(new Dimension(400, 400));
        Timer timer = new Timer(1000 / 60, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ ngôi sao vàng
        g2d.setColor(Color.YELLOW);
        int starSize = 100;
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        fillStar(g2d, x, y, starSize, 5, angle);
    }

    private void fillStar(Graphics2D g2d, int x, int y, int size, int points, int angle) {
        int[] xPoints = new int[points * 2];
        int[] yPoints = new int[points * 2];
        for (int i = 0; i < points * 2; i++) {
            double a = Math.PI / points * i + Math.toRadians(angle);
            double length = (i % 2 == 0) ? size / 2.0 : size / 4.0;
            xPoints[i] = x + (int) (length * Math.cos(a));
            yPoints[i] = y - (int) (length * Math.sin(a));
        }
        g2d.fillPolygon(xPoints, yPoints, points * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 1;
        if (angle >= 360) {
            angle = 0;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lá cờ Việt Nam");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VietNamFlag());
        frame.pack();
        frame.setVisible(true);
    }
}
