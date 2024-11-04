package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtSuma;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm09 frame = new frm09();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm09() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); // centrar formulario en la mitad de la pantalla

        JLabel lblNumero = new JLabel("Número (4 cifras): ");
        lblNumero.setBounds(50, 50, 120, 30);
        getContentPane().add(lblNumero);

        JLabel lblSuma = new JLabel("Suma de cifras: ");
        lblSuma.setBounds(50, 100, 120, 30);
        getContentPane().add(lblSuma);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 50, 60, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        txtSuma = new JTextField();
        txtSuma.setBounds(180, 100, 60, 30);
        txtSuma.setFocusable(false);
        txtSuma.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSuma.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSuma);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(90, 150, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int numero = Integer.parseInt(txtNumero.getText());
        int suma = 0;

        // Calcular la suma de las cifras
        while (numero > 0) {
            suma += numero % 10; // Sumar el último dígito
            numero /= 10; // Eliminar el último dígito
        }

        // Mostrar el resultado
        txtSuma.setText(String.valueOf(suma));
    }
}

