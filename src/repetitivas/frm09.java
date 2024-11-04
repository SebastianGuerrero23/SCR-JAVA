package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtAltura, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm09 frame = new frm09();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm09() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null);

        JLabel lblAltura = new JLabel("Altura (n):");
        lblAltura.setBounds(50, 30, 80, 30);
        getContentPane().add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(150, 30, 100, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAltura.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAltura);

        JButton btnDibujar = new JButton("Dibujar Rectángulo");
        btnDibujar.setBounds(50, 70, 200, 30);
        getContentPane().add(btnDibujar);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 110, 80, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(50, 140, 250, 60);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().add(txtResultado);

        btnDibujar.addActionListener(e -> btnDibujar_actionPerformed());
    }

    protected void btnDibujar_actionPerformed() {
        int altura = Integer.parseInt(txtAltura.getText());
        StringBuilder rectangulo = new StringBuilder();

        if (altura >= 4) {
            
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < 2 * altura; j++) {
                    rectangulo.append("*");
                }
                rectangulo.append("\n");
            }
            txtResultado.setText(rectangulo.toString());
        } else {
            txtResultado.setText("La altura debe ser >= 4.");
        }
    }
}
