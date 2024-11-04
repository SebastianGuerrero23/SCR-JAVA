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

public class frm25 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtSueldoBruto, txtNumeroHijos, txtBonificacion, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm25 frame = new frm25();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm25() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto: ");
        lblSueldoBruto.setBounds(30, 30, 150, 30);
        getContentPane().add(lblSueldoBruto);

        JLabel lblNumeroHijos = new JLabel("Número de Hijos: ");
        lblNumeroHijos.setBounds(30, 80, 150, 30);
        getContentPane().add(lblNumeroHijos);

        JLabel lblBonificacion = new JLabel("Bonificación: ");
        lblBonificacion.setBounds(30, 130, 150, 30);
        getContentPane().add(lblBonificacion);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto: ");
        lblSueldoNeto.setBounds(30, 180, 150, 30);
        getContentPane().add(lblSueldoNeto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(180, 30, 100, 30);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoBruto);

        txtNumeroHijos = new JTextField();
        txtNumeroHijos.setBounds(180, 80, 100, 30);
        txtNumeroHijos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumeroHijos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumeroHijos);

        txtBonificacion = new JTextField();
        txtBonificacion.setBounds(180, 130, 100, 30);
        txtBonificacion.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBonificacion.setEditable(false);
        getContentPane().add(txtBonificacion);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(180, 180, 100, 30);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setEditable(false);
        getContentPane().add(txtSueldoNeto);

        JButton btnCalcular = new JButton("Calcular Bonificación");
        btnCalcular.setBounds(80, 220, 180, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularBonificacion();
            }
        });
    }

    private void calcularBonificacion() {
        double sueldoBruto = Double.parseDouble(txtSueldoBruto.getText());
        int numeroHijos = Integer.parseInt(txtNumeroHijos.getText());
        double bonificacion = 0;

        if (numeroHijos > 1) {
            bonificacion = sueldoBruto * 0.125 + (numeroHijos * 40);
        } else {
            bonificacion = sueldoBruto * 0.10;
        }

        double sueldoNeto = sueldoBruto + bonificacion;
        
        txtBonificacion.setText(String.format("%.2f", bonificacion));
        txtSueldoNeto.setText(String.format("%.2f", sueldoNeto));
    }
}
