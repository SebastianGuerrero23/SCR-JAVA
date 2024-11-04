package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm07 frame = new frm07();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm07() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
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

        JButton btnCalcular = new JButton("Calcular Factorial");
        btnCalcular.setBounds(50, 80, 200, 30);
        getContentPane().add(btnCalcular);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 120, 80, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 120, 100, 30);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int n = Integer.parseInt(txtNumero.getText());
        long factorial = 1;

        // Calcular
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        txtResultado.setText(String.valueOf(factorial));
    }
}
