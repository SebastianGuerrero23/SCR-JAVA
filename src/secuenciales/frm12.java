package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm12 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtA, txtB, txtC, txtResultado1, txtResultado2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm12 frame = new frm12();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null);

        JLabel lblA = new JLabel("Coeficiente a:");
        lblA.setBounds(50, 30, 100, 30);
        getContentPane().add(lblA);

        JLabel lblB = new JLabel("Coeficiente b:");
        lblB.setBounds(50, 70, 100, 30);
        getContentPane().add(lblB);

        JLabel lblC = new JLabel("Coeficiente c:");
        lblC.setBounds(50, 110, 100, 30);
        getContentPane().add(lblC);

        JLabel lblResultado1 = new JLabel("Raíz 1:");
        lblResultado1.setBounds(50, 150, 100, 30);
        getContentPane().add(lblResultado1);

        JLabel lblResultado2 = new JLabel("Raíz 2:");
        lblResultado2.setBounds(50, 190, 100, 30);
        getContentPane().add(lblResultado2);

        txtA = new JTextField();
        txtA.setBounds(160, 30, 60, 30);
        txtA.setHorizontalAlignment(SwingConstants.RIGHT);
        txtA.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtA);

        txtB = new JTextField();
        txtB.setBounds(160, 70, 60, 30);
        txtB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtB);

        txtC = new JTextField();
        txtC.setBounds(160, 110, 60, 30);
        txtC.setHorizontalAlignment(SwingConstants.RIGHT);
        txtC.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtC);

        txtResultado1 = new JTextField();
        txtResultado1.setBounds(160, 150, 60, 30);
        txtResultado1.setFocusable(false);
        txtResultado1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtResultado1);

        txtResultado2 = new JTextField();
        txtResultado2.setBounds(160, 190, 60, 30);
        txtResultado2.setFocusable(false);
        txtResultado2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtResultado2);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 230, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double a = Double.parseDouble(txtA.getText());
        double b = Double.parseDouble(txtB.getText());
        double c = Double.parseDouble(txtC.getText());

        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            txtResultado1.setText(String.format("%.2f", raiz1));
            txtResultado2.setText(String.format("%.2f", raiz2));
        } else if (discriminante == 0) {
            double raiz = -b / (2 * a);
            txtResultado1.setText(String.format("%.2f", raiz));
            txtResultado2.setText("Raíz única");
        } else {
            txtResultado1.setText("Sin raíces reales");
            txtResultado2.setText("");
        }
    }
}
