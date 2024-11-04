package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm18 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCantidad, txtPrecioUnitario;
    JTextField txtImporteCompra, txtDescuento, txtImporteAPagar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm18 frame = new frm18();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm18() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblCantidad = new JLabel("Cantidad de unidades:");
        lblCantidad.setBounds(50, 30, 150, 30);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(220, 30, 100, 30);
        txtCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCantidad.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCantidad);

        JLabel lblPrecioUnitario = new JLabel("Precio unitario (USD):");
        lblPrecioUnitario.setBounds(50, 70, 150, 30);
        getContentPane().add(lblPrecioUnitario);

        txtPrecioUnitario = new JTextField();
        txtPrecioUnitario.setBounds(220, 70, 100, 30);
        txtPrecioUnitario.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPrecioUnitario.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPrecioUnitario);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 110, 100, 30);
        getContentPane().add(btnCalcular);

        // EResultados
        JLabel lblImporteCompra = new JLabel("Importe de la compra:");
        lblImporteCompra.setBounds(50, 150, 150, 30);
        getContentPane().add(lblImporteCompra);

        txtImporteCompra = new JTextField();
        txtImporteCompra.setBounds(220, 150, 100, 30);
        txtImporteCompra.setFocusable(false);
        txtImporteCompra.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtImporteCompra);

        JLabel lblDescuento = new JLabel("Total descuento:");
        lblDescuento.setBounds(50, 190, 150, 30);
        getContentPane().add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(220, 190, 100, 30);
        txtDescuento.setFocusable(false);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDescuento);

        JLabel lblImporteAPagar = new JLabel("Importe a pagar:");
        lblImporteAPagar.setBounds(50, 230, 150, 30);
        getContentPane().add(lblImporteAPagar);

        txtImporteAPagar = new JTextField();
        txtImporteAPagar.setBounds(220, 230, 100, 30);
        txtImporteAPagar.setFocusable(false);
        txtImporteAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtImporteAPagar);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double precioUnitario = Double.parseDouble(txtPrecioUnitario.getText());

        // Calcular 
        double importeCompra = cantidad * precioUnitario;

        double primerDescuento = importeCompra * 0.15;

        double importeConPrimerDescuento = importeCompra - primerDescuento;

        double segundoDescuento = importeConPrimerDescuento * 0.15;

        double totalDescuento = primerDescuento + segundoDescuento;

        double importeAPagar = importeCompra - totalDescuento;

        // Resultados
        txtImporteCompra.setText(String.format("USD %.2f", importeCompra));
        txtDescuento.setText(String.format("USD %.2f", totalDescuento));
        txtImporteAPagar.setText(String.format("USD %.2f", importeAPagar));
    }
}
