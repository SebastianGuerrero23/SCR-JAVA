package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm11 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero1, txtNumero2, txtResultado1, txtResultado2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm11 frame = new frm11();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm11() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); // centrar formulario en la mitad de la pantalla

        JLabel lblNumero1 = new JLabel("Número 1 (3 cifras): ");
        lblNumero1.setBounds(50, 50, 150, 30);
        getContentPane().add(lblNumero1);

        JLabel lblNumero2 = new JLabel("Número 2 (3 cifras): ");
        lblNumero2.setBounds(50, 100, 150, 30);
        getContentPane().add(lblNumero2);

        JLabel lblResultado1 = new JLabel("Resultado 1: ");
        lblResultado1.setBounds(50, 150, 150, 30);
        getContentPane().add(lblResultado1);

        JLabel lblResultado2 = new JLabel("Resultado 2: ");
        lblResultado2.setBounds(50, 180, 150, 30);
        getContentPane().add(lblResultado2);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(200, 50, 60, 30);
        txtNumero1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero1);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(200, 100, 60, 30);
        txtNumero2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero2);

        txtResultado1 = new JTextField();
        txtResultado1.setBounds(200, 150, 60, 30);
        txtResultado1.setFocusable(false);
        txtResultado1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtResultado1);

        txtResultado2 = new JTextField();
        txtResultado2.setBounds(200, 180, 60, 30);
        txtResultado2.setFocusable(false);
        txtResultado2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtResultado2);

        JButton btnIntercambiar = new JButton("Intercambiar");
        btnIntercambiar.setBounds(80, 220, 130, 30);
        getContentPane().add(btnIntercambiar);

        btnIntercambiar.addActionListener(e -> btnIntercambiar_actionPerformed());
    }

    protected void btnIntercambiar_actionPerformed() {
        int numero1 = Integer.parseInt(txtNumero1.getText());
        int numero2 = Integer.parseInt(txtNumero2.getText());

        // Extraer cifras
        int cifra1Numero1 = numero1 / 100; // Primera cifra de numero1
        int cifra2Numero1 = (numero1 / 10) % 10; // Segunda cifra de numero1
        int cifra3Numero1 = numero1 % 10; // Tercera cifra de numero1

        int cifra1Numero2 = numero2 / 100; // Primera cifra de numero2
        int cifra2Numero2 = (numero2 / 10) % 10; // Segunda cifra de numero2
        int cifra3Numero2 = numero2 % 10; // Tercera cifra de numero2

        // Intercambiar cifras
        int resultado1 = cifra3Numero2 * 100 + cifra2Numero1 * 10 + cifra1Numero2;
        int resultado2 = cifra3Numero1 * 100 + cifra2Numero2 * 10 + cifra1Numero1;

        // Mostrar resultados
        txtResultado1.setText(String.valueOf(resultado1));
        txtResultado2.setText(String.valueOf(resultado2));
    }
}

