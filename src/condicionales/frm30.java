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

public class frm30 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCuota, txtDiaPago, txtResultado;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm30 frame = new frm30();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public frm30() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCuota = new JLabel("Cuota: ");
        lblCuota.setBounds(50, 50, 100, 30);
        getContentPane().add(lblCuota);

        JLabel lblDiaPago = new JLabel("Día de Pago: ");
        lblDiaPago.setBounds(50, 90, 100, 30);
        getContentPane().add(lblDiaPago);

        JLabel lblResultado = new JLabel("Total a Pagar: ");
        lblResultado.setBounds(50, 180, 100, 30);
        getContentPane().add(lblResultado);

        txtCuota = new JTextField();
        txtCuota.setBounds(160, 50, 100, 30);
        txtCuota.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuota.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCuota);

        txtDiaPago = new JTextField();
        txtDiaPago.setBounds(160, 90, 100, 30);
        txtDiaPago.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDiaPago.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDiaPago);

        txtResultado = new JTextField();
        txtResultado.setBounds(160, 180, 100, 30);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado.setEditable(false);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 130, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        double cuota = Double.parseDouble(txtCuota.getText());
        int diaPago = Integer.parseInt(txtDiaPago.getText());
        double total = cuota;

        if (diaPago >= 1 && diaPago <= 10) {
            double descuento = Math.max(5, 0.02 * cuota);
            total -= descuento;
        } else if (diaPago >= 21 && diaPago <= 31) {
            double recargo = Math.max(10, 0.03 * cuota);
            total += recargo;
        }

        txtResultado.setText(String.format("%.2f", total));
    }
}
