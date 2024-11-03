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

public class frm08 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtExamenesAprobados, txtTotalPropina;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm08 frame = new frm08();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm08() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblExamenesAprobados = new JLabel("Exámenes Aprobados: ");
        lblExamenesAprobados.setBounds(50, 30, 150, 30);
        getContentPane().add(lblExamenesAprobados);

        txtExamenesAprobados = new JTextField();
        txtExamenesAprobados.setBounds(200, 30, 100, 30);
        txtExamenesAprobados.setHorizontalAlignment(SwingConstants.RIGHT);
        txtExamenesAprobados.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtExamenesAprobados);

        JLabel lblTotalPropina = new JLabel("Total de Propina: ");
        lblTotalPropina.setBounds(50, 70, 150, 30);
        getContentPane().add(lblTotalPropina);

        txtTotalPropina = new JTextField();
        txtTotalPropina.setBounds(200, 70, 100, 30);
        txtTotalPropina.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalPropina.setEditable(false);
        getContentPane().add(txtTotalPropina);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 110, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPropina();
            }
        });
    }

    private void calcularPropina() {
        int examenesAprobados = Integer.parseInt(txtExamenesAprobados.getText());
        double propinaBase = 20.0;
        double propinaAdicional = 5.0 * examenesAprobados;
        double totalPropina = propinaBase + propinaAdicional;

        txtTotalPropina.setText(String.format("%.2f", totalPropina));
    }
}
