package condicionales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm31 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHorasTrabajadas, txtSueldoBruto, txtDescuento, txtSueldoNeto;
    private JComboBox<String> cmbCategoria;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm31 frame = new frm31();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm31() {
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

        JLabel lblCategoria = new JLabel("Categoría: ");
        lblCategoria.setBounds(20, 70, 150, 30);
        getContentPane().add(lblCategoria);

        String[] categorias = {"A", "B", "C", "D"};
        cmbCategoria = new JComboBox<>(categorias);
        cmbCategoria.setBounds(150, 70, 100, 30);
        getContentPane().add(cmbCategoria);

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

        JLabel lblSueldoNeto = new JLabel("Sueldo neto: ");
        lblSueldoNeto.setBounds(20, 230, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(150, 230, 100, 30);
        txtSueldoNeto.setEditable(false);
        getContentPane().add(txtSueldoNeto);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    private void calcularSueldo() {
        double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
        double tarifaPorHora = obtenerTarifaPorCategoria((String) cmbCategoria.getSelectedItem());
        double sueldoBruto = horasTrabajadas * tarifaPorHora;
        double descuento;

        if (sueldoBruto > 2500) {
            descuento = sueldoBruto * 0.20;
        } else {
            descuento = sueldoBruto * 0.15;
        }

        double sueldoNeto = sueldoBruto - descuento;

        txtSueldoBruto.setText(String.format("%.2f", sueldoBruto));
        txtDescuento.setText(String.format("%.2f", descuento));
        txtSueldoNeto.setText(String.format("%.2f", sueldoNeto));
    }

    private double obtenerTarifaPorCategoria(String categoria) {
        switch (categoria) {
            case "A":
                return 21.00;
            case "B":
                return 19.50;
            case "C":
                return 17.00;
            case "D":
                return 15.50;
            default:
                return 0;
        }
    }
}
