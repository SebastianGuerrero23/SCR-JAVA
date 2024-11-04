package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField inputNumero;
    private JTextArea outputArea;

    public frm05() {
        setTitle("Verificación de Número Primo");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputNumero = new JTextField(10);
        JButton verificarButton = new JButton("Verificar Primo");

        verificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarPrimo();
            }
        });

        panel.add(new JLabel("Número:"));
        panel.add(inputNumero);
        panel.add(verificarButton);
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void verificarPrimo() {
        int n = Integer.parseInt(inputNumero.getText());
        boolean esPrimo = esPrimo(n, 2);
        outputArea.setText(n + " es " + (esPrimo ? "primo" : "no primo"));
    }

    public static boolean esPrimo(int n, int divisor) {
        if (n <= 2) return n == 2;
        if (n % divisor == 0) return false;
        if (divisor * divisor > n) return true;
        return esPrimo(n, divisor + 1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm05 frame = new frm05();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
