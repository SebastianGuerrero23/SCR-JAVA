package repetitivas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frm15 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtTexto;

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
        setBounds(0, 0, 400, 200);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblTexto = new JLabel("Ingrese una cadena de texto:");
        lblTexto.setBounds(20, 20, 200, 30);
        getContentPane().add(lblTexto);

        txtTexto = new JTextField();
        txtTexto.setBounds(220, 20, 150, 30);
        getContentPane().add(txtTexto);

        JButton btnMayusculas = new JButton("A Mayúsculas");
        btnMayusculas.setBounds(50, 70, 150, 30);
        getContentPane().add(btnMayusculas);

        JButton btnMinusculas = new JButton("A Minúsculas");
        btnMinusculas.setBounds(220, 70, 150, 30);
        getContentPane().add(btnMinusculas);

        btnMayusculas.addActionListener(e -> convertirAMayusculas());
        btnMinusculas.addActionListener(e -> convertirAMinusculas());
    }

    private void convertirAMayusculas() {
        String texto = txtTexto.getText();
        String resultado = convertirAMayusculas(texto);
        JOptionPane.showMessageDialog(this, "Texto en Mayúsculas: " + resultado);
    }

    private void convertirAMinusculas() {
        String texto = txtTexto.getText();
        String resultado = convertirAMinusculas(texto);
        JOptionPane.showMessageDialog(this, "Texto en Minúsculas: " + resultado);
    }

    private String convertirAMayusculas(String texto) {
        return texto.toUpperCase();
    }

    private String convertirAMinusculas(String texto) {
        return texto.toLowerCase();
    }
}
