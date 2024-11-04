package recursivos;

import javax.swing.*;
import java.awt.*;

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;

    public frm10() {
        setTitle("Números del 1 al 100");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        StringBuilder numeros = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            numeros.append(i).append("\t");
            if (i % 10 == 0) {
                numeros.append("\n");
            }
        }
        outputArea.setText(numeros.toString());
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm10 frame = new frm10();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

