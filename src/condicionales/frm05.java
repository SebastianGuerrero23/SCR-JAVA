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

public class frm05 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm05 frame = new frm05();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm05() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número de 4 cifras: ");
        lblNumero.setBounds(50, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(200, 30, 100, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNumero.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNumero);

        JLabel lblResultado = new JLabel("Mayor Número: ");
        lblResultado.setBounds(50, 80, 150, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(200, 80, 100, 30);
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 120, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formarMayorNumero();
            }
        });
    }

    private void formarMayorNumero() {
        int numero = Integer.parseInt(txtNumero.getText());
        
        // Obtener las cifras
        int mil = numero / 1000;
        int centena = (numero / 100) % 10;
        int decena = (numero / 10) % 10;
        int unidad = numero % 10;

        // Encontrar la mayor y menor cifra
        int mayor = Math.max(Math.max(mil, centena), Math.max(decena, unidad));
        int menor = Math.min(Math.min(mil, centena), Math.min(decena, unidad));

        // Formar el número de dos cifras
        int mayorNumero = mayor * 10 + menor;

        // Mostrar el resultado
        txtResultado.setText(String.valueOf(mayorNumero));
    }
}
