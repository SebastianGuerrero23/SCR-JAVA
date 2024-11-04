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

public class frm17 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtDocenas, txtMonto, txtDescuento, txtTotal, txtLapiceros;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm17 frame = new frm17();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm17() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblDocenas = new JLabel("Docenas: ");
        lblDocenas.setBounds(50, 30, 100, 30);
        getContentPane().add(lblDocenas);

        txtDocenas = new JTextField();
        txtDocenas.setBounds(150, 30, 100, 30);
        txtDocenas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDocenas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDocenas);

        JLabel lblMonto = new JLabel("Monto: ");
        lblMonto.setBounds(50, 70, 100, 30);
        getContentPane().add(lblMonto);

        txtMonto = new JTextField();
        txtMonto.setBounds(150, 70, 100, 30);
        txtMonto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMonto.setEditable(false);
        getContentPane().add(txtMonto);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(50, 110, 100, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 110, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotal = new JLabel("Total a Pagar: ");
        lblTotal.setBounds(50, 150, 100, 30);
        getContentPane().add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(150, 150, 100, 30);
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotal.setEditable(false);
        getContentPane().add(txtTotal);

        JLabel lblLapiceros = new JLabel("Lapiceros: ");
        lblLapiceros.setBounds(50, 190, 100, 30);
        getContentPane().add(lblLapiceros);

        txtLapiceros = new JTextField();
        txtLapiceros.setBounds(150, 190, 100, 30);
        txtLapiceros.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLapiceros.setEditable(false);
        getContentPane().add(txtLapiceros);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 230, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularCompra();
            }
        });
    }

    private void calcularCompra() {
        int docenas = Integer.parseInt(txtDocenas.getText());
        double precioPorDocena = 100; // Puedes ajustar el precio base por docena aquí.
        
        double monto = precioPorDocena * docenas;
        double descuento = calcularDescuento(docenas, monto);
        double total = monto - descuento;
        int lapiceros = calcularLapiceros(docenas);

        txtMonto.setText(String.format("%.2f", monto));
        txtDescuento.setText(String.format("%.2f", descuento));
        txtTotal.setText(String.format("%.2f", total));
        txtLapiceros.setText(String.valueOf(lapiceros));
    }

    private double calcularDescuento(int docenas, double monto) {
        double porcentajeDescuento;

        if (docenas >= 6) {
            porcentajeDescuento = 0.15; // 15% de descuento
        } else {
            porcentajeDescuento = 0.10; // 10% de descuento
        }

        return monto * porcentajeDescuento;
    }

    private int calcularLapiceros(int docenas) {
        if (docenas >= 30) {
            return (docenas / 3) * 2; // 2 lapiceros por cada 3 docenas
        }
        return 0; // Sin obsequios
    }
}
