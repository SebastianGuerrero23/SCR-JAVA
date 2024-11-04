package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero1, txtNumero2, txtNumero3, txtNumeroIntermedio;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm07 frame = new frm07();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm07() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero1 = new JLabel("Número 1: ");
        lblNumero1.setBounds(50, 30, 100, 30);
        getContentPane().add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(150, 30, 100, 30);
        txtNumero1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Número 2: ");
        lblNumero2.setBounds(50, 70, 100, 30);
        getContentPane().add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(150, 70, 100, 30);
        txtNumero2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero2);

        JLabel lblNumero3 = new JLabel("Número 3: ");
        lblNumero3.setBounds(50, 110, 100, 30);
        getContentPane().add(lblNumero3);

        txtNumero3 = new JTextField();
        txtNumero3.setBounds(150, 110, 100, 30);
        txtNumero3.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero3.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero3);

        JLabel lblNumeroIntermedio = new JLabel("Número Intermedio: ");
        lblNumeroIntermedio.setBounds(50, 150, 150, 30);
        getContentPane().add(lblNumeroIntermedio);

        txtNumeroIntermedio = new JTextField();
        txtNumeroIntermedio.setBounds(200, 150, 100, 30);
        txtNumeroIntermedio.setEditable(false);
        txtNumeroIntermedio.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtNumeroIntermedio);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 200, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularNumeroIntermedio();
            }
        });
    }

    private void calcularNumeroIntermedio() {
        int num1 = Integer.parseInt(txtNumero1.getText());
        int num2 = Integer.parseInt(txtNumero2.getText());
        int num3 = Integer.parseInt(txtNumero3.getText());

        // Determinar el número intermedio sin usar operadores lógicos
        int intermedio;
        if ((num1 > num2 && num1 < num3) || (num1 < num2 && num1 > num3)) {
            intermedio = num1;
        } else if ((num2 > num1 && num2 < num3) || (num2 < num1 && num2 > num3)) {
            intermedio = num2;
        } else {
            intermedio = num3;
        }

        // Mostrar el resultado
        txtNumeroIntermedio.setText(String.valueOf(intermedio));
    }
}
