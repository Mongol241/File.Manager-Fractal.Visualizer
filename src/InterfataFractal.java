import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InterfataFractal {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Covor Fractal Hexagonal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.setLocationRelativeTo(null);

            Fractal fractalPanel = new Fractal();
            frame.add(fractalPanel);

            frame.setVisible(true);
        });
    }
}
