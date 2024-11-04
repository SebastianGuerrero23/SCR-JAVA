package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm04 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtPies, txtPulgadas, txtMetros;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm04 frame = new frm04();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm04() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); // centrar formulario en la mitad de la pantalla

        JLabel lblPies = new JLabel("Pies: ");
        lblPies.setBounds(50, 50, 60, 30);
        getContentPane().add(lblPies);

        JLabel lblPulgadas = new JLabel("Pulgadas: ");
        lblPulgadas.setBounds(50, 90, 80, 30);
        getContentPane().add(lblPulgadas);

        JLabel lblMetros = new JLabel("Metros: ");
        lblMetros.setBounds(50, 130, 60, 30);
        getContentPane().add(lblMetros);

        txtPies = new JTextField();
        txtPies.setBounds(120, 50, 60, 30);
        txtPies.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPies.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPies);

        txtPulgadas = new JTextField();
        txtPulgadas.setBounds(120, 90, 60, 30);
        txtPulgadas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPulgadas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPulgadas);

        txtMetros = new JTextField();
        txtMetros.setBounds(120, 130, 60, 30);
        txtMetros.setFocusable(false);
        txtMetros.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMetros.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMetros);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 180, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int pies = Integer.parseInt(txtPies.getText());
        int pulgadas = Integer.parseInt(txtPulgadas.getText());

        // Conversión a metros
        double totalMetros = (pies * 0.3048) + (pulgadas * 0.0254);

        // Mostrar el resultado
        txtMetros.setText(String.format("%.2f", totalMetros));
    }
}

