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

public class frm03 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtAngulo, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm03 frame = new frm03();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm03() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblAngulo = new JLabel("Ángulo (en grados): ");
        lblAngulo.setBounds(50, 50, 150, 30);
        getContentPane().add(lblAngulo);

        txtAngulo = new JTextField();
        txtAngulo.setBounds(200, 50, 100, 30);
        txtAngulo.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAngulo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAngulo);

        JLabel lblResultado = new JLabel("Clasificación: ");
        lblResultado.setBounds(50, 100, 150, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(200, 100, 100, 30);
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        JButton btnClasificar = new JButton("Clasificar");
        btnClasificar.setBounds(120, 150, 100, 30);
        getContentPane().add(btnClasificar);

        btnClasificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clasificarAngulo();
            }
        });
    }

    private void clasificarAngulo() {
        double angulo = Double.parseDouble(txtAngulo.getText());
        String resultado;

        if (angulo == 0) {
            resultado = "Nulo";
        } else if (angulo > 0 && angulo < 90) {
            resultado = "Agudo";
        } else if (angulo == 90) {
            resultado = "Recto";
        } else if (angulo > 90 && angulo < 180) {
            resultado = "Obtuso";
        } else if (angulo == 180) {
            resultado = "Llano";
        } else if (angulo > 180 && angulo < 360) {
            resultado = "Cóncavo";
        } else if (angulo == 360) {
            resultado = "Completo";
        } else {
            resultado = "Ángulo inválido";
        }

        txtResultado.setText(resultado);
    }
}
