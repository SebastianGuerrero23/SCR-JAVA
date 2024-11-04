package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm19 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMontoVendido;
    JTextField txtComision, txtSueldoBruto, txtDescuento, txtSueldoNeto;

    private static final double SUELDO_BASICO = 500.00;
    private static final double PORCENTAJE_COMISION = 0.09;
    private static final double PORCENTAJE_DESCUENTO = 0.11;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm19 frame = new frm19();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm19() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblMontoVendido = new JLabel("Monto total vendido:");
        lblMontoVendido.setBounds(50, 30, 150, 30);
        getContentPane().add(lblMontoVendido);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(220, 30, 100, 30);
        txtMontoVendido.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoVendido.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoVendido);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 70, 100, 30);
        getContentPane().add(btnCalcular);

        // Campos para mostrar los resultados
        JLabel lblComision = new JLabel("Comisión:");
        lblComision.setBounds(50, 110, 150, 30);
        getContentPane().add(lblComision);

        txtComision = new JTextField();
        txtComision.setBounds(220, 110, 100, 30);
        txtComision.setFocusable(false);
        txtComision.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtComision);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(50, 150, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(220, 150, 100, 30);
        txtSueldoBruto.setFocusable(false);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 190, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(220, 190, 100, 30);
        txtDescuento.setFocusable(false);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(50, 230, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(220, 230, 100, 30);
        txtSueldoNeto.setFocusable(false);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtSueldoNeto);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double montoVendido = Double.parseDouble(txtMontoVendido.getText());

        // Calcular
        double comision = montoVendido * PORCENTAJE_COMISION;

        double sueldoBruto = SUELDO_BASICO + comision;

        double descuento = sueldoBruto * PORCENTAJE_DESCUENTO;

        double sueldoNeto = sueldoBruto - descuento;

        // Resultados finales
        txtComision.setText(String.format("S/. %.2f", comision));
        txtSueldoBruto.setText(String.format("S/. %.2f", sueldoBruto));
        txtDescuento.setText(String.format("S/. %.2f", descuento));
        txtSueldoNeto.setText(String.format("S/. %.2f", sueldoNeto));
    }
}

