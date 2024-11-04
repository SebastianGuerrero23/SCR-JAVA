package repetitivas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm11 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCantidad;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm11 frame = new frm11();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm11() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblCantidad = new JLabel("Cantidad de capicúas:");
        lblCantidad.setBounds(20, 30, 200, 30);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(20, 70, 200, 30);
        txtCantidad.setFocusable(false);
        txtCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCantidad);

        JButton btnContar = new JButton("Contar Capicúas");
        btnContar.setBounds(50, 120, 150, 30);
        getContentPane().add(btnContar);

        btnContar.addActionListener(e -> btnContar_actionPerformed());
    }

    protected void btnContar_actionPerformed() {
        int cantidad = 0;

        for (int i = 100; i < 1000; i++) {
            String numStr = String.valueOf(i);
            if (numStr.charAt(0) == numStr.charAt(2)) {  
                cantidad++;
            }
        }

        txtCantidad.setText(String.valueOf(cantidad));
    }
}
