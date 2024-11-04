package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm14 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField[] txtNumeros;
    JTextField txtPromedio;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm14 frame = new frm14();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm14() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblNumeros = new JLabel("Ingrese 5 números:");
        lblNumeros.setBounds(50, 20, 200, 30);
        getContentPane().add(lblNumeros);

        txtNumeros = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            txtNumeros[i] = new JTextField();
            txtNumeros[i].setBounds(50, 60 + i * 30, 100, 30);
            txtNumeros[i].setHorizontalAlignment(SwingConstants.RIGHT);
            txtNumeros[i].setMargin(new Insets(5, 5, 5, 5));
            getContentPane().add(txtNumeros[i]);
        }

        JLabel lblPromedio = new JLabel("Promedio de 3 mayores:");
        lblPromedio.setBounds(50, 210, 150, 30);
        getContentPane().add(lblPromedio);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(200, 210, 100, 30);
        txtPromedio.setFocusable(false);
        txtPromedio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPromedio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPromedio);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 250, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double[] numeros = new double[5];

        for (int i = 0; i < 5; i++) {
            numeros[i] = Double.parseDouble(txtNumeros[i].getText());
        }

        
        java.util.Arrays.sort(numeros);

 
        double promedio = (numeros[2] + numeros[3] + numeros[4]) / 3;

        txtPromedio.setText(String.format("%.2f", promedio));
    }
}
