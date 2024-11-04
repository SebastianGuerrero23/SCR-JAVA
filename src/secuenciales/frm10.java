package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtNumeroInvertido;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm10 frame = new frm10();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); // centrar formulario en la mitad de la pantalla

        JLabel lblNumero = new JLabel("Número (4 cifras): ");
        lblNumero.setBounds(50, 50, 120, 30);
        getContentPane().add(lblNumero);

        JLabel lblInvertido = new JLabel("Número Invertido: ");
        lblInvertido.setBounds(50, 100, 120, 30);
        getContentPane().add(lblInvertido);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 50, 60, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        txtNumeroInvertido = new JTextField();
        txtNumeroInvertido.setBounds(180, 100, 60, 30);
        txtNumeroInvertido.setFocusable(false);
        txtNumeroInvertido.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumeroInvertido.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumeroInvertido);

        JButton btnInvertir = new JButton("Invertir");
        btnInvertir.setBounds(90, 150, 100, 30);
        getContentPane().add(btnInvertir);

        btnInvertir.addActionListener(e -> btnInvertir_actionPerformed());
    }

    protected void btnInvertir_actionPerformed() {
        int numero = Integer.parseInt(txtNumero.getText());
        int numeroInvertido = 0;

        // Invertir el número
        while (numero > 0) {
            numeroInvertido = numeroInvertido * 10 + (numero % 10); // Agregar el último dígito
            numero /= 10; // Eliminar el último dígito
        }

        // Mostrar el resultado
        txtNumeroInvertido.setText(String.valueOf(numeroInvertido));
    }
}
