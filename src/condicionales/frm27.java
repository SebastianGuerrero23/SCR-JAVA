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

public class frm27 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMontoVendido, txtSueldoBruto, txtDescuento, txtSueldoNeto, txtPolos;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm27 frame = new frm27();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public frm27() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoVendido = new JLabel("Monto Vendido: ");
        lblMontoVendido.setBounds(50, 50, 120, 30);
        getContentPane().add(lblMontoVendido);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto: ");
        lblSueldoBruto.setBounds(50, 90, 120, 30);
        getContentPane().add(lblSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(50, 130, 120, 30);
        getContentPane().add(lblDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto: ");
        lblSueldoNeto.setBounds(50, 170, 120, 30);
        getContentPane().add(lblSueldoNeto);

        JLabel lblPolos = new JLabel("Polos Obsequiados: ");
        lblPolos.setBounds(50, 210, 150, 30);
        getContentPane().add(lblPolos);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(180, 50, 100, 30);
        txtMontoVendido.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMontoVendido.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMontoVendido);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(180, 90, 100, 30);
        txtSueldoBruto.setEditable(false);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtSueldoBruto);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(180, 130, 100, 30);
        txtDescuento.setEditable(false);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDescuento);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(180, 170, 100, 30);
        txtSueldoNeto.setEditable(false);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtSueldoNeto);

        txtPolos = new JTextField();
        txtPolos.setBounds(180, 210, 100, 30);
        txtPolos.setEditable(false);
        txtPolos.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPolos);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(130, 250, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    private void calcularSueldo() {
        double sueldoBasico = 600;
        double montoVendido = Double.parseDouble(txtMontoVendido.getText());
        double sueldoBruto = sueldoBasico + (0.15 * montoVendido);
        double descuento;
        double sueldoNeto;

        if (sueldoBruto > 1800) {
            descuento = sueldoBruto * 0.10;
        } else {
            descuento = sueldoBruto * 0.05;
        }
        
        sueldoNeto = sueldoBruto - descuento;
        
        // Determinación de polos
        int polos;
        if (montoVendido > 1000) {
            polos = 3;
        } else {
            polos = 1;
        }

        // Mostrar resultados
        txtSueldoBruto.setText(String.format("%.2f", sueldoBruto));
        txtDescuento.setText(String.format("%.2f", descuento));
        txtSueldoNeto.setText(String.format("%.2f", sueldoNeto));
        txtPolos.setText(String.valueOf(polos));
    }
}
