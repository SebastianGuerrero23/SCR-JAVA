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

public class frm16 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtIngresoMensual, txtCostoCasa, txtCuotaInicial, txtCuotaMensual;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm16 frame = new frm16();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm16() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblIngresoMensual = new JLabel("Ingreso Mensual: ");
        lblIngresoMensual.setBounds(50, 30, 150, 30);
        getContentPane().add(lblIngresoMensual);

        txtIngresoMensual = new JTextField();
        txtIngresoMensual.setBounds(200, 30, 150, 30);
        txtIngresoMensual.setHorizontalAlignment(SwingConstants.RIGHT);
        txtIngresoMensual.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtIngresoMensual);

        JLabel lblCostoCasa = new JLabel("Costo de la Casa: ");
        lblCostoCasa.setBounds(50, 70, 150, 30);
        getContentPane().add(lblCostoCasa);

        txtCostoCasa = new JTextField();
        txtCostoCasa.setBounds(200, 70, 150, 30);
        txtCostoCasa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCostoCasa.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCostoCasa);

        JLabel lblCuotaInicial = new JLabel("Cuota Inicial: ");
        lblCuotaInicial.setBounds(50, 110, 150, 30);
        getContentPane().add(lblCuotaInicial);

        txtCuotaInicial = new JTextField();
        txtCuotaInicial.setBounds(200, 110, 150, 30);
        txtCuotaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuotaInicial.setEditable(false);
        getContentPane().add(txtCuotaInicial);

        JLabel lblCuotaMensual = new JLabel("Cuota Mensual: ");
        lblCuotaMensual.setBounds(50, 150, 150, 30);
        getContentPane().add(lblCuotaMensual);

        txtCuotaMensual = new JTextField();
        txtCuotaMensual.setBounds(200, 150, 150, 30);
        txtCuotaMensual.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuotaMensual.setEditable(false);
        getContentPane().add(txtCuotaMensual);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 200, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularCuotas();
            }
        });
    }

    private void calcularCuotas() {
        double ingresoMensual = Double.parseDouble(txtIngresoMensual.getText());
        double costoCasa = Double.parseDouble(txtCostoCasa.getText());
        double cuotaInicial;
        double cuotaMensual;

        if (ingresoMensual < 1250) {
            cuotaInicial = 0.15 * costoCasa;
            cuotaMensual = (costoCasa - cuotaInicial) / 120;
        } else {
            cuotaInicial = 0.30 * costoCasa;
            cuotaMensual = (costoCasa - cuotaInicial) / 75;
        }

        txtCuotaInicial.setText(String.format("%.2f", cuotaInicial));
        txtCuotaMensual.setText(String.format("%.2f", cuotaMensual));
    }
}
