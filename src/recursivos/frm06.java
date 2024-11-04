package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField inputNumero;
    private JTextArea outputArea;

    public frm06() {
        setTitle("Suma de Dígitos");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputNumero = new JTextField(10);
        JButton calcularButton = new JButton("Sumar Dígitos");

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sumarDígitos();
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

    private void sumarDígitos() {
        int n = Integer.parseInt(inputNumero.getText());
        int suma = sumarDigitos(n);
        outputArea.setText("La suma de los dígitos de " + n + " es: " + suma);
    }

    public static int sumarDigitos(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumarDigitos(n / 10);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm06 frame = new frm06();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
