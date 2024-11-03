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

public class frm20 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtA, txtB, txtC, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm20 frame = new frm20();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm20() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblA = new JLabel("Número A: ");
        lblA.setBounds(50, 30, 100, 30);
        getContentPane().add(lblA);

        txtA = new JTextField();
        txtA.setBounds(150, 30, 100, 30);
        txtA.setHorizontalAlignment(SwingConstants.RIGHT);
        txtA.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtA);

        JLabel lblB = new JLabel("Número B: ");
        lblB.setBounds(50, 70, 100, 30);
        getContentPane().add(lblB);

        txtB = new JTextField();
        txtB.setBounds(150, 70, 100, 30);
        txtB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtB);

        JLabel lblC = new JLabel("Número C: ");
        lblC.setBounds(50, 110, 100, 30);
        getContentPane().add(lblC);

        txtC = new JTextField();
        txtC.setBounds(150, 110, 100, 30);
        txtC.setHorizontalAlignment(SwingConstants.RIGHT);
        txtC.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtC);

        JLabel lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 150, 100, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 150, 100, 30);
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 190, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarOrden();
            }
        });
    }

    private void verificarOrden() {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());
        int c = Integer.parseInt(txtC.getText());
        String resultado;

        if (a < b && b < c) {
            resultado = "Orden Ascendente";
        } else if (a > b && b > c) {
            resultado = "Orden Descendente";
        } else {
            resultado = "Desordenado";
        }

        txtResultado.setText(resultado);
    }
}
