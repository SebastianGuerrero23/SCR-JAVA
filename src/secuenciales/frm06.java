package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm06 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtRadio, txtAltura, txtArea, txtVolumen;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm06 frame = new frm06();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm06() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); // centrar formulario en la mitad de la pantalla

        JLabel lblRadio = new JLabel("Radio (r): ");
        lblRadio.setBounds(50, 50, 80, 30);
        getContentPane().add(lblRadio);

        JLabel lblAltura = new JLabel("Altura (h): ");
        lblAltura.setBounds(50, 90, 80, 30);
        getContentPane().add(lblAltura);

        JLabel lblArea = new JLabel("Área: ");
        lblArea.setBounds(50, 130, 80, 30);
        getContentPane().add(lblArea);

        JLabel lblVolumen = new JLabel("Volumen: ");
        lblVolumen.setBounds(50, 170, 80, 30);
        getContentPane().add(lblVolumen);

        txtRadio = new JTextField();
        txtRadio.setBounds(130, 50, 60, 30);
        txtRadio.setHorizontalAlignment(SwingConstants.RIGHT);
        txtRadio.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtRadio);

        txtAltura = new JTextField();
        txtAltura.setBounds(130, 90, 60, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAltura.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAltura);

        txtArea = new JTextField();
        txtArea.setBounds(130, 130, 60, 30);
        txtArea.setFocusable(false);
        txtArea.setHorizontalAlignment(SwingConstants.RIGHT);
        txtArea.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtArea);

        txtVolumen = new JTextField();
        txtVolumen.setBounds(130, 170, 60, 30);
        txtVolumen.setFocusable(false);
        txtVolumen.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVolumen.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVolumen);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 210, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double radio = Double.parseDouble(txtRadio.getText());
        double altura = Double.parseDouble(txtAltura.getText());

        // Cálculo del área total y volumen del cilindro
        double pi = Math.PI;
        double area = 2 * pi * radio * (radio + altura);
        double volumen = pi * Math.pow(radio, 2) * altura;

        // Mostrar resultados
        txtArea.setText(String.format("%.2f", area));
        txtVolumen.setText(String.format("%.2f", volumen));
    }
}
