package repetitivas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frm13 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm13 frame = new frm13();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm13() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblNumero = new JLabel("Ingrese un número (n):");
        lblNumero.setBounds(20, 20, 200, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(150, 20, 100, 30);
        getContentPane().add(txtNumero);

        JButton btnCalcular = new JButton("Calcular Suma");
        btnCalcular.setBounds(75, 70, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        try {
            int n = Integer.parseInt(txtNumero.getText());
            int suma = 0;

            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) { 
                    suma += i;
                }
            }

            JOptionPane.showMessageDialog(this, "La suma es: " + suma);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
