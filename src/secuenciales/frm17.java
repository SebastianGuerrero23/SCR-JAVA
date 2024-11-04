package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm17 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtDonacion;
    JTextField txtCentroSalud, txtComedorInfantil, txtEscuelaInfantil, txtAsiloAncianos;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm17 frame = new frm17();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm17() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null);

        JLabel lblDonacion = new JLabel("Donación Total:");
        lblDonacion.setBounds(50, 30, 150, 30);
        getContentPane().add(lblDonacion);

        txtDonacion = new JTextField();
        txtDonacion.setBounds(220, 30, 100, 30);
        txtDonacion.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDonacion.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDonacion);

        JButton btnCalcular = new JButton("Calcular Asignaciones");
        btnCalcular.setBounds(120, 70, 160, 30);
        getContentPane().add(btnCalcular);

        // Campos para mostrar los resultados
        JLabel lblCentroSalud = new JLabel("Centro de Salud:");
        lblCentroSalud.setBounds(50, 110, 150, 30);
        getContentPane().add(lblCentroSalud);

        txtCentroSalud = new JTextField();
        txtCentroSalud.setBounds(220, 110, 100, 30);
        txtCentroSalud.setFocusable(false);
        txtCentroSalud.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCentroSalud);

        JLabel lblComedorInfantil = new JLabel("Comedor Infantil:");
        lblComedorInfantil.setBounds(50, 140, 150, 30);
        getContentPane().add(lblComedorInfantil);

        txtComedorInfantil = new JTextField();
        txtComedorInfantil.setBounds(220, 140, 100, 30);
        txtComedorInfantil.setFocusable(false);
        txtComedorInfantil.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtComedorInfantil);

        JLabel lblEscuelaInfantil = new JLabel("Escuela Infantil:");
        lblEscuelaInfantil.setBounds(50, 170, 150, 30);
        getContentPane().add(lblEscuelaInfantil);

        txtEscuelaInfantil = new JTextField();
        txtEscuelaInfantil.setBounds(220, 170, 100, 30);
        txtEscuelaInfantil.setFocusable(false);
        txtEscuelaInfantil.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtEscuelaInfantil);

        JLabel lblAsiloAncianos = new JLabel("Asilo de Ancianos:");
        lblAsiloAncianos.setBounds(50, 200, 150, 30);
        getContentPane().add(lblAsiloAncianos);

        txtAsiloAncianos = new JTextField();
        txtAsiloAncianos.setBounds(220, 200, 100, 30);
        txtAsiloAncianos.setFocusable(false);
        txtAsiloAncianos.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAsiloAncianos);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double donacion = Double.parseDouble(txtDonacion.getText());

        // Calcular
        double centroSalud = donacion * 0.25;
        double comedorInfantil = donacion * 0.35;
        double escuelaInfantil = donacion * 0.25;
        double asiloAncianos = donacion - (centroSalud + comedorInfantil + escuelaInfantil); // El resto va al asilo

        // Resultados
        txtCentroSalud.setText(String.format("%.2f", centroSalud));
        txtComedorInfantil.setText(String.format("%.2f", comedorInfantil));
        txtEscuelaInfantil.setText(String.format("%.2f", escuelaInfantil));
        txtAsiloAncianos.setText(String.format("%.2f", asiloAncianos));
    }
}

