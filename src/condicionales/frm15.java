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

public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMontoVendido, txtSueldoBruto, txtDescuento, txtSueldoNeto, txtComision;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm15 frame = new frm15();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm15() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoVendido = new JLabel("Monto Vendido: ");
        lblMontoVendido.setBounds(50, 30, 150, 30);
        getContentPane().add(lblMontoVendido);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(200, 30, 150, 30);
        txtMontoVendido.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoVendido.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoVendido);

        JLabel lblComision = new JLabel("Comisión: ");
        lblComision.setBounds(50, 70, 150, 30);
        getContentPane().add(lblComision);

        txtComision = new JTextField();
        txtComision.setBounds(200, 70, 150, 30);
        txtComision.setHorizontalAlignment(SwingConstants.RIGHT);
        txtComision.setEditable(false);
        getContentPane().add(txtComision);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto: ");
        lblSueldoBruto.setBounds(50, 110, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(200, 110, 150, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setEditable(false);
        getContentPane().add(txtSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(50, 150, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 150, 150, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto: ");
        lblSueldoNeto.setBounds(50, 190, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(200, 190, 150, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        getContentPane().add(txtSueldoNeto);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 230, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    private void calcularSueldo() {
        double montoVendido = Double.parseDouble(txtMontoVendido.getText());
        double sueldoBase = 250;
        double comision = 0;

        if (montoVendido > 20000) {
            comision = 0.15 * montoVendido;
        } else if (montoVendido >= 10000) {
            comision = 0.10 * montoVendido;
        } else if (montoVendido >= 5000) {
            comision = 0.08 * montoVendido;
        } else {
            comision = 0.05 * montoVendido;
        }

        double sueldoBruto = sueldoBase + comision;
        double descuento = (sueldoBruto > 3500) ? (0.15 * sueldoBruto) : (0.08 * sueldoBruto);
        double sueldoNeto = sueldoBruto - descuento;

        txtComision.setText(String.format("%.2f", comision));
        txtSueldoBruto.setText(String.format("%.2f", sueldoBruto));
        txtDescuento.setText(String.format("%.2f", descuento));
        txtSueldoNeto.setText(String.format("%.2f", sueldoNeto));
    }
}
