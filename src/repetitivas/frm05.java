package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm05 frame = new frm05();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm05() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblNumero = new JLabel("Número (n):");
        lblNumero.setBounds(50, 30, 100, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(150, 30, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JButton btnCalcular = new JButton("Generar Tabla");
        btnCalcular.setBounds(100, 70, 150, 30);
        getContentPane().add(btnCalcular);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 110, 100, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 110, 200, 70);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().add(txtResultado);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int n = Integer.parseInt(txtNumero.getText());
        StringBuilder tabla = new StringBuilder();

        for (int i = 1; i <= 12; i++) {
            tabla.append(n).append(" x ").append(i).append(" = ").append(n * i).append("\n");
        }

        txtResultado.setText(tabla.toString());
    }
}
