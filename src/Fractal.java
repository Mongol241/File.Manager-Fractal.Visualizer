import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Fractal extends JPanel {

    private static final int acuratete = 2;

    public Fractal() {

        setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);

        int razaCentru = Math.min(getWidth(), getHeight()) / 2 - 10;
        int centruX = getWidth() / 2;
        int centruY = getHeight() / 2;


        desenareFractalHexagon(g2d, centruX, centruY, razaCentru, acuratete);
    }

    private void desenFractal(Graphics2D g2d, int centruX, int centruY, int raza) {

        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {

            double angle = Math.PI / 6 + i * Math.PI / 3;
            xPoints[i] = (int) (centruX + raza * Math.cos(angle));
            yPoints[i] = (int) (centruY + raza * Math.sin(angle));
        }
        g2d.fillPolygon(xPoints, yPoints, 6);
    }

    private void desenareFractalHexagon(Graphics2D g2d, int centruX, int centruY, int raza, int acuratete) {
        if (acuratete == 0) {

            desenFractal(g2d, centruX, centruY, raza);
        } else {

            int newRadius = raza / 3;


            for (int i = 0; i < 6; i++) {

                double angle = i * Math.PI / 3;
                int newCenterX = (int) (centruX + 2 * newRadius * Math.cos(angle));
                int newCenterY = (int) (centruY + 2 * newRadius * Math.sin(angle));
                desenareFractalHexagon(g2d, newCenterX, newCenterY, newRadius, acuratete - 1);
            }
        }
    }
}
