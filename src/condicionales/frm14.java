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

public class frm14 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumeroTarjeta, txtMontoCompra, txtDescuento;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm14 frame = new frm14();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm14() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumeroTarjeta = new JLabel("Número de Tarjeta: ");
        lblNumeroTarjeta.setBounds(50, 30, 150, 30);
        getContentPane().add(lblNumeroTarjeta);

        JLabel lblMontoCompra = new JLabel("Monto de Compra: ");
        lblMontoCompra.setBounds(50, 80, 150, 30);
        getContentPane().add(lblMontoCompra);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(50, 130, 150, 30);
        getContentPane().add(lblDescuento);

        txtNumeroTarjeta = new JTextField();
        txtNumeroTarjeta.setBounds(200, 30, 100, 30);
        txtNumeroTarjeta.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumeroTarjeta.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumeroTarjeta);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(200, 80, 100, 30);
        txtMontoCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoCompra.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoCompra);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 130, 100, 30);
        txtDescuento.setEditable(false);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDescuento);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 180, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularDescuento();
            }
        });
    }

    private void calcularDescuento() {
        int numeroTarjeta = Integer.parseInt(txtNumeroTarjeta.getText());
        double montoCompra = Double.parseDouble(txtMontoCompra.getText());
        double descuento;

        if (numeroTarjeta % 2 == 0 && numeroTarjeta >= 100) {
            descuento = montoCompra * 0.15;  // 15% de descuento
        } else {
            descuento = montoCompra * 0.05;  // 5% de descuento
        }

        txtDescuento.setText(String.format("%.2f", descuento));
    }
}
