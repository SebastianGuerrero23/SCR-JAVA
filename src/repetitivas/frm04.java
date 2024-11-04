package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm04 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero;
    JTextField txtMultiplos;
    JTextField txtCantidad;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm04 frame = new frm04();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm04() {
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

        JLabel lblCantidad = new JLabel("Cantidad (m):");
        lblCantidad.setBounds(50, 70, 100, 30);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 70, 100, 30);
        txtCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCantidad.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCantidad);

        JButton btnCalcular = new JButton("Mostrar Múltiplos");
        btnCalcular.setBounds(100, 110, 150, 30);
        getContentPane().add(btnCalcular);

        JLabel lblMultiplos = new JLabel("Múltiplos:");
        lblMultiplos.setBounds(50, 150, 100, 30);
        getContentPane().add(lblMultiplos);

        txtMultiplos = new JTextField();
        txtMultiplos.setBounds(150, 150, 200, 30);
        txtMultiplos.setFocusable(false);
        txtMultiplos.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().add(txtMultiplos);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int n = Integer.parseInt(txtNumero.getText());
        int m = Integer.parseInt(txtCantidad.getText());
        StringBuilder multiples = new StringBuilder();

        // Calcular
        for (int i = 1; i <= m; i++) {
            multiples.append(n * i).append(i < m ? ", " : "");
        }

        txtMultiplos.setText(multiples.toString());
    }
}
