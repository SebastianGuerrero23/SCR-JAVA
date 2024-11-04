package repetitivas;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm02 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero1, txtNumero2;
    JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm02 frame = new frm02();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm02() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblNumero1 = new JLabel("Número 1:");
        lblNumero1.setBounds(50, 30, 80, 30);
        getContentPane().add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(150, 30, 100, 30);
        txtNumero1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Número 2:");
        lblNumero2.setBounds(50, 70, 80, 30);
        getContentPane().add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(150, 70, 100, 30);
        txtNumero2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero2);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(100, 110, 130, 30);
        getContentPane().add(btnMultiplicar);

        // Campo para mostrar el resultado
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 150, 80, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 150, 100, 30);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        btnMultiplicar.addActionListener(e -> btnMultiplicar_actionPerformed());
    }

    protected void btnMultiplicar_actionPerformed() {
        int numero1 = Integer.parseInt(txtNumero1.getText());
        int numero2 = Integer.parseInt(txtNumero2.getText());

        int resultado = 0;

        // Multiplicación 
        for (int i = 0; i < Math.abs(numero2); i++) {
            resultado += numero1;
        }

        if ((numero1 < 0 && numero2 > 0) || (numero1 > 0 && numero2 < 0)) {
            resultado = -resultado;
        }

        // Resultado
        txtResultado.setText(String.valueOf(resultado));
    }
}
