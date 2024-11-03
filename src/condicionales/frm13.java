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

public class frm13 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm13 frame = new frm13();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm13() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número (3 cifras): ");
        lblNumero.setBounds(50, 30, 150, 30);
        getContentPane().add(lblNumero);

        JLabel lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 80, 100, 30);
        getContentPane().add(lblResultado);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        this.txtResultado = new JTextField();
        txtResultado.setBounds(200, 80, 100, 30);
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Verificar");
        btnCalcular.setBounds(120, 130, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarCifras();
            }
        });
    }

    private void verificarCifras() {
        int numero = Integer.parseInt(txtNumero.getText());
        String resultado;

        if (numero >= 100 && numero <= 999) {
            int cifra1 = numero / 100;
            int cifra2 = (numero / 10) % 10;
            int cifra3 = numero % 10;

            if ((cifra2 == cifra1 + 1 && cifra3 == cifra2 + 1) || (cifra2 == cifra1 - 1 && cifra3 == cifra2 - 1)) {
                resultado = "Cifras consecutivas";
            } else {
                resultado = "Cifras NO consecutivas";
            }
        } else {
            resultado = "Número no válido";
        }

        txtResultado.setText(resultado);
    }
}
