package repetitivas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frm14 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm14 frame = new frm14();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm14() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblNumero = new JLabel("Ingrese un número:");
        lblNumero.setBounds(20, 20, 200, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(150, 20, 100, 30);
        getContentPane().add(txtNumero);

        JButton btnVerificar = new JButton("Verificar Primo");
        btnVerificar.setBounds(75, 70, 150, 30);
        getContentPane().add(btnVerificar);

        btnVerificar.addActionListener(e -> btnVerificar_actionPerformed());
    }

    protected void btnVerificar_actionPerformed() {
        try {
            int numero = Integer.parseInt(txtNumero.getText());

            if (esPrimo(numero)) {
                JOptionPane.showMessageDialog(this, numero + " es un número primo.");
            } else {
                JOptionPane.showMessageDialog(this, numero + " no es un número primo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean esPrimo(int n) {
        if (n <= 1) return false; 
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; 
            }
        }
        return true; 
    }
}
