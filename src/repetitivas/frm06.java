package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtInicio, txtFin;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm06 frame = new frm06();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm06() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número (n):");
        lblNumero.setBounds(50, 30, 100, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(150, 30, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JLabel lblInicio = new JLabel("Desde (x):");
        lblInicio.setBounds(50, 70, 100, 30);
        getContentPane().add(lblInicio);

        txtInicio = new JTextField();
        txtInicio.setBounds(150, 70, 100, 30);
        txtInicio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtInicio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtInicio);

        JLabel lblFin = new JLabel("Hasta (y):");
        lblFin.setBounds(50, 110, 100, 30);
        getContentPane().add(lblFin);

        txtFin = new JTextField();
        txtFin.setBounds(150, 110, 100, 30);
        txtFin.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFin.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtFin);

        JButton btnCalcular = new JButton("Generar Tabla");
        btnCalcular.setBounds(100, 150, 150, 30);
        getContentPane().add(btnCalcular);

        // Campo para mostrar el resultado
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 190, 100, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 190, 200, 70);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().add(txtResultado);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int n = Integer.parseInt(txtNumero.getText());
        int x = Integer.parseInt(txtInicio.getText());
        int y = Integer.parseInt(txtFin.getText());
        StringBuilder tabla = new StringBuilder();

        for (int i = x; i <= y; i++) {
            tabla.append(n).append(" x ").append(i).append(" = ").append(n * i).append("\n");
        }

        txtResultado.setText(tabla.toString());
    }
}
