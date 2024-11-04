package condicionales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm29 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHorasTrabajadas, txtPagoPorHora, txtSueldoBruto, txtDescuento, txtTotalPagar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm29 frame = new frm29();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm29() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblHorasTrabajadas = new JLabel("Horas trabajadas: ");
        lblHorasTrabajadas.setBounds(20, 30, 150, 30);
        getContentPane().add(lblHorasTrabajadas);

        txtHorasTrabajadas = new JTextField();
        txtHorasTrabajadas.setBounds(150, 30, 100, 30);
        getContentPane().add(txtHorasTrabajadas);

        JLabel lblPagoPorHora = new JLabel("Pago por hora: ");
        lblPagoPorHora.setBounds(20, 70, 150, 30);
        getContentPane().add(lblPagoPorHora);

        txtPagoPorHora = new JTextField();
        txtPagoPorHora.setBounds(150, 70, 100, 30);
        getContentPane().add(txtPagoPorHora);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 110, 130, 30);
        getContentPane().add(btnCalcular);

        JLabel lblSueldoBruto = new JLabel("Sueldo bruto: ");
        lblSueldoBruto.setBounds(20, 150, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(150, 150, 100, 30);
        txtSueldoBruto.setEditable(false);
        getContentPane().add(txtSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(20, 190, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 190, 100, 30);
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotalPagar = new JLabel("Total a pagar: ");
        lblTotalPagar.setBounds(20, 230, 150, 30);
        getContentPane().add(lblTotalPagar);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(150, 230, 100, 30);
        txtTotalPagar.setEditable(false);
        getContentPane().add(txtTotalPagar);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    private void calcularSueldo() {
        double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
        double pagoPorHora = Double.parseDouble(txtPagoPorHora.getText());
        double sueldoBruto, descuento = 0, totalPagar;

        if (horasTrabajadas <= 48) {
            sueldoBruto = horasTrabajadas * pagoPorHora;
        } else {
            double horasExtras = horasTrabajadas - 48;
            sueldoBruto = (48 * pagoPorHora) + (horasExtras * pagoPorHora * 1.2);
        }

        if (sueldoBruto > 1500) {
            descuento = sueldoBruto * 0.11;
        }

        totalPagar = sueldoBruto - descuento;

        txtSueldoBruto.setText(String.format("%.2f", sueldoBruto));
        txtDescuento.setText(String.format("%.2f", descuento));
        txtTotalPagar.setText(String.format("%.2f", totalPagar));
    }
}
