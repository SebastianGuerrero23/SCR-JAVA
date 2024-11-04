package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField inputNumero1;
    private JTextField inputNumero2;
    private JTextArea outputArea;

    public frm07() {
        setTitle("Máximo Común Divisor (MCD)");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputNumero1 = new JTextField(10);
        inputNumero2 = new JTextField(10);
        JButton calcularButton = new JButton("Calcular MCD");

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularMCD();
            }
        });

        panel.add(new JLabel("Número 1:"));
        panel.add(inputNumero1);
        panel.add(new JLabel("Número 2:"));
        panel.add(inputNumero2);
        panel.add(calcularButton);
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void calcularMCD() {
        int a = Integer.parseInt(inputNumero1.getText());
        int b = Integer.parseInt(inputNumero2.getText());
        int mcd = mcd(a, b);
        outputArea.setText("El MCD de " + a + " y " + b + " es: " + mcd);
    }

    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm07 frame = new frm07();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
