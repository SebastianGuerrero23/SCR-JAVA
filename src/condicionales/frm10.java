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

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNota1, txtNota2, txtNota3, txtNota4, txtNota5, txtPromedio, txtEliminadas;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm10 frame = new frm10();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNota1 = new JLabel("Nota 1: ");
        lblNota1.setBounds(50, 30, 100, 30);
        getContentPane().add(lblNota1);

        JLabel lblNota2 = new JLabel("Nota 2: ");
        lblNota2.setBounds(50, 70, 100, 30);
        getContentPane().add(lblNota2);

        JLabel lblNota3 = new JLabel("Nota 3: ");
        lblNota3.setBounds(50, 110, 100, 30);
        getContentPane().add(lblNota3);

        JLabel lblNota4 = new JLabel("Nota 4: ");
        lblNota4.setBounds(50, 150, 100, 30);
        getContentPane().add(lblNota4);

        JLabel lblNota5 = new JLabel("Nota 5: ");
        lblNota5.setBounds(50, 190, 100, 30);
        getContentPane().add(lblNota5);

        JLabel lblPromedio = new JLabel("Promedio: ");
        lblPromedio.setBounds(50, 230, 100, 30);
        getContentPane().add(lblPromedio);

        JLabel lblEliminadas = new JLabel("Notas Eliminadas: ");
        lblEliminadas.setBounds(50, 270, 150, 30);
        getContentPane().add(lblEliminadas);

        txtNota1 = new JTextField();
        txtNota1.setBounds(150, 30, 100, 30);
        txtNota1.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNota1.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNota1);

        txtNota2 = new JTextField();
        txtNota2.setBounds(150, 70, 100, 30);
        txtNota2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNota2.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNota2);

        txtNota3 = new JTextField();
        txtNota3.setBounds(150, 110, 100, 30);
        txtNota3.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNota3.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNota3);

        txtNota4 = new JTextField();
        txtNota4.setBounds(150, 150, 100, 30);
        txtNota4.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNota4.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNota4);

        txtNota5 = new JTextField();
        txtNota5.setBounds(150, 190, 100, 30);
        txtNota5.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNota5.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNota5);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(150, 230, 100, 30);
        txtPromedio.setEditable(false);
        txtPromedio.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPromedio);

        txtEliminadas = new JTextField();
        txtEliminadas.setBounds(150, 270, 100, 30);
        txtEliminadas.setEditable(false);
        txtEliminadas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtEliminadas);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(270, 150, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPromedio();
            }
        });
    }

    private void calcularPromedio() {
        double nota1 = Double.parseDouble(txtNota1.getText());
        double nota2 = Double.parseDouble(txtNota2.getText());
        double nota3 = Double.parseDouble(txtNota3.getText());
        double nota4 = Double.parseDouble(txtNota4.getText());
        double nota5 = Double.parseDouble(txtNota5.getText());

        double maxNota = Math.max(Math.max(nota1, nota2), Math.max(nota3, Math.max(nota4, nota5)));
        double minNota = Math.min(Math.min(nota1, nota2), Math.min(nota3, Math.min(nota4, nota5)));

        double sumaNotas = nota1 + nota2 + nota3 + nota4 + nota5 - maxNota - minNota;
        double promedio = sumaNotas / 3; // se divide entre 3 porque se eliminaron 2 notas

        txtPromedio.setText(String.format("%.2f", promedio));
        txtEliminadas.setText(String.format("%.2f, %.2f", maxNota, minNota));
    }
}
