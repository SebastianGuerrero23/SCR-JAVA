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

public class frm21 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtEstadoCivil, txtEdad, txtSexo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm21 frame = new frm21();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm21() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número Asignado: ");
        lblNumero.setBounds(50, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JLabel lblEstadoCivil = new JLabel("Estado Civil: ");
        lblEstadoCivil.setBounds(50, 70, 150, 30);
        getContentPane().add(lblEstadoCivil);

        txtEstadoCivil = new JTextField();
        txtEstadoCivil.setBounds(200, 70, 100, 30);
        txtEstadoCivil.setEditable(false);
        getContentPane().add(txtEstadoCivil);

        JLabel lblEdad = new JLabel("Edad: ");
        lblEdad.setBounds(50, 110, 150, 30);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(200, 110, 100, 30);
        txtEdad.setEditable(false);
        getContentPane().add(txtEdad);

        JLabel lblSexo = new JLabel("Sexo: ");
        lblSexo.setBounds(50, 150, 150, 30);
        getContentPane().add(lblSexo);

        txtSexo = new JTextField();
        txtSexo.setBounds(200, 150, 100, 30);
        txtSexo.setEditable(false);
        getContentPane().add(txtSexo);

        JButton btnCalcular = new JButton("Determinar");
        btnCalcular.setBounds(120, 190, 150, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                determinarDatos();
            }
        });
    }

    private void determinarDatos() {
        int numero = Integer.parseInt(txtNumero.getText());
        
        // Extraer las cifras
        int estadoCivil = numero / 1000;
        int edad = (numero / 10) % 100; // Las dos cifras centrales
        int sexo = numero % 10;

        String estadoCivilStr = "";
        switch (estadoCivil) {
            case 1: estadoCivilStr = "Soltero"; break;
            case 2: estadoCivilStr = "Casado"; break;
            case 3: estadoCivilStr = "Divorciado"; break;
            case 4: estadoCivilStr = "Viudo"; break;
            default: estadoCivilStr = "Desconocido"; break;
        }

        String sexoStr = (sexo == 1) ? "Masculino" : (sexo == 2) ? "Femenino" : "Desconocido";

        txtEstadoCivil.setText(estadoCivilStr);
        txtEdad.setText(String.valueOf(edad));
        txtSexo.setText(sexoStr);
    }
}
