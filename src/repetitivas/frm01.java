package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm01 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtDividendo, txtDivisor;
    JTextField txtCociente, txtResto;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm01 frame = new frm01();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm01() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null);

        JLabel lblDividendo = new JLabel("Dividendo:");
        lblDividendo.setBounds(50, 30, 80, 30);
        getContentPane().add(lblDividendo);

        txtDividendo = new JTextField();
        txtDividendo.setBounds(150, 30, 100, 30);
        txtDividendo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDividendo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDividendo);

        JLabel lblDivisor = new JLabel("Divisor:");
        lblDivisor.setBounds(50, 70, 80, 30);
        getContentPane().add(lblDivisor);

        txtDivisor = new JTextField();
        txtDivisor.setBounds(150, 70, 100, 30);
        txtDivisor.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDivisor.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDivisor);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 110, 130, 30);
        getContentPane().add(btnCalcular);

        JLabel lblCociente = new JLabel("Cociente:");
        lblCociente.setBounds(50, 150, 80, 30);
        getContentPane().add(lblCociente);

        txtCociente = new JTextField();
        txtCociente.setBounds(150, 150, 100, 30);
        txtCociente.setFocusable(false);
        txtCociente.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCociente);

        JLabel lblResto = new JLabel("Resto:");
        lblResto.setBounds(50, 190, 80, 30);
        getContentPane().add(lblResto);

        txtResto = new JTextField();
        txtResto.setBounds(150, 190, 100, 30);
        txtResto.setFocusable(false);
        txtResto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResto);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int dividendo = Integer.parseInt(txtDividendo.getText());
        int divisor = Integer.parseInt(txtDivisor.getText());

        int cociente = 0;
        int resto = dividendo;

        while (resto >= divisor) {
            resto -= divisor;
            cociente++;
        }

        txtCociente.setText(String.valueOf(cociente));
        txtResto.setText(String.valueOf(resto));
    }
}
