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

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCodigo, txtUnidades, txtImporte, txtDescuento, txtTotal;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm09 frame = new frm09();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm09() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCodigo = new JLabel("Código: ");
        lblCodigo.setBounds(50, 30, 100, 30);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 30, 100, 30);
        txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCodigo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCodigo);

        JLabel lblUnidades = new JLabel("Unidades: ");
        lblUnidades.setBounds(50, 70, 100, 30);
        getContentPane().add(lblUnidades);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(150, 70, 100, 30);
        txtUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidades.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidades);

        JLabel lblImporte = new JLabel("Importe: ");
        lblImporte.setBounds(50, 110, 100, 30);
        getContentPane().add(lblImporte);

        txtImporte = new JTextField();
        txtImporte.setBounds(150, 110, 100, 30);
        txtImporte.setHorizontalAlignment(SwingConstants.RIGHT);
        txtImporte.setEditable(false);
        getContentPane().add(txtImporte);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(50, 150, 100, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 150, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotal = new JLabel("Total a Pagar: ");
        lblTotal.setBounds(50, 190, 100, 30);
        getContentPane().add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(150, 190, 100, 30);
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotal.setEditable(false);
        getContentPane().add(txtTotal);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 230, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        int unidades = Integer.parseInt(txtUnidades.getText());
        double precioUnitario = 0;

        switch (codigo) {
            case 101:
                precioUnitario = 17;
                break;
            case 102:
                precioUnitario = 25;
                break;
            case 103:
                precioUnitario = 16;
                break;
            case 104:
                precioUnitario = 27;
                break;
            default:
                txtImporte.setText("Código Inválido");
                return;
        }

        double importe = precioUnitario * unidades;
        double descuento = calcularDescuento(unidades, importe);
        double total = importe - descuento;

        txtImporte.setText(String.format("%.2f", importe));
        txtDescuento.setText(String.format("%.2f", descuento));
        txtTotal.setText(String.format("%.2f", total));
    }

    private double calcularDescuento(int unidades, double importe) {
        double porcentajeDescuento;

        if (unidades >= 1 && unidades <= 10) {
            porcentajeDescuento = 0.05;
        } else if (unidades >= 11 && unidades <= 20) {
            porcentajeDescuento = 0.08;
        } else if (unidades >= 21 && unidades <= 30) {
            porcentajeDescuento = 0.10;
        } else {
            porcentajeDescuento = 0.13;
        }

        return importe * porcentajeDescuento;
    }
}
