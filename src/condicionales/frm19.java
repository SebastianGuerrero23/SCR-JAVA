package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm19 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtSexo, txtEdad, txtCategoria;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm19 frame = new frm19();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm19() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblSexo = new JLabel("Sexo (F/M): ");
        lblSexo.setBounds(50, 30, 150, 30);
        getContentPane().add(lblSexo);

        txtSexo = new JTextField();
        txtSexo.setBounds(150, 30, 50, 30);
        txtSexo.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtSexo);

        JLabel lblEdad = new JLabel("Edad: ");
        lblEdad.setBounds(50, 70, 150, 30);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(150, 70, 50, 30);
        txtEdad.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtEdad);

        JLabel lblCategoria = new JLabel("Categoría: ");
        lblCategoria.setBounds(50, 110, 150, 30);
        getContentPane().add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(150, 110, 100, 30);
        txtCategoria.setEditable(false);
        getContentPane().add(txtCategoria);

        JButton btnCalcular = new JButton("Categorizar");
        btnCalcular.setBounds(150, 160, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                categorizarPostulante();
            }
        });
    }

    private void categorizarPostulante() {
        String sexo = txtSexo.getText().toUpperCase();
        int edad = Integer.parseInt(txtEdad.getText());
        String categoria;

        if (sexo.equals("F")) {
            if (edad < 23) {
                categoria = "FA"; // Mujer menor de 23 años
            } else {
                categoria = "FB"; // Mujer 23 años o más
            }
        } else if (sexo.equals("M")) {
            if (edad < 25) {
                categoria = "MA"; // Varon menor de 25 años
            } else {
                categoria = "MB"; // Varon 25 años o más
            }
        } else {
            categoria = "Sexo no válido"; 
        }

        txtCategoria.setText(categoria);
    }
}
