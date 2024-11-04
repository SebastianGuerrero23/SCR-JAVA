package secuenciales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm03 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtKilometros, txtPies, txtMillas;
    JTextField txtMetros, txtYardas;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm03 frame = new frm03();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm03() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 350); // Tamaño de la ventana
        setLayout(null);
        setLocationRelativeTo(null); // Centrar formulario

        JLabel lblKilometros = new JLabel("Kilómetros: ");
        lblKilometros.setBounds(50, 30, 100, 30);
        getContentPane().add(lblKilometros);

        txtKilometros = new JTextField();
        txtKilometros.setBounds(150, 30, 60, 30);
        txtKilometros.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtKilometros);

        JLabel lblPies = new JLabel("Pies: ");
        lblPies.setBounds(50, 80, 100, 30);
        getContentPane().add(lblPies);

        txtPies = new JTextField();
        txtPies.setBounds(150, 80, 60, 30);
        txtPies.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPies);

        JLabel lblMillas = new JLabel("Millas: ");
        lblMillas.setBounds(50, 130, 100, 30);
        getContentPane().add(lblMillas);

        txtMillas = new JTextField();
        txtMillas.setBounds(150, 130, 60, 30);
        txtMillas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtMillas);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 180, 100, 30);
        getContentPane().add(btnCalcular);

        JLabel lblMetros = new JLabel("Total en Metros: ");
        lblMetros.setBounds(50, 230, 120, 30);
        getContentPane().add(lblMetros);

        txtMetros = new JTextField();
        txtMetros.setBounds(180, 230, 100, 30);
        txtMetros.setFocusable(false);
        txtMetros.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtMetros);

        JLabel lblYardas = new JLabel("Total en Yardas: ");
        lblYardas.setBounds(50, 280, 120, 30);
        getContentPane().add(lblYardas);

        txtYardas = new JTextField();
        txtYardas.setBounds(180, 280, 100, 30);
        txtYardas.setFocusable(false);
        txtYardas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtYardas);

        btnCalcular.addActionListener(e -> calcular());
    }

    private void calcular() {
        double kilometros = Double.parseDouble(txtKilometros.getText());
        double pies = Double.parseDouble(txtPies.getText());
        double millas = Double.parseDouble(txtMillas.getText());

        // Convertir todo a metros
        double totalMetros = (kilometros * 1000) + (pies / 3.2808) + (millas * 1609);
        double totalYardas = totalMetros / 0.9144; // 1 yarda = 0.9144 metros

        txtMetros.setText(String.format("%.2f", totalMetros));
        txtYardas.setText(String.format("%.2f", totalYardas));
    }
}
