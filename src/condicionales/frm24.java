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

public class frm24 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtVentas, txtSueldo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm24 frame = new frm24();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm24() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblVentas = new JLabel("Monto Total Vendido: ");
        lblVentas.setBounds(30, 50, 150, 30);
        getContentPane().add(lblVentas);

        JLabel lblSueldo = new JLabel("Sueldo: ");
        lblSueldo.setBounds(30, 120, 150, 30);
        getContentPane().add(lblSueldo);

        txtVentas = new JTextField();
        txtVentas.setBounds(180, 50, 100, 30);
        txtVentas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVentas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVentas);

        txtSueldo = new JTextField();
        txtSueldo.setBounds(180, 120, 100, 30);
        txtSueldo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldo.setEditable(false);
        getContentPane().add(txtSueldo);

        JButton btnCalcular = new JButton("Calcular Sueldo");
        btnCalcular.setBounds(100, 80, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    private void calcularSueldo() {
        double montoVendido = Double.parseDouble(txtVentas.getText());
        double sueldo = montoVendido * 0.10;

        if (montoVendido > 5000) {
            double exceso = montoVendido - 5000;
            sueldo += (exceso / 500) * 25;
        }

        txtSueldo.setText(String.format("%.2f", sueldo));
    }
}
