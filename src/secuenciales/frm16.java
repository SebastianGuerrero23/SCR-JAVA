package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm16 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtHorasTrabajadas, txtTarifaHoraria;
    JTextField txtSueldoBasico, txtSueldoBruto, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm16 frame = new frm16();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm16() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblHorasTrabajadas = new JLabel("Horas trabajadas:");
        lblHorasTrabajadas.setBounds(50, 30, 150, 30);
        getContentPane().add(lblHorasTrabajadas);

        JLabel lblTarifaHoraria = new JLabel("Tarifa horaria (USD):");
        lblTarifaHoraria.setBounds(50, 70, 150, 30);
        getContentPane().add(lblTarifaHoraria);

        txtHorasTrabajadas = new JTextField();
        txtHorasTrabajadas.setBounds(220, 30, 100, 30);
        txtHorasTrabajadas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtHorasTrabajadas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtHorasTrabajadas);

        txtTarifaHoraria = new JTextField();
        txtTarifaHoraria.setBounds(220, 70, 100, 30);
        txtTarifaHoraria.setHorizontalAlignment(SwingConstants.RIGHT);
        txtTarifaHoraria.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtTarifaHoraria);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 110, 100, 30);
        getContentPane().add(btnCalcular);

        txtSueldoBasico = new JTextField();
        txtSueldoBasico.setBounds(50, 160, 270, 30);
        txtSueldoBasico.setFocusable(false);
        txtSueldoBasico.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBasico.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoBasico);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(50, 200, 270, 30);
        txtSueldoBruto.setFocusable(false);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoBruto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoBruto);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(50, 240, 270, 30);
        txtSueldoNeto.setFocusable(false);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSueldoNeto.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSueldoNeto);

        btnCalcular.addActionListener(e -> btnCalcular_actionPerformed());
    }

    protected void btnCalcular_actionPerformed() {
        double horasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
        double tarifaHoraria = Double.parseDouble(txtTarifaHoraria.getText());

        // Calcular el sueldo básico
        double sueldoBasico = horasTrabajadas * tarifaHoraria;

        
        double sueldoBruto = sueldoBasico * 1.2;

    
        double sueldoNeto = sueldoBruto * 0.9;

        // Resultados
        txtSueldoBasico.setText(String.format("Sueldo Básico: USD %.2f", sueldoBasico));
        txtSueldoBruto.setText(String.format("Sueldo Bruto: USD %.2f", sueldoBruto));
        txtSueldoNeto.setText(String.format("Sueldo Neto: USD %.2f", sueldoNeto));
    }
}
