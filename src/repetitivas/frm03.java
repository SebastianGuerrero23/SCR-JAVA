package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm03 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtCantidadDivisores;

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

    public frm03() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 200);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(50, 30, 80, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(150, 30, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JButton btnCalcular = new JButton("Calcular Divisores");
        btnCalcular.setBounds(100, 70, 150, 30);
        getContentPane().add(btnCalcular);

        JLabel lblCantidadDivisores = new JLabel("Cantidad de Divisores:");
        lblCantidadDivisores.setBounds(50, 110, 150, 30);
        getContentPane().add(lblCantidadDivisores);

        txtCantidadDivisores = new JTextField();
        txtCantidadDivisores.setBounds(200, 110, 50, 30);
        txtCantidadDivisores.setFocusable(false);
        txtCantidadDivisores.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCantidadDivisores);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int numero = Integer.parseInt(txtNumero.getText());
        int cantidadDivisores = 0;

        for (int i = 1; i <= Math.abs(numero); i++) {
            if (numero % i == 0) {
                cantidadDivisores++;
            }
        }
        
        txtCantidadDivisores.setText(String.valueOf(cantidadDivisores));
    }
}
