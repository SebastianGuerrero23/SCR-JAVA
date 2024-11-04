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

public class frm26 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMontoCompra, txtPrestamo, txtInteres, txtPropioDinero, txtTotalAPagar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm26 frame = new frm26();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm26() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoCompra = new JLabel("Monto Total de la Compra: ");
        lblMontoCompra.setBounds(30, 30, 180, 30);
        getContentPane().add(lblMontoCompra);

        JLabel lblPrestamo = new JLabel("Préstamo: ");
        lblPrestamo.setBounds(30, 80, 150, 30);
        getContentPane().add(lblPrestamo);

        JLabel lblInteres = new JLabel("Interés: ");
        lblInteres.setBounds(30, 130, 150, 30);
        getContentPane().add(lblInteres);

        JLabel lblPropioDinero = new JLabel("Propio Dinero: ");
        lblPropioDinero.setBounds(30, 180, 150, 30);
        getContentPane().add(lblPropioDinero);

        JLabel lblTotalAPagar = new JLabel("Total a Pagar: ");
        lblTotalAPagar.setBounds(30, 230, 150, 30);
        getContentPane().add(lblTotalAPagar);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(220, 30, 100, 30);
        txtMontoCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoCompra.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoCompra);

        txtPrestamo = new JTextField();
        txtPrestamo.setBounds(220, 80, 100, 30);
        txtPrestamo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPrestamo.setEditable(false);
        getContentPane().add(txtPrestamo);

        txtInteres = new JTextField();
        txtInteres.setBounds(220, 130, 100, 30);
        txtInteres.setHorizontalAlignment(SwingConstants.RIGHT);
        txtInteres.setEditable(false);
        getContentPane().add(txtInteres);

        txtPropioDinero = new JTextField();
        txtPropioDinero.setBounds(220, 180, 100, 30);
        txtPropioDinero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPropioDinero.setEditable(false);
        getContentPane().add(txtPropioDinero);

        txtTotalAPagar = new JTextField();
        txtTotalAPagar.setBounds(220, 230, 100, 30);
        txtTotalAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalAPagar.setEditable(false);
        getContentPane().add(txtTotalAPagar);

        JButton btnCalcular = new JButton("Calcular Pago");
        btnCalcular.setBounds(100, 270, 200, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPago();
            }
        });
    }

    private void calcularPago() {
        double montoCompra = Double.parseDouble(txtMontoCompra.getText());
        double prestamo, propioDinero, interes, totalAPagar;

        if (montoCompra > 5000) {
            prestamo = montoCompra * 0.30;
        } else {
            prestamo = montoCompra * 0.20;
        }

        interes = prestamo * 0.10;
        totalAPagar = prestamo + interes;
        propioDinero = montoCompra - totalAPagar;

        txtPrestamo.setText(String.format("%.2f", prestamo));
        txtInteres.setText(String.format("%.2f", interes));
        txtPropioDinero.setText(String.format("%.2f", propioDinero));
        txtTotalAPagar.setText(String.format("%.2f", totalAPagar));
    }
}
