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

public class frm22 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCantidadA, txtCantidadB, txtImporteBruto, txtDescuento, txtTotalPagar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm22 frame = new frm22();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm22() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCantidadA = new JLabel("Cantidad Producto A: ");
        lblCantidadA.setBounds(50, 30, 150, 30);
        getContentPane().add(lblCantidadA);

        txtCantidadA = new JTextField();
        txtCantidadA.setBounds(200, 30, 100, 30);
        txtCantidadA.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCantidadA.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCantidadA);

        JLabel lblCantidadB = new JLabel("Cantidad Producto B: ");
        lblCantidadB.setBounds(50, 70, 150, 30);
        getContentPane().add(lblCantidadB);

        txtCantidadB = new JTextField();
        txtCantidadB.setBounds(200, 70, 100, 30);
        txtCantidadB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCantidadB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCantidadB);

        JLabel lblImporteBruto = new JLabel("Importe Bruto: ");
        lblImporteBruto.setBounds(50, 110, 150, 30);
        getContentPane().add(lblImporteBruto);

        txtImporteBruto = new JTextField();
        txtImporteBruto.setBounds(200, 110, 100, 30);
        txtImporteBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtImporteBruto.setEditable(false);
        getContentPane().add(txtImporteBruto);

        JLabel lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(50, 150, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(200, 150, 100, 30);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento);

        JLabel lblTotalPagar = new JLabel("Total a Pagar: ");
        lblTotalPagar.setBounds(50, 190, 150, 30);
        getContentPane().add(lblTotalPagar);

        txtTotalPagar = new JTextField();
        txtTotalPagar.setBounds(200, 190, 100, 30);
        txtTotalPagar.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalPagar.setEditable(false);
        getContentPane().add(txtTotalPagar);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 230, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {

        double precioA = 25.0;
        double precioB = 30.0;
        double descuentoA = 0.15;
        double descuentoB = 0.10;

        int cantidadA = Integer.parseInt(txtCantidadA.getText());
        int cantidadB = Integer.parseInt(txtCantidadB.getText());

        double importeBrutoA = cantidadA * precioA;
        double importeBrutoB = cantidadB * precioB;
        double importeBruto = importeBrutoA + importeBrutoB;

        double descuento = 0.0;
        
        if (cantidadA > 50) {
            descuento += importeBrutoA * descuentoA;
        }
        if (cantidadB > 60) {
            descuento += importeBrutoB * descuentoB;
        }

        double totalPagar = importeBruto - descuento;

        txtImporteBruto.setText(String.format("%.2f", importeBruto));
        txtDescuento.setText(String.format("%.2f", descuento));
        txtTotalPagar.setText(String.format("%.2f", totalPagar));
    }
}
