package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm02 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField inputNumero1;
    private JTextField inputNumero2;
    private JTextArea outputArea;
    private JTextField inputNumeroSuma;

    public frm02() {
        setTitle("Operaciones Recursivas");
        setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        inputNumero1 = new JTextField();
        inputNumero2 = new JTextField();
        inputNumeroSuma = new JTextField();

        panel.add(new JLabel("Número 1:"));
        panel.add(inputNumero1);

        panel.add(new JLabel("Número 2:"));
        panel.add(inputNumero2);

        panel.add(new JLabel("Número para Sumar Dígitos:"));
        panel.add(inputNumeroSuma);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        panel.add(calcularButton);
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void calcular() {
        StringBuilder resultado = new StringBuilder();

        // Obtener números de los campos de entrada
        int numero1 = Integer.parseInt(inputNumero1.getText());
        int numero2 = Integer.parseInt(inputNumero2.getText());
        int numeroSuma = Integer.parseInt(inputNumeroSuma.getText());

        // Calcular MCD
        int mcd = calcularMCD(numero1, numero2);
        resultado.append("El MCD de ").append(numero1).append(" y ").append(numero2).append(" es: ").append(mcd).append("\n");

        // Calcular MCM
        int mcm = calcularMCM(numero1, numero2);
        resultado.append("El MCM de ").append(numero1).append(" y ").append(numero2).append(" es: ").append(mcm).append("\n");

        // Sumar dígitos
        int sumaDígitos = sumarDigitos(numeroSuma);
        resultado.append("La suma de los dígitos de ").append(numeroSuma).append(" es: ").append(sumaDígitos).append("\n");

        outputArea.setText(resultado.toString());
    }

    // Método para calcular el MCD
    public static int calcularMCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calcularMCD(b, a % b);
    }

    // Método para calcular el MCM
    public static int calcularMCM(int a, int b) {
        return (a * b) / calcularMCD(a, b);
    }

    // Método para sumar los dígitos de un número
    public static int sumarDigitos(int numero) {
        if (numero == 0) {
            return 0;
        }
        return (numero % 10) + sumarDigitos(numero / 10);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm02 frame = new frm02();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
