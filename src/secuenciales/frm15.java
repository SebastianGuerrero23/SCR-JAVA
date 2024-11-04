package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtJuan, txtRosa, txtDaniel;
    JTextField txtTotalDolares, txtPorcentajeJuan, txtPorcentajeRosa, txtPorcentajeDaniel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm15 frame = new frm15();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm15() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 350);
        setLayout(null);  // Activación
        setLocationRelativeTo(null);

        JLabel lblJuan = new JLabel("Aporte de Juan (USD):");
        lblJuan.setBounds(50, 30, 150, 30);
        getContentPane().add(lblJuan);

        JLabel lblRosa = new JLabel("Aporte de Rosa (USD):");
        lblRosa.setBounds(50, 70, 150, 30);
        getContentPane().add(lblRosa);

        JLabel lblDaniel = new JLabel("Aporte de Daniel (S/.):");
        lblDaniel.setBounds(50, 110, 150, 30);
        getContentPane().add(lblDaniel);

        txtJuan = new JTextField();
        txtJuan.setBounds(220, 30, 100, 30);
        txtJuan.setHorizontalAlignment(SwingConstants.RIGHT);
        txtJuan.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtJuan);

        txtRosa = new JTextField();
        txtRosa.setBounds(220, 70, 100, 30);
        txtRosa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtRosa.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtRosa);

        txtDaniel = new JTextField();
        txtDaniel.setBounds(220, 110, 100, 30);
        txtDaniel.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDaniel.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDaniel);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 150, 100, 30);
        getContentPane().add(btnCalcular);

        txtTotalDolares = new JTextField();
        txtTotalDolares.setBounds(50, 200, 270, 30);
        txtTotalDolares.setFocusable(false);
        txtTotalDolares.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTotalDolares.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTotalDolares);

        txtPorcentajeJuan = new JTextField();
        txtPorcentajeJuan.setBounds(50, 240, 100, 30);
        txtPorcentajeJuan.setFocusable(false);
        txtPorcentajeJuan.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPorcentajeJuan.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPorcentajeJuan);

        txtPorcentajeRosa = new JTextField();
        txtPorcentajeRosa.setBounds(150, 240, 100, 30);
        txtPorcentajeRosa.setFocusable(false);
        txtPorcentajeRosa.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPorcentajeRosa.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPorcentajeRosa);

        txtPorcentajeDaniel = new JTextField();
        txtPorcentajeDaniel.setBounds(250, 240, 100, 30);
        txtPorcentajeDaniel.setFocusable(false);
        txtPorcentajeDaniel.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPorcentajeDaniel.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPorcentajeDaniel);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double aporteJuan = Double.parseDouble(txtJuan.getText());
        double aporteRosa = Double.parseDouble(txtRosa.getText());
        double aporteDaniel = Double.parseDouble(txtDaniel.getText());

        // Convertir el aporte de Daniel de soles a dólares
        double aporteDanielDolares = aporteDaniel / 3.00;

        // Calcular el capital total en dólares
        double capitalTotalDolares = aporteJuan + aporteRosa + aporteDanielDolares;

        
        double porcentajeJuan = (aporteJuan / capitalTotalDolares) * 100;
        double porcentajeRosa = (aporteRosa / capitalTotalDolares) * 100;
        double porcentajeDaniel = (aporteDanielDolares / capitalTotalDolares) * 100;

        // Resultados
        txtTotalDolares.setText(String.format("Total en USD: S/ %.2f", capitalTotalDolares));
        txtPorcentajeJuan.setText(String.format("%% Juan: %.2f", porcentajeJuan));
        txtPorcentajeRosa.setText(String.format("%% Rosa: %.2f", porcentajeRosa));
        txtPorcentajeDaniel.setText(String.format("%% Daniel: %.2f", porcentajeDaniel));
    }
}

