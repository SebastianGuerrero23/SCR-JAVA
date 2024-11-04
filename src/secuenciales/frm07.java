package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm07 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtBase, txtAltura, txtArea, txtPerimetro;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm07 frame = new frm07();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm07() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblBase = new JLabel("Base (b): ");
        lblBase.setBounds(50, 50, 80, 30);
        getContentPane().add(lblBase);

        JLabel lblAltura = new JLabel("Altura (h): ");
        lblAltura.setBounds(50, 90, 80, 30);
        getContentPane().add(lblAltura);

        JLabel lblArea = new JLabel("Área: ");
        lblArea.setBounds(50, 130, 80, 30);
        getContentPane().add(lblArea);

        JLabel lblPerimetro = new JLabel("Perímetro: ");
        lblPerimetro.setBounds(50, 170, 80, 30);
        getContentPane().add(lblPerimetro);

        txtBase = new JTextField();
        txtBase.setBounds(130, 50, 60, 30);
        txtBase.setHorizontalAlignment(SwingConstants.RIGHT);
        txtBase.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtBase);

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

        txtPerimetro = new JTextField();
        txtPerimetro.setBounds(130, 170, 60, 30);
        txtPerimetro.setFocusable(false);
        txtPerimetro.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPerimetro.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPerimetro);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 210, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double base = Double.parseDouble(txtBase.getText());
        double altura = Double.parseDouble(txtAltura.getText());

     
        double area = base * altura;
        double perimetro = 2 * (base + altura);

        // Resultados
        txtArea.setText(String.format("%.2f", area));
        txtPerimetro.setText(String.format("%.2f", perimetro));
    }
}
