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

public class frm23 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNotaMatematicas, txtNotaFisica, txtPropina, txtReloj;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm23 frame = new frm23();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public frm23() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNotaMatematicas = new JLabel("Nota Matemáticas: ");
        lblNotaMatematicas.setBounds(50, 50, 150, 30);
        getContentPane().add(lblNotaMatematicas);

        JLabel lblNotaFisica = new JLabel("Nota Física: ");
        lblNotaFisica.setBounds(50, 90, 150, 30);
        getContentPane().add(lblNotaFisica);

        JLabel lblPropina = new JLabel("Propina: ");
        lblPropina.setBounds(50, 130, 150, 30);
        getContentPane().add(lblPropina);

        JLabel lblReloj = new JLabel("Reloj: ");
        lblReloj.setBounds(50, 170, 150, 30);
        getContentPane().add(lblReloj);

        txtNotaMatematicas = new JTextField();
        txtNotaMatematicas.setBounds(200, 50, 100, 30);
        txtNotaMatematicas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNotaMatematicas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNotaMatematicas);

        txtNotaFisica = new JTextField();
        txtNotaFisica.setBounds(200, 90, 100, 30);
        txtNotaFisica.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNotaFisica.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNotaFisica);

        txtPropina = new JTextField();
        txtPropina.setBounds(200, 130, 100, 30);
        txtPropina.setEditable(false);
        txtPropina.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPropina);

        txtReloj = new JTextField();
        txtReloj.setBounds(200, 170, 100, 30);
        txtReloj.setEditable(false);
        txtReloj.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtReloj);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 210, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPropina();
            }
        });
    }

    private void calcularPropina() {
        double notaMatematicas = Double.parseDouble(txtNotaMatematicas.getText());
        double notaFisica = Double.parseDouble(txtNotaFisica.getText());
        double propina = 0;

        // Calcular propina de Matemáticas
        if (notaMatematicas > 17) {
            propina += 3;
        } else {
            propina += notaMatematicas * 1;
        }

        // Calcular propina de Física
        if (notaFisica > 15) {
            propina += 2;
        } else {
            propina += notaFisica * 0.5;
        }

        // Calcular promedio y verificar regalo del reloj
        double promedio = (notaMatematicas + notaFisica) / 2;
        String reloj = promedio > 16 ? "Sí" : "No";

        // Mostrar resultados
        txtPropina.setText(String.format("%.2f", propina));
        txtReloj.setText(reloj);
    }
}
