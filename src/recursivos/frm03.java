package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm03 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField inputNumero;
    private JTextArea outputArea;

    public frm03() {
        setTitle("Serie de Fibonacci");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputNumero = new JTextField(10);
        JButton calcularButton = new JButton("Calcular Fibonacci");

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFibonacci();
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

    private void calcularFibonacci() {
        int n = Integer.parseInt(inputNumero.getText());
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultado.append(fibonacci(i)).append(" ");
        }
        outputArea.setText("Fibonacci hasta " + n + ": " + resultado.toString());
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm03 frame = new frm03();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

