package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm02 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtUnidades, txtCompra, txtDescuento, txtTotal, txtCaramelos;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm02 frame = new frm02();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm02() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUnidades = new JLabel("Unidades:");
        lblUnidades.setBounds(50, 30, 80, 30);
        getContentPane().add(lblUnidades);

        JLabel lblCompra = new JLabel("Compra:");
        lblCompra.setBounds(50, 70, 80, 30);
        getContentPane().add(lblCompra);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 110, 80, 30);
        getContentPane().add(lblDescuento);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(50, 150, 80, 30);
        getContentPane().add(lblTotal);

        JLabel lblCaramelos = new JLabel("Caramelos:");
        lblCaramelos.setBounds(50, 190, 80, 30);
        getContentPane().add(lblCaramelos);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(130, 30, 60, 30);
        txtUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
        txtUnidades.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtUnidades);

        txtCompra = new JTextField();
        txtCompra.setBounds(130, 70, 60, 30);
        txtCompra.setFocusable(false);
        txtCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCompra.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCompra);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(130, 110, 60, 30);
        txtDescuento.setFocusable(false);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDescuento);

        txtTotal = new JTextField();
        txtTotal.setBounds(130, 150, 60, 30);
        txtTotal.setFocusable(false);
        txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotal.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTotal);

        txtCaramelos = new JTextField();
        txtCaramelos.setBounds(130, 190, 60, 30);
        txtCaramelos.setFocusable(false);
        txtCaramelos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCaramelos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCaramelos);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 230, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    protected void calcular() {
        int unidades = Integer.parseInt(txtUnidades.getText());
        int precioUnitario = 20;
        double compra = unidades * precioUnitario;
        double descuento = 0;
        int caramelos = 0;
 
        if (compra > 700) {
            descuento = compra * 0.16;
        } else if (compra >= 501 && compra <= 700) {
            descuento = compra * 0.14;
        } else if (compra <= 500) {
            descuento = compra * 0.12;
        }

        if (unidades >= 1 && unidades <= 50) {
            caramelos = 6;
        } else if (unidades >= 51 && unidades <= 100) {
            caramelos = 10;
        } else if (unidades > 100) {
            caramelos = 15;
        }

        double total = compra - descuento;

        txtCompra.setText(String.format("S/ %.2f", compra));
        txtDescuento.setText(String.format("S/ %.2f", descuento));
        txtTotal.setText(String.format("S/ %.2f", total));
        txtCaramelos.setText(String.valueOf(caramelos));
    }
}
