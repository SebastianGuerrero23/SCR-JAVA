package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm08 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtBase, txtExponente, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm08 frame = new frm08();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm08() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblBase = new JLabel("Base (n):");
        lblBase.setBounds(50, 30, 80, 30);
        getContentPane().add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(150, 30, 100, 30);
        txtBase.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBase.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtBase);

        JLabel lblExponente = new JLabel("Exponente (m):");
        lblExponente.setBounds(50, 70, 100, 30);
        getContentPane().add(lblExponente);

        txtExponente = new JTextField();
        txtExponente.setBounds(150, 70, 100, 30);
        txtExponente.setHorizontalAlignment(SwingConstants.RIGHT);
        txtExponente.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtExponente);

        JButton btnCalcular = new JButton("Calcular Potencia");
        btnCalcular.setBounds(50, 110, 200, 30);
        getContentPane().add(btnCalcular);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 150, 80, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 150, 100, 30);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        int base = Integer.parseInt(txtBase.getText());
        int exponente = Integer.parseInt(txtExponente.getText());
        long resultado = 1;

        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }

        txtResultado.setText(String.valueOf(resultado));
    }
}
