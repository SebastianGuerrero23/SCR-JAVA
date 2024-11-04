package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm04 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField inputNumero;
    private JTextArea outputArea;

    public frm04() {
        setTitle("Cálculo de Factorial");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputNumero = new JTextField(10);
        JButton calcularButton = new JButton("Calcular Factorial");

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFactorial();
            }
        });

        panel.add(new JLabel("Número:"));
        panel.add(inputNumero);
        panel.add(calcularButton);
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void calcularFactorial() {
        int n = Integer.parseInt(inputNumero.getText());
        long resultado = factorial(n);
        outputArea.setText("Factorial de " + n + " es: " + resultado);
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm04 frame = new frm04();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
