import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Interfata extends Frame implements ActionListener {

    Button butonC, butonF , butonArhivare, butonDezarhivare , ButonArhivareFisier , ButonDezarhivareFisier;

    TextArea textArea;


    public Interfata() {

        setTitle("Listare partiții AWT");
        setSize(800, 600);

        Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (dimScreen.width - getWidth()) / 2;
        int y = (dimScreen.height - getHeight()) / 2;

        setLocation(x, y);

        setLayout(new BorderLayout());

        Panel panelButoane = new Panel();
        panelButoane.setLayout(new FlowLayout());

        butonC = new Button("Listare C:\\");
        butonF = new Button("Listare F:\\");
        butonArhivare = new Button("Arhivare:");
        butonDezarhivare = new Button("Dezarhivare:");
        ButonArhivareFisier= new Button("Arhivare Fisier : ");
        ButonDezarhivareFisier = new Button ("Dezarhivare Fisier: ");

        panelButoane.add(butonC);
        panelButoane.add(butonF);
        panelButoane.add(butonArhivare);
        panelButoane.add(butonDezarhivare);

        add(panelButoane, BorderLayout.NORTH);

        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        butonC.addActionListener(this);
        butonF.addActionListener(this);
        butonArhivare.addActionListener(this);
        butonDezarhivare.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        textArea.setText("");
        String rezultat = "";

        if (e.getSource() == butonC) {
            rezultat = fisier.listPartition("C:\\");
        } else if (e.getSource() == butonF) {
            rezultat = fisier.listPartition("F:\\");
        }

        else if (e.getSource() == butonArhivare) {
            FileDialog fd = new FileDialog(this, "Selectează fișier de arhivat", FileDialog.LOAD);
            fd.setVisible(true);

            String directory = fd.getDirectory();
            String filename = fd.getFile();

            if (filename != null) {
                String fullPath = directory + filename;
                rezultat = fisier.Arhivare(fullPath); // apel de metoda din fisier
            }
        }

        else if (e.getSource() == butonDezarhivare) {
            // Selectare fișier ZIP
            FileDialog fdZip = new FileDialog(this, "Selectează arhiva ZIP", FileDialog.LOAD);
            fdZip.setVisible(true);

            String directoryZip = fdZip.getDirectory();
            String filenameZip = fdZip.getFile();

            if (filenameZip != null) {
                String pathZip = directoryZip + filenameZip;

                // Selectare folder destinație
                FileDialog fdDest = new FileDialog(this, "Selectează folder destinație", FileDialog.SAVE);
                fdDest.setVisible(true);

                String destDir = fdDest.getDirectory();
                if (destDir != null) {
                    rezultat = fisier.Dezarhivare(pathZip, destDir);
                }

            } else {
                rezultat = "Nu ai selectat componenta ZIP.";
            }
        }

        textArea.setText(rezultat);

    }

    public void addMouseListener(MouseListener l) {
        textArea.addMouseListener(l);
    }

    public static void main(String[] args) {

        new Interfata();
    }

}

