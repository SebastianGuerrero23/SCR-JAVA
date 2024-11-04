package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm18 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtDonacion, txtCentroSalud, txtComedorNiños, txtInversion;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm18 frame = new frm18();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm18() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblDonacion = new JLabel("Monto de Donación: ");
        lblDonacion.setBounds(50, 30, 150, 30);
        getContentPane().add(lblDonacion);

        txtDonacion = new JTextField();
        txtDonacion.setBounds(200, 30, 150, 30);
        txtDonacion.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDonacion.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDonacion);

        JLabel lblCentroSalud = new JLabel("Centro de Salud: ");
        lblCentroSalud.setBounds(50, 70, 150, 30);
        getContentPane().add(lblCentroSalud);

        txtCentroSalud = new JTextField();
        txtCentroSalud.setBounds(200, 70, 150, 30);
        txtCentroSalud.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCentroSalud.setEditable(false);
        getContentPane().add(txtCentroSalud);

        JLabel lblComedorNiños = new JLabel("Comedor de Niños: ");
        lblComedorNiños.setBounds(50, 110, 150, 30);
        getContentPane().add(lblComedorNiños);

        txtComedorNiños = new JTextField();
        txtComedorNiños.setBounds(200, 110, 150, 30);
        txtComedorNiños.setHorizontalAlignment(SwingConstants.RIGHT);
        txtComedorNiños.setEditable(false);
        getContentPane().add(txtComedorNiños);

        JLabel lblInversion = new JLabel("Inversión en Bolsa: ");
        lblInversion.setBounds(50, 150, 150, 30);
        getContentPane().add(lblInversion);

        txtInversion = new JTextField();
        txtInversion.setBounds(200, 150, 150, 30);
        txtInversion.setHorizontalAlignment(SwingConstants.RIGHT);
        txtInversion.setEditable(false);
        getContentPane().add(txtInversion);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 200, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularDistribucion();
            }
        });
    }

    private void calcularDistribucion() {
        double donacion = Double.parseDouble(txtDonacion.getText());
        double centroSalud, comedorNiños, inversion;

        if (donacion >= 10000) {
            centroSalud = donacion * 0.30; // 30% salud
            comedorNiños = donacion * 0.50; // 50% comedor 
        } else {
            centroSalud = donacion * 0.25; // 25% salud
            comedorNiños = donacion * 0.60; // 60%comedor 
        }

        inversion = donacion - (centroSalud + comedorNiños); // El resto a la bolsa

        txtCentroSalud.setText(String.format("%.2f", centroSalud));
        txtComedorNiños.setText(String.format("%.2f", comedorNiños));
        txtInversion.setText(String.format("%.2f", inversion));
    }
}
