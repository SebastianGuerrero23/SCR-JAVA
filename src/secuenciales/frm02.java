package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm02 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMetros, txtCentimetros, txtPulgadas, txtPies, txtYardas;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm02 frame = new frm02();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm02() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 350); // Aumentado el tamaño para incluir más espacio
        setLayout(null);  // Activacion 
        setLocationRelativeTo(null); // centrar formulario en la mitad de la pantalla

        JLabel lblMetros = new JLabel("Metros: ");
        lblMetros.setBounds(50, 50, 80, 30);
        getContentPane().add(lblMetros);

        txtMetros = new JTextField();
        txtMetros.setBounds(130, 50, 60, 30);
        txtMetros.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMetros.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMetros);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(100, 100, 100, 30);
        getContentPane().add(btnConvertir);
        
        JLabel lblCentimetros = new JLabel("Centímetros: ");
        lblCentimetros.setBounds(50, 150, 100, 30);
        getContentPane().add(lblCentimetros);
        
        txtCentimetros = new JTextField();
        txtCentimetros.setBounds(150, 150, 60, 30);
        txtCentimetros.setFocusable(false);
        txtCentimetros.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCentimetros);
        
        JLabel lblPulgadas = new JLabel("Pulgadas: ");
        lblPulgadas.setBounds(50, 190, 100, 30);
        getContentPane().add(lblPulgadas);
        
        txtPulgadas = new JTextField();
        txtPulgadas.setBounds(150, 190, 60, 30);
        txtPulgadas.setFocusable(false);
        txtPulgadas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPulgadas);
        
        JLabel lblPies = new JLabel("Pies: ");
        lblPies.setBounds(50, 230, 100, 30);
        getContentPane().add(lblPies);
        
        txtPies = new JTextField();
        txtPies.setBounds(150, 230, 60, 30);
        txtPies.setFocusable(false);
        txtPies.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPies);
        
        JLabel lblYardas = new JLabel("Yardas: ");
        lblYardas.setBounds(50, 270, 100, 30);
        getContentPane().add(lblYardas);
        
        txtYardas = new JTextField();
        txtYardas.setBounds(150, 270, 60, 30);
        txtYardas.setFocusable(false);
        txtYardas.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtYardas);
        
        btnConvertir.addActionListener(e -> convertir());
    }

    private void convertir() {
        double metros = Double.parseDouble(txtMetros.getText());
        double centimetros = metros * 100;
        double pulgadas = metros * 39.3701; // 1 metro = 39.3701 pulgadas
        double pies = metros * 3.28084; // 1 metro = 3.28084 pies
        double yardas = metros * 1.09361; // 1 metro = 1.09361 yardas

        txtCentimetros.setText(String.format("%.2f", centimetros));
        txtPulgadas.setText(String.format("%.2f", pulgadas));
        txtPies.setText(String.format("%.2f", pies));
        txtYardas.setText(String.format("%.2f", yardas));
    }
}
