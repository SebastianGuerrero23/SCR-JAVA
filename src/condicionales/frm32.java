package condicionales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm32 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtPromedioPonderado, txtPensionActual, txtDescuento, txtNuevaPension;
    private JComboBox<String> cmbCategoria;

    public frm32() {
        setTitle("Cálculo de Pensión Universitaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 300);
        setLayout(null);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(10, 20, 80, 25);
        add(lblCategoria);

        cmbCategoria = new JComboBox<>(new String[] {"A", "B", "C", "D"});
        cmbCategoria.setBounds(100, 20, 100, 25);
        add(cmbCategoria);

        JLabel lblPromedio = new JLabel("Promedio Ponderado:");
        lblPromedio.setBounds(10, 60, 150, 25);
        add(lblPromedio);

        txtPromedioPonderado = new JTextField();
        txtPromedioPonderado.setBounds(150, 60, 50, 25);
        add(txtPromedioPonderado);

        JLabel lblPensionActual = new JLabel("Pensión Actual:");
        lblPensionActual.setBounds(10, 100, 100, 25);
        add(lblPensionActual);

        txtPensionActual = new JTextField();
        txtPensionActual.setBounds(150, 100, 100, 25);
        txtPensionActual.setEditable(false);
        add(txtPensionActual);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(10, 140, 100, 25);
        add(lblDescuento);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 140, 100, 25);
        txtDescuento.setEditable(false);
        add(txtDescuento);

        JLabel lblNuevaPension = new JLabel("Nueva Pensión:");
        lblNuevaPension.setBounds(10, 180, 100, 25);
        add(lblNuevaPension);

        txtNuevaPension = new JTextField();
        txtNuevaPension.setBounds(150, 180, 100, 25);
        txtNuevaPension.setEditable(false);
        add(txtNuevaPension);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 220, 100, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPension();
            }
        });
        add(btnCalcular);
    }

    private void calcularPension() {
        double pensionActual = 0.0;
        String categoria = (String) cmbCategoria.getSelectedItem();
        
        switch (categoria) {
            case "A":
                pensionActual = 550.0;
                break;
            case "B":
                pensionActual = 500.0;
                break;
            case "C":
                pensionActual = 450.0;
                break;
            case "D":
                pensionActual = 400.0;
                break;
        }

        txtPensionActual.setText(String.valueOf(pensionActual));

        double promedio = Double.parseDouble(txtPromedioPonderado.getText());
        double descuento = 0.0;

        if (promedio >= 14 && promedio < 16) {
            descuento = 0.10 * pensionActual;
        } else if (promedio >= 16 && promedio < 18) {
            descuento = 0.12 * pensionActual;
        } else if (promedio >= 18) {
            descuento = 0.15 * pensionActual;
        }

        txtDescuento.setText(String.valueOf(descuento));
        double nuevaPension = pensionActual - descuento;
        txtNuevaPension.setText(String.valueOf(nuevaPension));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm32 frame = new frm32();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
