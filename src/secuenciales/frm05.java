package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtGB, txtMB, txtKB, txtBytes;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm05 frame = new frm05();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm05() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); // centrar formulario en la mitad de la pantalla

        JLabel lblGB = new JLabel("GB: ");
        lblGB.setBounds(50, 50, 60, 30);
        getContentPane().add(lblGB);

        JLabel lblMB = new JLabel("MB: ");
        lblMB.setBounds(50, 90, 60, 30);
        getContentPane().add(lblMB);

        JLabel lblKB = new JLabel("KB: ");
        lblKB.setBounds(50, 130, 60, 30);
        getContentPane().add(lblKB);

        JLabel lblBytes = new JLabel("Bytes: ");
        lblBytes.setBounds(50, 170, 60, 30);
        getContentPane().add(lblBytes);

        txtGB = new JTextField();
        txtGB.setBounds(120, 50, 60, 30);
        txtGB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtGB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtGB);

        txtMB = new JTextField();
        txtMB.setBounds(120, 90, 60, 30);
        txtMB.setFocusable(false);
        txtMB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMB);

        txtKB = new JTextField();
        txtKB.setBounds(120, 130, 60, 30);
        txtKB.setFocusable(false);
        txtKB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtKB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtKB);

        txtBytes = new JTextField();
        txtBytes.setBounds(120, 170, 60, 30);
        txtBytes.setFocusable(false);
        txtBytes.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBytes.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtBytes);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 210, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double gigabytes = Double.parseDouble(txtGB.getText());

        // Conversión a MB, KB y Bytes
        double megabytes = gigabytes * 1024;
        double kilobytes = megabytes * 1024;
        double bytes = kilobytes * 1024;

        // Mostrar resultados
        txtMB.setText(String.format("%.2f", megabytes));
        txtKB.setText(String.format("%.2f", kilobytes));
        txtBytes.setText(String.format("%.2f", bytes));
    }
}
