package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField inputNumero;
    private JTextArea outputArea;

    public frm09() {
        setTitle("Tabla de Multiplicar");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        inputNumero = new JTextField(10);
        JButton calcularButton = new JButton("Generar Tabla");

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarTabla();
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

    private void generarTabla() {
        int n = Integer.parseInt(inputNumero.getText());
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= 12; i++) {
            resultado.append(n).append(" x ").append(i).append(" = ").append(n * i).append("\n");
        }
        outputArea.setText("Tabla de multiplicar del " + n + ":\n" + resultado.toString());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm09 frame = new frm09();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
